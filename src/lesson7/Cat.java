package lesson7;

public class Cat {

    private final String name;
    private final int amountOfEat;
    private boolean satiety;

    public Cat(String name, int amountOfEat) {
        this.name = name;
        this.amountOfEat = amountOfEat;
        satiety = false;
    }

    public void eat(Plate plate) {
        if (!isSatiety() && plate.canEat(amountOfEat)) {
            plate.decreaseFood(amountOfEat);
            satiety = true;
            System.out.println(name + " eat...");
        } else {
            System.out.println(name + " not eat...");

        }
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    public String getName() {
        return name;
    }

    public String isSatietyInfo(){
        if(isSatiety()){
            return "satiety";
        } else {
            return "hungry";
        }
    }

}
