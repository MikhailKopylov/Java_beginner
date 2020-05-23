package lesson3;

import java.util.Random;
import java.util.Scanner;

public class HomeWork3_1 {

    public static final int NUMBER_OF_ATTEMPTED = 3;
    public static final int MAX_NUMBER = 9;
    public static final int CONTINUE = 1;
    public static final int EXIT = 0;

    public static void main(String[] args) {

        guessNumber();


    }

    private static void guessNumber() {
        Scanner scanner = new Scanner(System.in);
        String moreOrLess;
        while (true) {
            boolean win = false;
            int secretNumber = new Random().nextInt(MAX_NUMBER);
            System.out.println("Поробуйте угадать загаданное число от 0 до 9 с трех попыток");

            for (int i = 0; i < NUMBER_OF_ATTEMPTED; i++) {

                System.out.printf("Попытка №%d. Введите число: ", i + 1);
                int answerNumber = scanner.nextInt();

                if (isWin(secretNumber, answerNumber)) {
                    System.out.println("Поздравляем! Вы выиграли!");
                    win = true;
                    break;
                }

                moreOrLess = getMoreOrLess(secretNumber, answerNumber);
                System.out.printf("Загаданное число %s чем %d\n", moreOrLess, answerNumber);
            }

            if (!win) {
                System.out.println("К сожалению угадать число не получилось. Правильный ответ " + secretNumber);
            }

            while (true) {
                System.out.printf("Повторить игру еще раз? %d – да / %d – нет\n", CONTINUE, EXIT);
                int exit = scanner.nextInt();
                if (exit == CONTINUE) {
                    break;
                } else if (exit == EXIT) {
                    return;
                }
            }
        }
    }

    private static String getMoreOrLess(int secretNumber, int answerNumber) {
        String moreOrLess;
        if(answerNumber < secretNumber){
            moreOrLess = "больше";
        } else {
            moreOrLess ="меньше";
        }
        return moreOrLess;
    }

    private static boolean isWin(int secretNumber, int answerNumber) {
        return answerNumber == secretNumber;
    }
}
