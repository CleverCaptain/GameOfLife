package life;

import java.io.IOException;

public class GameOfLife {
    public static void main(String[] args) throws IOException {
        int size = 60;

        Universe board = new Universe(size);
        GameWindow window = new GameWindow();
        ListenActions listener = new ListenActions();
        listener.setWindow(window);
        listener.start();
        GameController controller = new GameController(board, window, size);
        controller.start();
    }
}
