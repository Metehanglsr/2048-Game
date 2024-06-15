public class Game {
    private Board b1;
    
    public Game()
    {
        Board board = new Board();
        this.b1 = board;
    }
    public void gameStart()
    {
        this.b1.generateNew();
        this.b1.generateNew();
        this.b1.display();
    }
}
