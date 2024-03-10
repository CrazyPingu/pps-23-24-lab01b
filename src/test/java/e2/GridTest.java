package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridTest {

    private Grid grid;

    @BeforeEach
    public void setUp() {
        grid = new GridImpl(5, 5);
    }

    @Test
    public void testSetAndGetExternalContent() {
        grid.setCellExternalContent(new Pair<>(0, 0), CellType.MINE);
        grid.setCellExternalContent(new Pair<>(0, 1), CellType.MINE);
        assertEquals(grid.getCellExternalContent(new Pair<>(0, 0)), CellType.MINE);
    }

    @Test
    public void testRevealCellAt() {
        // in case there is no CellType value inside the cell
        assertEquals(grid.revealCellAt(new Pair<>(0, 0)),
                CellType.fromContent(String.valueOf(grid.revealCellAt(new Pair<>(0, 0)).getContent())));
    }

    @Test
    public void testRevealAllMines() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                grid.setCellExternalContent(new Pair<>(i, j), CellType.MINE);
            }
        }
        grid.revealAllMines();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                assertEquals(grid.getCellExternalContent(new Pair<>(i, j)), CellType.MINE);
            }
        }
    }
}
