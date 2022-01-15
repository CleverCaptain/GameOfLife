package life;

import static java.lang.System.out;

public class Universe {
    private boolean[][] currentState;
    private GenerationAlg generationAlg;

    int countAliveCells() {
        int counter = 0;
        for (boolean[] row : currentState) {
            for (boolean cell : row) {
                if (cell) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public Universe(int size) {
        currentState = new boolean[size][size];
        generationAlg = new GenerationAlg(this);
//        generationAlg.generateRandomInitialState();
    }

    public boolean[][] getCurrentState() {
        return currentState;
    }

    public void setCurrentState(boolean[][] currentState) {
        this.currentState = currentState;
    }

    public GenerationAlg getGenerationAlg() {
        return generationAlg;
    }

    public void setGenerationAlg(GenerationAlg generationAlg) {
        this.generationAlg = generationAlg;
    }

    public void printCurrentState() {
        for (boolean[] cells : currentState) {
            for (boolean cell : cells) {
                out.print(cell ? "O" : " ");
            }
            out.println();
        }
    }

    public boolean[][] getBoard() {
        return currentState;
    }

}
