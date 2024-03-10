package e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    @Test
    public void testGetInternalContent() {
        Cells cells = new CellsImpl(CellType.NUMBER3);
        CellType content = cells.getInternalContent();
        assertEquals(CellType.NUMBER3, content);
    }

    @Test
    public void testGetExternalContentNotShown() {
        Cells cells = new CellsImpl(CellType.NUMBER3);
        CellType content = cells.getExternalContent();
        assertEquals(CellType.EMPTY, content);
    }

    @Test
    public void testSetExternalContent() {
        Cells cells = new CellsImpl(CellType.NUMBER3);
        cells.setExternalContent(CellType.MINE);
        CellType content = cells.getExternalContent();
        assertEquals(CellType.MINE, content);
    }

    @Test
    public void testShowContent() {
        Cells cells = new CellsImpl(CellType.NUMBER3);
        CellType content = cells.showContent();
        assertEquals(CellType.NUMBER3, content);
    }

    @Test
    public void testIsRevealed() {
        Cells cells = new CellsImpl(CellType.NUMBER3);
        boolean revealed = cells.isRevealed();
        assertEquals(cells.getExternalContent(), CellType.EMPTY);
        assertEquals(cells.getInternalContent(), CellType.NUMBER3);
        assertFalse(revealed);
    }

    @Test
    public void testIsRevealedAfterShowContent() {
        Cells cells = new CellsImpl(CellType.NUMBER3);
        cells.showContent();
        boolean revealed = cells.isRevealed();
        assertTrue(revealed);
    }
}
