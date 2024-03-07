package e1;

/**
 * Represents a knight chess piece
 */
public class Knight extends ChessPieceAbstract {

    int size;

    public Knight(Pair<Integer, Integer> position, int size) {
        super(position);
        this.size = size;
    }

    @Override
    public boolean move(int row, int col) {
        if (row < 0 || col < 0 || row >= this.size || col >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        int x = row - this.getPosition().getX();
        int y = col - this.getPosition().getY();
        if (x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == 3) {
            setPosition(new Pair<>(row, col));
            return true;
        }
        return false;
    }

}
