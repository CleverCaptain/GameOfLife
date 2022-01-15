package life;

public class UpdateThread extends Thread {
    Universe universe;
    GameWindow window;
    int generation;
    public UpdateThread(Universe universe, GameWindow window, int gen) {
        this.universe = universe;
        this.window = window;
        this.generation = gen;
    }

    public void run() {
        window.getGenLabel().setText("Generation #" + generation);
        window.getGenLabel().repaint();
        //updates alive label
        window.getAliveLabel().setText("Alive: " + universe.countAliveCells());
        window.getAliveLabel().repaint();
        //calls update method of LifePanel
        window.getLifePanel().updateCellArray(universe.getBoard());

    }
}
