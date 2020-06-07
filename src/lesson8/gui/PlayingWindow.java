package lesson8.gui;

import lesson8.core.GameBoard;
import lesson8.core.enums.ResultGame;
import lesson8.core.enums.TypeCell;

import javax.swing.*;
import java.awt.*;

public class PlayingWindow extends JPanel {

    private MainWindow mainWindow;

    private JButton[][] cells;

    private GameBoard gameBoard;

    public PlayingWindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        setBackground(Color.ORANGE);

        UIManager.put("OptionPane.yesButtonText", "Начать");
        UIManager.put("OptionPane.noButtonText", "Выйти");

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }


    public void startNewGame(int mode, int fieldSize, int winLine) {

        cells = new JButton[fieldSize][fieldSize];

        gameBoard = new GameBoard(fieldSize, winLine);

        drawBoard(fieldSize);

    }

    private void drawBoard(int fieldSize) {
        removeAll();
        GridLayout layout = new GridLayout(fieldSize, fieldSize);
        setLayout(layout);
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                initCell(i, j);
            }
        }
        updateMap();
    }

    private void initCell(int i, int j) {
        cells[i][j] = new JButton();
        add(cells[i][j]);
        final int x = i;
        final int y = j;
        cells[i][j].addActionListener(e -> {
            if (gameBoard.turn(x, y, TypeCell.X)) {
                updateMap();
                if (gameBoard.isWin(TypeCell.X)) {
                    messageGameOver(ResultGame.Win);
                    return;
                }
                gameBoard.aiTurn();
                updateMap();
                if (gameBoard.isWin(TypeCell.O)) {
                    messageGameOver(ResultGame.Loss);
                }

            }
        });
    }

    private void messageGameOver(ResultGame resultGame) {
        int result = -1;
        switch (resultGame) {
            case Win:
                result = JOptionPane.showConfirmDialog(this,
                        "Поздравляем! Вы выиграли!!!\n Начать новую игру?",
                        "Игра окончена", JOptionPane.YES_NO_OPTION);
                break;
            case Loss:

                result = JOptionPane.showConfirmDialog(this, "Вы проиграли!!!\n Начать новую игру?",
                        "Игра окончена", JOptionPane.YES_NO_OPTION);
                break;
            case Draw:
                result = JOptionPane.showConfirmDialog(this, "Ничья.\n Начать новую игру?",
                        "Игра окончена", JOptionPane.YES_NO_OPTION);
                break;
        }
        if (result == JOptionPane.OK_OPTION) {
            mainWindow.setVisible(false);
            mainWindow = new MainWindow();

        } else {
            System.exit(0);
        }
    }

    private void updateMap() {
        TypeCell[][] map = gameBoard.getMap();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                switch (map[i][j]) {
                    case X:
                        cells[i][j].setText("X");
                        break;
                    case O:
                        cells[i][j].setText("O");
                        break;
                    case EMPTY:
                        cells[i][j].setText(".");
                        break;
                }

            }
        }
        mainWindow.repaint();
        mainWindow.revalidate();

    }

}
