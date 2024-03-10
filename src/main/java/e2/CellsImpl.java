package e2;

public class CellsImpl implements Cells {

    private final CellType internalContent;
    private CellType externalContent;

    public CellsImpl(CellType content) {
        this.internalContent = content;
        this.externalContent = CellType.EMPTY;
    }

    @Override
    public CellType getInternalContent() {
        return internalContent;
    }

    @Override
    public CellType getExternalContent() {
        return externalContent;
    }

    @Override
    public void setExternalContent(CellType content) {
        externalContent = content;
    }

    @Override
    public CellType showContent() {
        setExternalContent(internalContent);
        return internalContent;
    }

    @Override
    public boolean isRevealed() {
        return externalContent == internalContent;
    }
}
