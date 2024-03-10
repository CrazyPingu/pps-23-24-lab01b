package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogicTest {
    private Logics logics;

    @BeforeEach
    public void setUp() {
        this.logics = new LogicsImpl(5, 5);
    }

    @Test
    public void testRevealCell() {
        assertEquals(logics.revealCell(new Pair<>(0, 0)),
                CellType.fromContent(String.valueOf(logics.revealCell(new Pair<>(0, 0)).getContent())));
    }

    @Test
    public void testToggleFlag() {
        logics.toggleFlag(new Pair<>(0, 0));
        assertEquals(CellType.FLAG, logics.getExternalContent(new Pair<>(0, 0)));
        logics.toggleFlag(new Pair<>(0, 0));
        assertEquals(CellType.EMPTY, logics.getExternalContent(new Pair<>(0, 0)));
    }

    @Test
    public void testRevealAllMines() {
        logics = new LogicsImpl(5, 25);
        logics.revealAllMines();
        assertEquals(CellType.MINE, logics.revealCell(new Pair<>(0, 0)));
    }

    @Test
    public void testIsMinePressed() {
        logics = new LogicsImpl(5, 25);
        assertTrue(logics.isMinePressed(new Pair<>(0, 0)));
    }

}
