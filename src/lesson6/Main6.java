package lesson6;

public class Main6 {

    public static void main(String[] args) {
        Cat catBarsik = new Cat("Barsik", 200);
        Dog dogSharik = new Dog("Sharik", 400, 10);
        Dog dogTuzik = new Dog("Tuzik", 600, 15);

        catBarsik.run(100);
        catBarsik.run(300);
        System.out.println();

        dogSharik.run(150);
        dogSharik.run(500);
        dogSharik.swim(7);
        dogSharik.swim(15);
        System.out.println();

        dogTuzik.run(213);
        dogTuzik.run(888);
        dogTuzik.swim(8);
        dogTuzik.swim(25);
        System.out.println();
    }
}
