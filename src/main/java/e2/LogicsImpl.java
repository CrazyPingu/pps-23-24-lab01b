package e2;

public class LogicsImpl implements Logics {

    private final Grid grid;
    private final int bombNumber;

    public LogicsImpl(int size, int bombNumber) {
        this.bombNumber = bombNumber;
        grid = new GridImpl(size, bombNumber);
    }

    @Override
    public CellType revealCell(Pair<Integer, Integer> pos) {
        return grid.revealCellAt(pos);
    }

    @Override
    public void toggleFlag(Pair<Integer, Integer> pos) {
        if (grid.getCellExternalContent(pos).equals(CellType.FLAG)) {
            grid.setCellExternalContent(pos, CellType.EMPTY);
        } else if (grid.getCellExternalContent(pos).equals(CellType.EMPTY)){
            grid.setCellExternalContent(pos, CellType.FLAG);
        }
    }

    @Override
    public CellType getExternalContent(Pair<Integer, Integer> pos) {
        return grid.getCellExternalContent(pos);
    }

    @Override
    public void revealAllMines() {
        grid.revealAllMines();
    }

    @Override
    public boolean isMinePressed(Pair<Integer, Integer> pos) {
        return  revealCell(pos) == CellType.MINE;
    }

    @Override
    public boolean hasWon() {
        int size = (int) Math.sqrt(grid.getCells().size());
        int cellsWithoutMines = size * size - bombNumber;
        int cellsRevealed = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Pair<Integer, Integer> pos = new Pair<>(i, j);
                if (grid.getCellExternalContent(pos) != CellType.EMPTY && grid.getCellExternalContent(pos) != CellType.FLAG) {
                    cellsRevealed++;
                }
            }
        }
        return cellsRevealed == cellsWithoutMines;

    }
}
