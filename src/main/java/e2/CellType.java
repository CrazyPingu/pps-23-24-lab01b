package e2;

/**
 * Represents the type of cell in the minesweeper game.
 */
public enum CellType {

    MINE("*"),
    EMPTY(""),
    FLAG("F"),
    NUMBER0("0"),
    NUMBER1("1"),
    NUMBER2("2"),
    NUMBER3("3"),
    NUMBER4("4"),
    NUMBER5("5"),
    NUMBER6("6"),
    NUMBER7("7"),
    NUMBER8("8");

    private final String content;

    CellType(String content) {
        this.content = content;
    }

    public static CellType fromContent(String content) {
        for (CellType type : values()) {
            if (type.content.equals(content)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid content: " + content);
    }

    public String getContent() {
        return content;
    }
}
