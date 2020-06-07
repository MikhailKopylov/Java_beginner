package lesson8.gui;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    static final int WINDOW_POS_X = 400;
    static final int WINDOW_POS_Y = 400;
    static final int WINDOW_WIDTH = 505;
    static final int WINDOW_HEIGHT = 555;

    private final SettingsWindow settingsWindow;
    private final PlayingWindow playingWindow;


    public MainWindow() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Крестики-нолики");


        settingsWindow = new SettingsWindow(this);

        playingWindow = new PlayingWindow(this);
        add(playingWindow, BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(1, 2));

        JButton buttonStartNewGame = new JButton("Начать новую игру");
        panel.add(buttonStartNewGame);
        buttonStartNewGame.addActionListener(e -> settingsWindow.setVisible(true));

        JButton buttonGameOver = new JButton("Закончить игру");
        panel.add(buttonGameOver);
        buttonGameOver.addActionListener(e -> System.exit(0));

        add(panel, BorderLayout.SOUTH);

        settingsWindow.setVisible(true);
    }

    public void startNewGame(int mode, int fieldSize, int winLine) {
//        if (playingBoard != null){
//            playingBoard.removeAll();
//
//        }
//        playingBoard = new PlayingBoard(this, mode, fieldSize, winLine);
//        add(playingBoard, BorderLayout.CENTER);
//        repaint();
        playingWindow.startNewGame(mode, fieldSize, winLine);
        setVisible(true);

    }
}
