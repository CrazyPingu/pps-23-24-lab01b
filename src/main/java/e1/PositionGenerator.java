package e1;

import java.util.List;

public interface PositionGenerator {

    /**
     * Returns a random empty position
     *
     * @param size the size of the board
     * @param occupiedPosition the list of occupied positions
     * @return a random empty position if there is any, otherwise returns a pair of -1
     */
    Pair<Integer,Integer> getRandomEmptyPosition(int size, List<Pair<Integer, Integer>> occupiedPosition);



}
