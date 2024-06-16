import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    private final int rows = 4;
    private final int cols = 4;
    private final Cell[][] cells;
    public boolean situation = false;

    public Board() {
        cells = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public void display() {
        System.out.println("\n \n \n ");
        for (int i = 0; i < rows; i++) {
            System.out.print("\t \t \t \t \t \t \t \t \t \t \t \t");
            for (int j = 0; j < cols; j++) {
                System.out.print(cells[i][j].number + "\t  ");
            }
            System.out.println("");
            System.out.println("");
        }
    }

    public void generateNew() {
        boolean control;
        Random rand = new Random();
        while (true) {
            int randomRow = rand.nextInt(4);
            int randomCol = rand.nextInt(4);
            control = false;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (randomRow == i && randomCol == j) {
                        if (this.cells[i][j].number == 0) {
                            this.cells[i][j].number = 2;
                        } else {
                            control = true;
                            break;
                        }
                    }
                }
                if (control == true)
                    break;
            }
            if (control == false)
                break;
        }
    }

    public boolean isGameOver() {
        if (isBoardFull() && !isEqualNumber()) {
            return true;
        }
        return false;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (this.cells[i][j].number == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isEqualNumber() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j + 1 < cols) {
                    if (cells[i][j].number == cells[i][j + 1].number) {
                        return true;
                    }
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i + 1 < cols) {
                    if (cells[j][i].number == cells[j][i + 1].number) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void moveUp() {
        List<Cell> list = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            list.clear();
            for (int j = 0; j < cols; j++) {
                list.add(cells[j][i]);
            }
            for (int k = 0; k < list.size(); k++) {
                if (k + 1 < list.size()) {
                    if (list.get(k).number == 0) {
                        list.remove(k);
                        k--;
                        continue;
                    }
                    if (list.get(k + 1).number == 0) {
                        list.remove(k + 1);
                        k--;
                        continue;
                    }
                    if (list.get(k).number == list.get(k + 1).number) {
                        list.get(k).number *= 2;
                        list.remove(k + 1);
                    }
                }
            }
            while (true) {
                if (list.size() != 4) {
                    list.add(new Cell());
                } else {
                    break;
                }
            }
            for (int d = 0; d < list.size(); d++) {
                if (cells[d][i] != list.get(d)) {
                    situation = true;
                }
                cells[d][i] = list.get(d);
            }
        }
    }

    public void moveDown() {
        List<Cell> list = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            list.clear();
            for (int j = 0; j < cols; j++) {
                list.add(cells[j][i]);
            }
            list = list.reversed();
            for (int k = 0; k < list.size(); k++) {
                if (k + 1 < list.size()) {
                    if (list.get(k).number == 0) {
                        list.remove(k);
                        k--;
                        continue;
                    }
                    if (list.get(k + 1).number == 0) {
                        list.remove(k + 1);
                        k--;
                        continue;
                    }
                    if (list.get(k).number == list.get(k + 1).number) {
                        list.get(k).number *= 2;
                        list.remove(k + 1);
                    }
                }
            }
            while (true) {
                if (list.size() != rows) {
                    list.add(new Cell());
                } else {
                    break;
                }
            }
            list = list.reversed();
            for (int d = 0; d < list.size(); d++) {
                if (cells[d][i] != list.get(d)) {
                    situation = true;
                }
                cells[d][i] = list.get(d);
            }
        }
    }

    public void moveLeft() {
        List<Cell> list = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            list.clear();
            for (int j = 0; j < cols; j++) {
                list.add(cells[i][j]);
            }
            for (int k = 0; k < list.size(); k++) {
                if (k + 1 < list.size()) {
                    if (list.get(k).number == 0) {
                        list.remove(k);
                        k--;
                        continue;
                    }
                    if (list.get(k + 1).number == 0) {
                        list.remove(k + 1);
                        k--;
                        continue;
                    }
                    if (list.get(k).number == list.get(k + 1).number) {
                        list.get(k).number *= 2;
                        list.remove(k + 1);
                    }
                }
            }
            while (true) {
                if (list.size() != 4) {
                    list.add(new Cell());
                } else {
                    break;
                }
            }
            for (int d = 0; d < list.size(); d++) {
                if (cells[d][i] != list.get(d)) {
                    situation = true;
                }
                cells[i][d] = list.get(d);
            }
        }
    }

    public void moveRight() {
        List<Cell> list = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            list.clear();
            for (int j = 0; j < cols; j++) {
                list.add(cells[i][j]);
            }
            list = list.reversed();
            for (int k = 0; k < list.size(); k++) {
                if (k + 1 < list.size()) {
                    if (list.get(k).number == 0) {
                        list.remove(k);
                        k--;
                        continue;
                    }
                    if (list.get(k + 1).number == 0) {
                        list.remove(k + 1);
                        k--;
                        continue;
                    }
                    if (list.get(k).number == list.get(k + 1).number) {
                        list.get(k).number *= 2;
                        list.remove(k + 1);
                    }
                }
            }
            while (true) {
                if (list.size() != 4) {
                    list.add(new Cell());
                } else {
                    break;
                }
            }
            list = list.reversed();
            for (int d = 0; d < list.size(); d++) {
                if (cells[d][i] != list.get(d)) {
                    situation = true;
                }
                cells[i][d] = list.get(d);
            }
        }
    }
}