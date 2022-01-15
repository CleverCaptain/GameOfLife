package life;

import javax.swing.*;
import java.awt.*;

public class ListenActions extends Thread {
    GameWindow window;

    public void setWindow(GameWindow window) {
        this.window = window;
    }

    @Override
    public void run() {
        window.getOneGenerationButton().addActionListener(e -> {
            GameController.isRunning = true;
            try {
                sleep(GameController.updateSpeed);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            GameController.isRunning = false;
        });
        window.getPauseResumeButton().addActionListener(
              e -> GameController.isRunning = !GameController.isRunning);
        window.getResetButton().addActionListener(
              e -> GameController.isReset = !GameController.isReset);
        window.getSpeedSlider().addChangeListener(e -> {
            int slideValue = window.getSpeedSlider().getValue();
            GameController.updateSpeed = 2000 - slideValue;
            GameController.updateSpeed = Math.max(10, GameController.updateSpeed);
        });
        window.getColorButton().addActionListener(e -> {
            Color color = JColorChooser.showDialog(window.getCellColorChooser(),
                    "Select a color", GameCell.cellColor);
            window.getCellsPanel().setColor(color);
        });
    }

}
