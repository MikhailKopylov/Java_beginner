public class Main {

    public static void main(String[] args) {

        vars();

        System.out.println(calc(3, 2, 10, 5));

        System.out.println(checkSum(5, 15));

        positiveOrNegative(-21);

        System.out.println(isNegative(-21));

        hello("Николай");

        bissextileYear(2000);


    }

    private static void bissextileYear(int year) {
        String no;
        if (isMultiple(year, 4)) {
            if (isMultiple(year, 100)) {
                if (isMultiple(year, 400)) {
                    no = "";
                } else {
                    no = "не";
                }
            } else {
                no = "";
            }
        } else {
            no = "не";
        }
        System.out.printf("%d год %s является високосным", year, no);
    }

    private static boolean isMultiple(int year, int divisor) {
        return year % divisor == 0;
    }


    private static double calc(int a, int b, int c, double d) {
        return a * (b + (c / d));
    }


    private static boolean checkSum(int a, int b) {
        int sum = a + b;
        return (10 <= sum) && (sum <= 20);
    }

    private static void positiveOrNegative(int a) {
        if(a < 0){
            System.out.println("Отрицательное");
        } else {
            System.out.println("Положительное");
        }
    }

    private static boolean isNegative(int a) {
        return a < 0;
    }

    private static void hello(String name) {
        System.out.printf("Привет, %s!\n", name);
    }

    private static void vars() {
        byte bt = 1;
        short st = 2;
        int it = 3;
        long lg = 5L;

        float ft = 8f;
        double dl = 13;

        char cr = 'v';
        String string = "34";

        boolean isTrue = true;
    }


}
