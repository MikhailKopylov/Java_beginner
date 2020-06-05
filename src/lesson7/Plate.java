package lesson7;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }


    public void decreaseFood(int eatFood) {
        if (canEat(eatFood)) {
            food -= eatFood;
        }
    }

    public void info() {
        System.out.println("Plate: " + food);
    }

    public boolean canEat(int amountOfEat) {
        return amountOfEat > 0 && food > amountOfEat;
    }

    public void addFood(int amountFood){
        if(amountFood > 0){
            food += amountFood;
        }
    }
}
