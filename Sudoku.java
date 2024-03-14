public class Sudoku {
    private int[][] sudokuTable;
    private static final int rank = 9;
    private boolean correctColumns[];

    public Sudoku(int[][] sudokuTable) {
        this.sudokuTable = sudokuTable;
        correctColumns = new boolean[rank + 1];
    }

    public int[][] getSudokuTable() {
        return sudokuTable;
    }

    public void setSudokuTable(int[][] sudokuTable) {
        this.sudokuTable = sudokuTable;
    }

    private boolean checkUnique(int row, int column) {
        for (int i = 0; i < rank; i++) {
            if ((sudokuTable[row][i] == sudokuTable[row][column]) && column != i) {

                return false;
            }
        }
        for (int i = 0; i < rank; i++) {
            if ((sudokuTable[i][column] == sudokuTable[row][column]) && row != i) {
                return false;
            }
        }
        correctColumns[column] = true;
        return true;
    }

    public boolean fillSquare(int row, int column, int number) {
        this.sudokuTable[row][column] = number;
        return checkUnique(row, column);
    }

    public boolean checkSolved() {
        int[] numbersCount = new int[rank];
        for (int i = 0; i < rank; i++) {
            for (int j = 0; j < rank; j++) {
                numbersCount[sudokuTable[i][j] - 1]++;
            }
        }
        for (int i = 0; i < rank; i++) {
            if (numbersCount[i] > 9) {
                return false;
            }
        }
        return true;
    }
}