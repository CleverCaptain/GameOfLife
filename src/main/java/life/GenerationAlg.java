package life;

import java.util.Random;

public class GenerationAlg {
    private final Universe universe;

    public GenerationAlg(Universe universe) {
        this.universe = universe;
    }

    public void nextGeneration() {
        int len = universe.getCurrentState().length;
        boolean[][] nextState = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (!universe.getCurrentState()[i][j]) {
                    nextState[i][j] = countNeighbors(i, j) == 3;
                } else {
                    nextState[i][j] = countNeighbors(i, j) == 3 || countNeighbors(i, j) == 2;
                }
            }
        }
        universe.setCurrentState(nextState);
    }


    private boolean findNeighbor(Neighbour neighbor, int x, int y) {
        int xAxis = x + neighbor.getX();
        int yAxis = y + neighbor.getY();
        int len = universe.getCurrentState().length;

        xAxis = xAxis < 0 ? len + xAxis % len : xAxis % len;
        yAxis = yAxis < 0 ? len + yAxis % len : yAxis % len;

        return universe.getCurrentState()[xAxis][yAxis];
    }

    private int countNeighbors(int x, int y) {
        int count = 0;

        for (Neighbour n : Neighbour.values()) {
            if (findNeighbor(n, x, y)) {
                count++;
            }
        }

        return count;
    }

    public void generateRandomInitialState() {
        Random random = new Random();
        int len = universe.getCurrentState().length;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                universe.getCurrentState()[i][j] = random.nextBoolean();
            }
        }
    }
}
