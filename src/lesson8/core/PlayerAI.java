package lesson8.core;

import javafx.util.Pair;
import lesson8.core.enums.TypeCell;

import java.util.Random;

public class PlayerAI {

    private final int sizeMap;

    private final TypeCell typeCell;

    private final Random random = new Random();

    public PlayerAI(TypeCell typeCell, int sizeMap) {
        this.typeCell = typeCell;
        this.sizeMap = sizeMap;
    }

    public TypeCell getTypeCell() {
        return typeCell;
    }

    public Pair<Integer, Integer> aiTurn(){
        int x = random.nextInt(sizeMap);
        int y = random.nextInt(sizeMap);
        return new Pair<>(x, y);
    }


}
