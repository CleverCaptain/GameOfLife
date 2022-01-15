package life;

import javax.swing.*;
import java.awt.*;

public class GameCell extends JPanel {
    private boolean alive;
    static Color cellColor = Color.BLACK;

    public GameCell() {
        super();
        setVisible(false);
        setBackground(cellColor);
    }

    void setCellColor(Color color) {
        setBackground(color);
    }

    //sets living/dead status of cell
    public void setAlive(boolean alive) {
        this.alive = alive;
        setVisible(this.alive);
    }

    //returns living/dead status of cell
    public boolean isAlive() {return alive;}
}
