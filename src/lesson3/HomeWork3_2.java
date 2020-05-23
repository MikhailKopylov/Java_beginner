package lesson3;

import java.util.Random;
import java.util.Scanner;

public class HomeWork3_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};

        int secretIndex = new Random().nextInt(words.length);
        String secretWord = words[secretIndex];
        System.out.println("Угадайте задуманное компьютером слово: ");
        int countAttempted = 0;

        while (true) {
            countAttempted++;
            String answerWord = scanner.next();

            if (isWin(secretWord, answerWord)) {
                System.out.printf("Поздравляем! Вы угадали с %d попытки!", countAttempted);
                return;
            } else {
                System.out.println("Ответ неверный, вот буквы, положение которых было угадано:");
            }

            char[] secretChars = secretWord.toCharArray();
            char[] answerChars = answerWord.toCharArray();

            char[] printChars = getPrintChars(secretChars, answerChars);

            System.out.println(printChars);
        }


    }

    private static char[] getPrintChars(char[] secretChars, char[] answerChars) {
        char[] printChars = new char[15];

        for (int i = 0; i < printChars.length; i++) {
            if ((i < secretChars.length) && (i < answerChars.length)) {
                if (secretChars[i] == answerChars[i]) {
                    printChars[i] = secretChars[i];
                }else {
                    printChars[i] = '#';
                }
            } else {
                printChars[i] = '#';
            }
        }
        return printChars;
    }

    private static boolean isWin(String secretWord, String answerWord) {
        return secretWord.equals(answerWord);
    }
}
