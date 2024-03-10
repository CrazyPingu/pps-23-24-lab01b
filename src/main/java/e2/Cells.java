package e2;

/**
 * Represents a cell in the game. Each cell has an external content (like the flag or the number of mines around) and
 * an internal content (like a mine or a number). The external content is what the user sees, and the internal content
 * is what the game uses to check if the user has won or lost.
 */
public interface Cells {

    /**
     * @return the internal content of the cell
     */
    CellType getInternalContent();

    /**
     * @return the external content of the cell
     */
    CellType getExternalContent();

    /**
     * Sets the external content of the cell
     *
     * @param content The new external content
     */
    void setExternalContent(CellType content);

    /**
     * Shows the internal content of the cell
     *
     * @return The internal content of the cell
     */
    CellType showContent();

    /**
     * @return true if the cell has been revealed, false otherwise
     */
    boolean isRevealed();

}
