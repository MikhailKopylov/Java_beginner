package lesson7a;

import javax.swing.*;

public class Calculator extends JFrame {

    private static final int START_X = 40;
    private static final int START_Y = 0;

    private final JLabel labelResult;
    private final JTextField textFieldSecondNumber;
    private final JTextField textFieldFirstNumber;

    public Calculator() {
        setBounds(400, 300, 600, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Калькулятор");

        setLayout(null);


        JLabel labelFirstNumber = new JLabel("<html><b>Введите первое число</b></html>");
        labelFirstNumber.setBounds(START_X, START_Y, 200, 40);
        add(labelFirstNumber);
        textFieldFirstNumber = new JTextField();
        textFieldFirstNumber.setBounds(START_X, START_Y + 30, 200, 40);
        add(textFieldFirstNumber);

        JLabel labelSecondNumber = new JLabel("<html><b>Введите второе число</b></html>");
        labelSecondNumber.setBounds(START_X, START_Y + 80, 200, 40);
        add(labelSecondNumber);
        textFieldSecondNumber = new JTextField();
        textFieldSecondNumber.setBounds(START_X, START_Y + 110, 200, 40);
        add(textFieldSecondNumber);

        JButton buttonPlus = new JButton("+");
        buttonPlus.setBounds(START_X, START_Y + 200, 50, 50);
        buttonPlus.addActionListener(e -> calculate('+'));
        add(buttonPlus);

        JButton buttonMinus = new JButton("-");
        buttonMinus.setBounds(START_X + 80, START_Y + 200, 50, 50);
        buttonMinus.addActionListener(e -> calculate('-'));
        add(buttonMinus);

        JButton buttonMultiply = new JButton("*");
        buttonMultiply.setBounds(START_X + 160, START_Y + 200, 50, 50);
        buttonMultiply.addActionListener(e -> calculate('*'));
        add(buttonMultiply);

        JButton buttonDivide = new JButton("/");
        buttonDivide.setBounds(START_X + 240, START_Y + 200, 50, 50);
        buttonDivide.addActionListener(e -> calculate('/'));
        add(buttonDivide);

        JLabel labelAnswer = new JLabel("<html><b>Результат </b></html>");
        labelAnswer.setBounds(START_X, START_Y + 300, 200, 40);
        add(labelAnswer);

        labelResult = new JLabel("0");
        labelResult.setBounds(START_X, START_Y + 315, 600, 40);
        add(labelResult);

        setVisible(true);
    }

    private void calculate(char operation) {
        double firstNumberDouble;
        double secondNumberDouble;
        String result ;

        String getFirstNumber = textFieldFirstNumber.getText();
        String getSecondNumber = textFieldSecondNumber.getText();

        firstNumberDouble = Double.parseDouble(getFirstNumber);
        secondNumberDouble = Double.parseDouble(getSecondNumber);

        result = getResultCalculate(operation, firstNumberDouble, secondNumberDouble);

        labelResult.setText(result);
    }

    private String getResultCalculate(char operation, double firstNumber, double secondNumber) {
        String result = "";
        switch (operation) {
            case '+':
                result = String.valueOf(firstNumber + secondNumber);
                break;
            case '-':
                result = String.valueOf(firstNumber - secondNumber);
                break;
            case '*':
                result = String.valueOf(firstNumber * secondNumber);
                break;
            case '/':
                if (secondNumber != 0) {
                    result = String.valueOf(firstNumber / secondNumber);
                } else {
                    result = "Error!";
                }
                break;
        }
        return firstNumber + " " + operation + " " + secondNumber + " = " + result;
    }

}
