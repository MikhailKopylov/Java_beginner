package lesson8.core;

import lesson8.core.enums.TypeCell;

public class CheckWin {

    private final TypeCell[][] map;
    private final int winningLine;
    private final int sizeMap;

    public CheckWin( TypeCell[][] map, int winningLine) {
        this.map = map;
        this.winningLine = winningLine;
        sizeMap = map.length;
    }

    public boolean checkWin(TypeCell typeCell) {
        for (int i = 0; i < sizeMap; i++) {
            for (int j = 0; j < sizeMap; j++) {
                if (checkWinLine(typeCell, j, i, 1, 0) == winningLine) {
                    return true;
                }

                if (checkWinLine(typeCell, j, i, -1, 1) == winningLine) {
                    return true;
                }

                if (checkWinLine(typeCell, j, i, 0, 1) == winningLine) {
                    return true;
                }

                if (checkWinLine(typeCell, j, i, 1, 1) == winningLine) {
                    return true;
                }
            }
        }
        return false;
    }

    private int checkWinLine(TypeCell typeCell, int coordinate_X, int coordinate_Y, int changeCoordinateX, int changeCoordinateY) {
        int win = 0;
        for (int i = 0; i < winningLine; i++) {
            int newCoordinateX = coordinate_X + changeCoordinateX * i;
            int newCoordinateY = coordinate_Y + changeCoordinateY * i;
            if (isCoordinatesInMap(newCoordinateX, newCoordinateY)) {
                if (map[newCoordinateY][newCoordinateX] == typeCell) {
                    win++;
                } else {
                    win = 0;
                    break;
                }
            } else {
                break;
            }
        }
        return win;
    }

    private boolean isCoordinatesInMap(int changeCoordinateX, int changeCoordinateY) {
        return (changeCoordinateX < sizeMap) && (changeCoordinateX >= 0) &&
                (changeCoordinateY < sizeMap) && (changeCoordinateY >= 0);
    }
}
