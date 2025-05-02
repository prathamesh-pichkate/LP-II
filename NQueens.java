public class NQueens {

    static int count = 0;

    public static void nQueens(char[][] board, int row, boolean[] columns, boolean[] diag1, boolean[] diag2) {
        int n = board.length;
        if (row == n) {
            print(board);
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col + n - 1;
            int d2 = row + col;

            if (!columns[col] && !diag1[d1] && !diag2[d2]) {
                // Place queen
                board[row][col] = 'Q';
                columns[col] = diag1[d1] = diag2[d2] = true;

                nQueens(board, row + 1, columns, diag1, diag2);

                // Backtrack
                board[row][col] = 'X';
                columns[col] = diag1[d1] = diag2[d2] = false;
            }
        }
    }

    public static void print(char[][] board) {
        System.out.println("-----------chess board------");
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }

        // Add branch and bound arrays
        boolean[] columns = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];

        nQueens(board, 0, columns, diag1, diag2);

        System.out.println("The total counts are : " + count);
    }
}
