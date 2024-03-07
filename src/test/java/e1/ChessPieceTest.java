package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test the correct functionality of the chess pieces
 */
public class ChessPieceTest {

    @Test
    public void testMovePawn() {
        Pawn pawn = new Pawn(new Pair<>(0, 0));
        assertFalse(pawn.move(0, 0));
    }

    @Test
    public void testMoveKnight() {
        Knight knight = new Knight(new Pair<>(0, 0), 5);
        assertFalse(knight.move(0, 0));
        assertFalse(knight.move(1, 1));

        assertTrue(knight.move(2, 1));
        assertTrue(knight.move(4, 2));
        assertFalse(knight.move(4, 2));
    }
}
