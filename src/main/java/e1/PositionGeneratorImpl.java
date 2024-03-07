package e1;

import java.util.List;
import java.util.Random;

public class PositionGeneratorImpl implements PositionGenerator{
    private final Random random;

    public PositionGeneratorImpl() {
        this.random = new Random();
    }

    @Override
    public Pair<Integer, Integer> getRandomEmptyPosition(int size, List<Pair<Integer, Integer>> occupiedPosition) {
        Pair<Integer, Integer> pos = new Pair<>(random.nextInt(size), random.nextInt(size));
        if (occupiedPosition.size() == size * size) {
            return new Pair<>(-1, -1);
        }
        while (occupiedPosition.contains(pos)) {
            pos = new Pair<>(random.nextInt(size), random.nextInt(size));
        }
        return pos;
    }
}
