package e1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test the correct functionality of the logic class
 */
public class LogicTest {

    @Test
    public void testKnightHit() {
        Pair<Integer, Integer> knightPos = new Pair<>(2, 2);
        Pair<Integer, Integer> pawnPos = new Pair<>(0, 3);
        Logics logics = new LogicsImpl(5, pawnPos, knightPos);

        assertTrue(logics.hit(pawnPos.getX(), pawnPos.getY()));
        assertFalse(logics.hit(knightPos.getX(), knightPos.getY()));
        assertFalse(logics.hit(0, 0));
        assertFalse(logics.hit(1, 1));
    }

    @Test
    public void checkKnightPresence() {
        Logics logics = new LogicsImpl(5);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (logics.hasKnight(i, j)) {
                    assertTrue(logics.hasKnight(i, j));
                }
            }
        }
    }

    @Test
    public void checkPawnPresence() {
        Logics logics = new LogicsImpl(5);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (logics.hasPawn(i, j)) {
                    assertTrue(logics.hasPawn(i, j));
                }
            }
        }
    }

}
