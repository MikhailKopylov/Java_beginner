package lesson7;

public class Main7 {

    public static void main(String[] args) {

        Cat[] cats = {
                new Cat("Barsik", 30),
                new Cat("Tima", 38),
                new Cat("Myrka", 46),
                new Cat("Simba", 26),
                new Cat("Molly", 29)
        };
        Plate plate = new Plate(100);

        feedCats(cats, plate);

        System.out.println("--------------------------");

        plate.addFood(30);

        feedCats(cats, plate);


    }

    private static void feedCats(Cat[] cats, Plate plate) {
        plate.info();
        System.out.println();

        for (Cat cat :cats) {
            cat.eat(plate);
        }

        System.out.println();
        plate.info();
        System.out.println();

        for (Cat cat :cats) {
            System.out.println(cat.getName() + " is " + cat.isSatietyInfo());
        }
    }
}
