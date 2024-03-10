package e2;

import java.util.Map;

/**
 * Represents a grid of cells.
 */
public interface Grid {

    /**
     * @return a map of cells, where the key is the position of the cell and the value is the cell itself.
     */

    Map<Pair<Integer, Integer>, Cells> getCells();

    /**
     * Reveals the cell at the given position.
     * If the cell contains no mines around it, it will reveal all the surrounding cells.
     *
     * @param pos the position of the cell to reveal.
     * @return the content of the cell.
     */
    CellType revealCellAt(Pair<Integer, Integer> pos);

    /**
     * @param pos the position of the cell to get the external content from.
     * @return the external content of the cell at the given position.
     */
    CellType getCellExternalContent(Pair<Integer, Integer> pos);

    /**
     * Sets the external content of the cell at the given position.
     *
     * @param pos     the position of the cell to set the external content to.
     * @param content the content to set.
     */
    void setCellExternalContent(Pair<Integer, Integer> pos, CellType content);

    /**
     * Reveals all the mines in the grid.
     */
    void revealAllMines();
}
