package e1;

/**
 * Represents a knight chess piece
 */
public class Pawn extends ChessPieceAbstract {

    public Pawn(Pair<Integer, Integer> position) {
        super(position);
    }

    @Override
    public boolean move(int row, int col) {
        return false;
    }
}
