package lesson8.core;

import lesson8.core.enums.TypeCell;

public class PlayerHuman {

    private TypeCell typeCell;

    public PlayerHuman(TypeCell typeCell) {
        this.typeCell = typeCell;
    }

    public TypeCell getTypeCell() {
        return typeCell;
    }


}
