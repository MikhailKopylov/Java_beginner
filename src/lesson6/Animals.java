package lesson6;

public abstract class Animals {

    protected String name;
    protected int maxLengthRun;


    public Animals(String name, int maxLengthRun) {
        this.name = name;
        this.maxLengthRun = maxLengthRun;
    }

    public void run(int lengthOfBarrier){
        if (maxLengthRun == 0) {
            System.out.println("%d бежать не может");
        } else if (lengthOfBarrier <= maxLengthRun) {
            System.out.printf("%s пробежал %d метров\n", name, lengthOfBarrier);
        } else {
            System.out.printf("%s может пробежать только %d метров, %d метров - это слишком длинная дистанция\n",
                    name, maxLengthRun, lengthOfBarrier);
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
