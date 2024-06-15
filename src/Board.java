import java.util.Random;

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
    }
    public void display()
    {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(cells[i][j].number +"  ");
            }
            System.out.println("");
            System.out.println("");
        }
    }
    public void generateNew()
    {
        boolean control;
        Random rand = new Random();
        while(true)
        {
            int randomRow = rand.nextInt(4);
            int randomCol = rand.nextInt(4);
            control = false;
            for (int i = 0; i < rows; i++) 
            {
                for (int j = 0; j < cols; j++) {
                    if(randomRow == i && randomCol == j)
                    {
                        if(this.cells[i][j].number == 0)
                        {
                            this.cells[i][j].number = 2;
                        }
                        else
                        {
                            control = true;
                            break;
                        }
                    }
                }
                if(control == true)
                    break;
            }
            if(control == false)
                break;
        }
    }
    public boolean isGameOver()
    {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(this.cells[i][j].number == 0)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public void moveUp()
    {
        generateNew();
        display();
    }
    public void moveDown()
    {
        generateNew();
        display();
    }
    public void moveLeft()
    {
        generateNew();
        display();
    }
    public void moveRight()
    {
        generateNew();
        display();
    }
}