package lesson8.core;

import javafx.util.Pair;
import lesson8.core.enums.TypeCell;

import java.util.Arrays;

import static lesson8.core.enums.TypeCell.*;

public class GameBoard {

    final int size_map;

    private final TypeCell[][] map;
    private final PlayerAI playerAI;

    private final SmartTurn smartTurn;
    private final CheckWin checkWin;


    public GameBoard(int sizeMap, int winningLine) {
        size_map = sizeMap;
        this.map = new TypeCell[size_map][size_map];

        initMap();
        playerAI = new PlayerAI(O, sizeMap);

        smartTurn = new SmartTurn(this, winningLine);
        checkWin = new CheckWin(map, winningLine);
    }

    private void initMap() {
        for (TypeCell[] typeCells : map) {
            Arrays.fill(typeCells, EMPTY);
        }
    }

    public boolean turn(int x, int y, TypeCell typeCell) {
        if (isCellValid(x, y)) {
            map[x][y] = typeCell;
            return true;
        }
        return false;
    }

    public boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= size_map || y >= size_map) {
            return false;
        }
        return map[x][y] == EMPTY;
    }

    public TypeCell[][] getMap() {
        return map;
    }

    public void aiTurn() {
        Pair<Integer, Integer> turn;
        int x;
        int y;
        do {
            if(smartTurn.checkCanWin(playerAI.getTypeCell())){
                x = smartTurn.getCoordinate_X();
                y = smartTurn.getCoordinate_Y();
                break;
            }else {
                turn = playerAI.aiTurn();
                x = turn.getKey();
                y = turn.getValue();
            }
        } while ((!isCellValid(x, y)) && !isMapFull());
        turn(x, y, playerAI.getTypeCell());
    }

    private boolean isMapFull() {
        for (TypeCell[] row : map) {
            for (TypeCell cell : row) {
                if (cell == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isWin(TypeCell typeCell){
        return checkWin.checkWin(typeCell);
    }

}
