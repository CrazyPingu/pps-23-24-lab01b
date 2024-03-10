package e1;

public abstract class ChessPieceAbstract implements ChessPiece {

    private Pair<Integer, Integer> position;

    public ChessPieceAbstract(Pair<Integer, Integer> position) {
        this.position = position;
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }

    @Override
    public void setPosition(Pair<Integer, Integer> position) {
        this.position = position;
    }

}
