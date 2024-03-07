package e1;

import java.util.*;

public class LogicsImpl implements Logics {

    private final Pawn pawn;
    private final ChessPieceAbstract knight;
    private final PositionGenerator pg = new PositionGeneratorImpl();
    private final int size;

    public LogicsImpl(int size) {
        this.size = size;
        Pair<Integer, Integer> knightPos = this.randomEmptyPosition();
        this.knight = new Knight(knightPos, size);
        this.pawn = new Pawn(this.randomEmptyPosition());
    }

    public LogicsImpl(int size, Pair<Integer, Integer> pawnPos, Pair<Integer, Integer> knightPos) {
        this.size = size;
        this.pawn = new Pawn(pawnPos);
        this.knight = new Knight(knightPos, size);
    }

    private Pair<Integer, Integer> randomEmptyPosition() {
        List<Pair<Integer, Integer>> occupiedPosition = new ArrayList<>();
        if (this.knight != null) {
            occupiedPosition.add(this.knight.getPosition());
        }
        if (this.pawn != null) {
            occupiedPosition.add(this.pawn.getPosition());
        }
        return this.pg.getRandomEmptyPosition(this.size, occupiedPosition);
    }

    @Override
    public boolean hit(int row, int col) {
        knight.move(row, col);
        return knight.getPosition().equals(pawn.getPosition());

    }

    @Override
    public boolean hasKnight(int row, int col) {
        return this.knight.getPosition().equals(new Pair<>(row, col));
    }

    @Override
    public boolean hasPawn(int row, int col) {
        return this.pawn.getPosition().equals(new Pair<>(row, col));
    }
}
