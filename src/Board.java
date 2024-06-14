public class Board {
    private final int rows=4;
    private final int cols=4;
    private final Cell[][] cells;
    public Board()
    {
        cells= new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new Cell();
            }
        }
        yazdir();
    }
    public void yazdir()
    {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(cells[i][j].number +"  ");
            }
            System.out.println("");
            System.out.println("");
        }
    }
}