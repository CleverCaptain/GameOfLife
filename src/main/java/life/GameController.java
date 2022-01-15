package life;

public class GameController extends Thread {
    Universe universe;
    GameWindow window;
    int size;
    static volatile boolean isRunning = true;
    static volatile boolean isReset = false;
    static volatile long updateSpeed = 1000;

    public GameController(Universe universe, GameWindow window, int size) {
        this.universe = universe;
        this.window = window;
        this.size = size;
    }

    public void run() {
        while (true) {
            int gen = 0;
            universe.getGenerationAlg().generateRandomInitialState();
            while (!isReset) {
                if (isRunning) {
                    var updater = new UpdateThread(universe, window, gen);
                    updater.start();
                    try {
                        updater.join();
                    } catch (InterruptedException ex) {
                        System.out.println("error");
                    }

                    universe.getGenerationAlg().nextGeneration();
                    gen++;

                    try {
                        sleep(updateSpeed);
                    } catch (InterruptedException ex) {
                        System.out.println("error");
                    }
                }
            }
            window.resetGame();
            isReset = false;
        }
    }
}
