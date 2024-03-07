package e1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

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

}
