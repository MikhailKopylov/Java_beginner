package lesson8.gui;

import javax.swing.*;
import java.awt.*;

public class SettingsWindow extends JFrame {

    private static final int WINDOW_POS_X = MainWindow.WINDOW_POS_X + 50;
    private static final int WINDOW_POS_Y = MainWindow.WINDOW_POS_Y + 50;
    private static final int WINDOW_WIDTH = MainWindow.WINDOW_WIDTH - 100;
    private static final int WINDOW_HEIGHT = 400;

    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;

    private static final int MODE_H_VS_A = 0;
    private static final int MODE_H_VS_H = 1;


    private final JRadioButton radioButtonHvsAi = new JRadioButton("Человек против компьютера", true);
    private final JRadioButton radioButtonHvsH = new JRadioButton("Человек против человека");
    private final ButtonGroup gameMode = new ButtonGroup();

    private final JSlider sliderFieldsCount = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
    private final JSlider sliderWinLine = new JSlider(MIN_FIELD_SIZE, MIN_FIELD_SIZE, MIN_FIELD_SIZE);

    public SettingsWindow(MainWindow mainWindow) {
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Настройки игры");

        setLayout(new GridLayout(8, 1));

        add(new JLabel("Выберите режим игры"));
        add(radioButtonHvsAi);
        add(radioButtonHvsH);
        gameMode.add(radioButtonHvsAi);
        gameMode.add(radioButtonHvsH);

        add(new JLabel("Установите размер игрового поля"));
        sliderFieldsCount.setMajorTickSpacing(1);
        sliderFieldsCount.setPaintLabels(true);
        sliderFieldsCount.setPaintTicks(true);
        add(sliderFieldsCount);


        add(new JLabel("Установите количетво фишек для выигрыша"));
        sliderWinLine.setMajorTickSpacing(1);
        sliderWinLine.setPaintLabels(true);
        sliderWinLine.setPaintTicks(true);
        add(sliderWinLine);

        sliderFieldsCount.addChangeListener(e -> sliderWinLine.setMaximum(sliderFieldsCount.getValue()));

        JButton buttonStartNewGame = new JButton("Начать игру");
        buttonStartNewGame.setBackground(Color.PINK);
        add(buttonStartNewGame);

        buttonStartNewGame.addActionListener(e -> {
            setVisible(false);

            int mode;
            if (radioButtonHvsAi.isSelected()) {
                mode = MODE_H_VS_A;
            } else {
                mode = MODE_H_VS_H;
            }

            int fieldSize = sliderFieldsCount.getValue();
            int winLane = sliderWinLine.getValue();

            mainWindow.startNewGame(mode, fieldSize, winLane);

        });

    }
}
