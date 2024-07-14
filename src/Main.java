import com.nawab.snakeLadder.board.Board;
import com.nawab.snakeLadder.mode.ConsoleMode;
import com.nawab.snakeLadder.mode.FileMode;
import com.nawab.snakeLadder.mode.Mode;
import com.nawab.snakeLadder.model.Dice;
import com.nawab.snakeLadder.service.SnakeLadderService;


public class Main {
    public static void main(String[] args) {
        Dice dice = new Dice();
        Board board = new Board();
        SnakeLadderService snakeLadderService = new SnakeLadderService(board, dice);

        Mode mode;
        if(args.length==1){
            mode = new FileMode(snakeLadderService, args[0]);
        } else{
            mode = new ConsoleMode(snakeLadderService);
        }
        mode.getInput();
        mode.initialSetup();
        mode.startGame();

    }
}