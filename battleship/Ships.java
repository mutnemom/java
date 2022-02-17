package battleship;

public class Ships {
    String name;
    int length;
    int startRow;
    int endRow;
    int startColumn;
    int endColumn;

    public Ships (String name, int length) {
        this.name = name;
        this.length = length;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public int getStartColumn() {
        return startColumn;
    }

    public void setStartColumn(int startColumn) {
        this.startColumn = startColumn;
    }

    public int getEndColumn() {
        return endColumn;
    }

    public void setEndColumn(int endColumn) {
        this.endColumn = endColumn;
    }


    public String getName() {

        return name;
    }

    public int getLength() {

        return length;
    }


}

