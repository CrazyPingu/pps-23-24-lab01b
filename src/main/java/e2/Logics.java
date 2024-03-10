package e2;

/**
 * Represents the logic of the game
 */
public interface Logics {


    /**
     * Reveals the cell at the given position. If the cell do not have any mine around,
     * it will reveal all the cells around it
     *
     * @param pos The position to reveal
     * @return The content of the cell
     */
    CellType revealCell(Pair<Integer, Integer> pos);

    /**
     * Toggle the flag at the given position
     *
     * @param pos The position to toggle the flag
     */
    void toggleFlag(Pair<Integer, Integer> pos);

    /**
     * Get what the cell is displaying
     *
     * @param pos The position of the cell
     * @return The content of the cell
     */
    CellType getExternalContent(Pair<Integer, Integer> pos);

    /**
     * Reveal all the mines
     */
    void revealAllMines();

    /**
     * Click the button and check if the cell is a mine
     *
     * @param pos The position of the cell
     * @return True if the cell is a mine, false otherwise
     */
    boolean isMinePressed(Pair<Integer, Integer> pos);

    /**
     * Check if the player has won
     *
     * @return True if the player has won, false otherwise
     */
    boolean hasWon();
}
