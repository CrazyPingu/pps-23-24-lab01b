package e1;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Test the correct functionality of the position generator
 */
public class PositionGeneratorTest {

    @Test
    public void testIgnoreOccupiedPosition() {
        PositionGenerator pg = new PositionGeneratorImpl();
        List<Pair<Integer, Integer>> occupiedPosition = List.of(new Pair<>(0, 0), new Pair<>(0, 1), new Pair<>(1, 0));
        for (int i = 0; i < 100; i++) {
            Pair<Integer, Integer> pos = pg.getRandomEmptyPosition(3, occupiedPosition);
            assert !occupiedPosition.contains(pos) && pos.getX() != -1 && pos.getY() != -1;
        }
    }
}
