package life;

import javax.swing.*;
import java.awt.*;

public class GameCellsPanel extends JPanel {
    GameCell[][] cellArray;

    public GameCellsPanel() {
        super();
    }

    public void initialize(int dimension) {
        this.setLayout(new GridLayout(dimension, dimension, 1, 1));
        this.cellArray = new GameCell[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                cellArray[i][j] = new GameCell();
                this.add(cellArray[i][j]);
            }
        }
    }

    void setColor(Color color) {
        for (GameCell[] gameCells : cellArray) {
            for (GameCell gameCell : gameCells) {
                gameCell.setCellColor(color);
            }
        }
    }

    public void updateCellArray(boolean[][] board) {
        if (cellArray != null) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (cellArray[i][j].isAlive() != board[i][j]) {
                        cellArray[i][j].setAlive(board[i][j]);
                    }
                }
            }
            repaint();
        } else {
            initialize(board.length);
            updateCellArray(board);
        }
    }
}
