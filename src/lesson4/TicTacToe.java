package lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static final int SIZE_MAP = 5;
    static final int WINNING_LINE = 4;


    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char[][] map;

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    static int coordinate_X;
    static int coordinate_Y;

    public static void main(String[] args) {
        initMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();

            if (checkWin(DOT_X)) {
                System.out.println("Ты победил!");
                break;
            }

            if (isFull()) {
                System.out.println("Ничья");
                break;
            }

            aiTurn();
            printMap();

            if (checkWin(DOT_O)) {
                System.out.println("Компьютер победил!");
                break;
            }

            if (isFull()) {
                System.out.println("Ничья");
                break;
            }
        }
    }

    public static void initMap() {
        map = new char[SIZE_MAP][SIZE_MAP];
        for (int i = 0; i < SIZE_MAP; i++) {
            for (int j = 0; j < SIZE_MAP; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 0; i < SIZE_MAP; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE_MAP; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE_MAP; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void humanTurn() {
        int x, y;

        do {
            System.out.println("Введите координаты вашего хода X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (isCellValid(y, x));
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x >= SIZE_MAP || y >= SIZE_MAP) {
            return true;
        }
        return map[y][x] != DOT_EMPTY;
    }

    public static void aiTurn() {
        int x, y;

        do {
            if (checkCanWin(DOT_O)) {
                x = coordinate_X;
                y = coordinate_Y;
            } else if (checkCanWin(DOT_X)){
                x = coordinate_X;
                y = coordinate_Y;
            } else {
                x = random.nextInt(SIZE_MAP);
                y = random.nextInt(SIZE_MAP);

            }
        } while (isCellValid(y, x));
        map[y][x] = DOT_O;
    }



    private static boolean checkCanWin(char dot) {
        for (int i = 0; i < SIZE_MAP; i++) {
            for (int j = 0; j < SIZE_MAP; j++) {
                if (map[j][i] == DOT_EMPTY) {
                    map[j][i] = dot;
                    if (checkWin(dot)) {
                        coordinate_X = i;
                        coordinate_Y = j;
                        map[j][i] = DOT_EMPTY;
                        return true;
                    }
                map[j][i] = DOT_EMPTY;
                }
            }
        }
        return false;
    }

    public static boolean isFull() {
        for (int i = 0; i < SIZE_MAP; i++) {
            for (int j = 0; j < SIZE_MAP; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean checkWin(char c) {
        for (int i = 0; i < SIZE_MAP; i++) {
            for (int j = 0; j < SIZE_MAP; j++) {
                if (checkWinLine(c, j, i, 1, 0) == WINNING_LINE) {
                    return true;
                }

                if (checkWinLine(c, j, i, -1, 1) == WINNING_LINE) {
                    return true;
                }

                if (checkWinLine(c, j, i, 0, 1) == WINNING_LINE) {
                    return true;
                }

                if (checkWinLine(c, j, i, 1, 1) == WINNING_LINE) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int checkWinLine(char c, int coordinate_X, int coordinate_Y, int changeCoordinateX, int changeCoordinateY) {
        int win = 0;
        for (int i = 0; i < WINNING_LINE; i++) {
            int newCoordinateX = coordinate_X + changeCoordinateX * i;
            int newCoordinateY = coordinate_Y + changeCoordinateY * i;
            if (isCoordinatesInMap(newCoordinateX, newCoordinateY)) {
                if (map[newCoordinateY][newCoordinateX] == c) {
                    win++;
                } else {
                    win = 0;
                    break;
                }
            } else {
                break;
            }
        }
        return win;
    }

    private static boolean isCoordinatesInMap(int changeCoordinateX, int changeCoordinateY) {
        return (changeCoordinateX < SIZE_MAP) && (changeCoordinateX >= 0) &&
                (changeCoordinateY < SIZE_MAP) && (changeCoordinateY >= 0);
    }
}
