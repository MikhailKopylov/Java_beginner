package lesson6;

public class Dog extends Animals {

    private final int maxLengthSwim;

    public Dog(String name, int maxLengthRun, int maxLengthSwim) {
        super(name, maxLengthRun);
        this.maxLengthSwim = maxLengthSwim;
    }

    public void swim(int lengthOfBarrier) {
        if (lengthOfBarrier == 0) {
            System.out.println("%d плыть не может");
        } else if (lengthOfBarrier <= maxLengthSwim) {
            System.out.printf("%s проплыл %d метров\n", name, lengthOfBarrier);
        } else {
            System.out.printf("%s может проплыть только %d метров, %d метров - это слишком длинная дистанция\n",
                    name, maxLengthSwim, lengthOfBarrier);
        }
    }
}
