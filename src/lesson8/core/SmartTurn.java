package lesson8.core;

import lesson8.core.enums.TypeCell;

public class SmartTurn {

    private final CheckWin checkWin;

    private final int sizeMap;
    private final TypeCell[][] map;

    private int coordinate_X;
    private int coordinate_Y;

    public SmartTurn(GameBoard gameBoard, int winningLine) {
        this.map = gameBoard.getMap();
        sizeMap = gameBoard.size_map;
        checkWin = new CheckWin(map, winningLine);
    }

    public boolean checkCanWin(TypeCell typeCell) {
        for (int i = 0; i < sizeMap; i++) {
            for (int j = 0; j < sizeMap; j++) {
                if (map[i][j] == TypeCell.EMPTY) {
                    map[i][j] = typeCell;
                    if (checkWin.checkWin(typeCell)) {
                        coordinate_X = i;
                        coordinate_Y = j;
                        map[i][j] = TypeCell.EMPTY;
                        return true;
                    }
                    map[i][j] = typeCell.reverseTypeCell();

                    if (checkWin.checkWin(typeCell.reverseTypeCell())){
                        coordinate_X = i;
                        coordinate_Y = j;
                        map[i][j] = TypeCell.EMPTY;
                        return true;
                    }
                    map[i][j] = TypeCell.EMPTY;
                }
            }
        }
        return false;
    }



    public int getCoordinate_X() {
        return coordinate_X;
    }

    public int getCoordinate_Y() {
        return coordinate_Y;
    }
}
