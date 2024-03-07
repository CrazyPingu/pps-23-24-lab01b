package e1;

public interface ChessPiece {

    /**
     * Move the piece to the given position
     *
     * @param row the row to move to
     * @param col the column to move to
     * @return true if the piece has been moved, false otherwise
     */
    boolean move(int row, int col);

    /**
     * @return the position of the piece
     */
    Pair<Integer, Integer> getPosition();

    /**
     * Set the position of the piece
     *
     * @param position the new position
     */
    void setPosition(Pair<Integer, Integer> position);
}
