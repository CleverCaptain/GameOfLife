package life;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

public class GameWindow extends JFrame {
    private JPanel infoPanel;
    private JPanel controlsPanel;
    private GameCellsPanel cellsPanel;
    private JLabel generationsLabel;
    private JLabel aliveLabel;
    private JButton oneGenerationButton;
    private JToggleButton pauseResumeButton;
    private JButton resetButton;
    private JSlider speedSlider;
    private JColorChooser cellColorChooser;
    private JButton colorButton;

    public GameWindow() throws IOException {
        super("Game Of Life");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(920, 700);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        controlsPanel = new JPanel();
        controlsPanel.setName("Control Panel");
        controlsPanel.setLayout(new BoxLayout(controlsPanel, BoxLayout.X_AXIS));
        add(controlsPanel, BorderLayout.PAGE_START);


        infoPanel = new JPanel();
        infoPanel.setName("Info Panel");
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        add(infoPanel, BorderLayout.WEST);

        generationsLabel = new JLabel();
        generationsLabel.setText("Generations #0");
        generationsLabel.setName("GenerationLabel");
        generationsLabel.setFont(generationsLabel.getFont().deriveFont(18F));
        infoPanel.add(generationsLabel);

        aliveLabel = new JLabel();
        aliveLabel.setText("Alive: 0");
        aliveLabel.setFont(aliveLabel.getFont().deriveFont(18F));
        aliveLabel.setName("AliveLabel");
        infoPanel.add(aliveLabel);

        cellsPanel = new GameCellsPanel();
        cellsPanel.setName("Game Cells Panel");
        cellsPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4, false));
        add(cellsPanel);

        Image rightArrow = ImageIO.read(new     FileInputStream(".\\RightArrowIcon.png"));
        oneGenerationButton = new JButton();
        oneGenerationButton.setIcon(new ImageIcon(rightArrow));
        oneGenerationButton.setName("Move one step button");
        controlsPanel.add(oneGenerationButton);

        Image pause = ImageIO.read(new FileInputStream(".\\PauseIcon.png"));
        pauseResumeButton = new JToggleButton();
        pauseResumeButton.setName("PlayToggleButton");
        pauseResumeButton.setIcon(new ImageIcon(pause));
        controlsPanel.add(pauseResumeButton);

        Image reset = ImageIO.read(new FileInputStream(".\\ResetIcon.png"));
        resetButton = new JButton();
        resetButton.setName("ResetButton");
        resetButton.setIcon(new ImageIcon(reset));
        controlsPanel.add(resetButton);

        speedSlider = new JSlider(JSlider.HORIZONTAL, 0, 2000, 1000);
        speedSlider.setMinorTickSpacing(10);
        speedSlider.setMajorTickSpacing(100);
        speedSlider.setPaintTicks(true);
        speedSlider.setPaintLabels(true);
//        speedSlider.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5, false));
        controlsPanel.add(speedSlider);

        colorButton = new JButton();
        colorButton.setText("Click to Choose Color");
        infoPanel.add(colorButton);

        cellColorChooser = new JColorChooser(GameCell.cellColor);

        setVisible(true);
    }

    void resetGame() {
        generationsLabel.setText("Generations #0");
        generationsLabel.setName("GenerationLabel");
        generationsLabel.setFont(generationsLabel.getFont().deriveFont(18F));

        aliveLabel.setText("Alive: 0");
        aliveLabel.setFont(aliveLabel.getFont().deriveFont(18F));
        aliveLabel.setName("AliveLabel");
    }

    public GameCellsPanel getLifePanel() {return cellsPanel;}

    public JLabel getGenLabel() {return generationsLabel;}

    public JLabel getAliveLabel() {return aliveLabel;}

    public JPanel getInfoPanel() {
        return infoPanel;
    }

    public JPanel getControlsPanel() {
        return controlsPanel;
    }

    public GameCellsPanel getCellsPanel() {
        return cellsPanel;
    }

    public JLabel getGenerationsLabel() {
        return generationsLabel;
    }

    public JButton getOneGenerationButton() {
        return oneGenerationButton;
    }

    public JToggleButton getPauseResumeButton() {
        return pauseResumeButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public JSlider getSpeedSlider() {
        return speedSlider;
    }

    public JColorChooser getCellColorChooser() {
        return cellColorChooser;
    }

    public JButton getColorButton() {
        return colorButton;
    }
}
