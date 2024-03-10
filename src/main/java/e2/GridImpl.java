package e2;

import java.util.HashMap;
import java.util.Map;

public class GridImpl implements Grid {

    private final Map<Pair<Integer, Integer>, Cells> grid;

    public GridImpl(int size, int bombNumber) {
        this.grid = new HashMap<>();
        placeMines(size, bombNumber);
        placeNumbers(size);
    }

    private void placeMines(int size, int bombNumber) {
        while (bombNumber > 0) {
            int x = (int) (Math.random() * size);
            int y = (int) (Math.random() * size);
            if (grid.get(new Pair<>(x, y)) == null) {
                grid.put(new Pair<>(x, y), new CellsImpl(CellType.MINE));
                bombNumber--;
            }
        }
    }

    private void placeNumbers(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid.get(new Pair<>(i, j)) == null) {
                    int mines = 0;
                    for (int k = i - 1; k <= i + 1; k++) {
                        for (int l = j - 1; l <= j + 1; l++) {
                            if (k >= 0 && k < size && l >= 0 && l < size) {
                                if (grid.get(new Pair<>(k, l)) != null && grid.get(new Pair<>(k, l)).getInternalContent().equals(CellType.MINE)) {
                                    mines++;
                                }
                            }
                        }
                    }
                    grid.put(new Pair<>(i, j), new CellsImpl(CellType.fromContent(String.valueOf(mines))));
                }
            }
        }
    }

    @Override
    public Map<Pair<Integer, Integer>, Cells> getCells() {
        return grid;
    }

    @Override
    public CellType revealCellAt(Pair<Integer, Integer> pos) {
        CellType content = grid.get(pos).showContent();

        if (content.equals(CellType.NUMBER0)) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int newX = pos.getX() + i;
                    int newY = pos.getY() + j;

                    if (isValidCoordinate(newX, newY) && !grid.get(new Pair<>(newX, newY)).isRevealed()) {
                        revealCellAt(new Pair<>(newX, newY));
                    }
                }
            }
        }
        return content;
    }

    private boolean isValidCoordinate(int x, int y) {
        int size = (int) Math.sqrt(grid.size());
        return x >= 0 && x < size && y >= 0 && y < size;
    }

    @Override
    public CellType getCellExternalContent(Pair<Integer, Integer> pos) {
        return grid.get(pos).getExternalContent();
    }

    @Override
    public void setCellExternalContent(Pair<Integer, Integer> pos, CellType content) {
        grid.get(pos).setExternalContent(content);
    }

    @Override
    public void revealAllMines() {
        grid.forEach((k, v) -> {
            if (v.getInternalContent().equals(CellType.MINE)) {
                v.setExternalContent(CellType.MINE);
            }
        });
    }
}
