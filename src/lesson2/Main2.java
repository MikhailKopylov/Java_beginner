package lesson2;

import java.util.Random;

public class Main2 {

    public static final int MAX_DIGIT = 50;

    public static void main(String[] args) {

        task1();

        task2();

        task3();

        task4();

        task5();

        task6();

        task7();
    }

    private static void task7() {
        int offset = 1;
        int[] array = {1, 2, 3, 4, 5, 6};
        print(array);
        offsetArray(array, offset);
        print(array);
    }

    private static void offsetArray(int[] array, int offset) {
        if(offset > 0){
            offsetToLeft(array, offset);
        } else if (offset < 0){
            offsetToRight(array, Math.abs(offset));
        }


    }

    private static void offsetToLeft(int[] array, int offset) {
        for (int i = 0; i < offset; i++) {
            int temp = array[0];
            for (int j = 1; j < array.length; j++) {
                array[j - 1] = array[j];
            }
            array[array.length - 1] = temp;
        }
    }

    private static void offsetToRight(int[] array, int offset) {
        for (int i = 0; i < offset; i++) {
            int temp = array[array.length - 1];
            for (int j = array.length - 1; j > 0; j--) {
                array[j] = array[j - 1];
            }
            array[0] = temp;
        }
    }

    private static void task6() {
        int[] array1 = {2, 2, 2, 1, 2, 2, 10, 1};
        int[] array2 = {1, 1, 1, 2, 1};
        int[] array3 = {1, 1, 1, 2, 1, 1};

        if (isBalanced(array1)) {
            System.out.println("Array is balanced");
            ;
        } else {
            System.out.println("Array is not balabced");
        }

        if (isBalanced(array2)) {
            System.out.println("Array is balanced");
            ;
        } else {
            System.out.println("Array is not balabced");
        }


        if (isBalanced(array3)) {
            System.out.println("Array is balanced");
            ;
        } else {
            System.out.println("Array is not balabced");
        }
    }

    private static boolean isBalanced(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (sum(array, 0, i) == sum(array, i, array.length)) {
                return true;
            }
        }
        return false;
    }

    private static int sum(int[] array, int indexStart, int indexFinish) {
        int result = array[indexStart];
        for (int i = indexStart + 1; i < indexFinish; i++) {
            result += array[i];
        }
        return result;
    }

    private static void task5() {
        Random random = new Random();
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * MAX_DIGIT);
        }
        print(array);
        System.out.printf("Minimum number = %d\n", min(array));
        System.out.printf("Maximum number = %d\n", max(array));
    }

    private static int min(int[] array) {
        int min = array[0];
        for (int value : array) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    private static int max(int[] array) {
        int max = array[0];
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    private static void task4() {
        int size = 15;
        int[][] arrTable = new int[size][size];
        for (int i = 0; i < arrTable.length; i++) {
            arrTable[i][i] = 1;
            arrTable[i][arrTable.length - i - 1] = 1;
        }
        printTable(arrTable);
    }


    private static void task3() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        print(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        print(arr);
    }

    private static void task2() {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }

        print(arr);
    }


    private static void task1() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        print(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }

        print(arr);
    }

    private static void print(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    private static void printTable(int[][] arrTable) {
        for (int i = 0; i < arrTable.length; i++) {
            for (int j = 0; j < arrTable[i].length; j++) {
                System.out.print(arrTable[i][j] + " ");
            }
            System.out.println();
        }
    }
}
