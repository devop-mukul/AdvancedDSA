class minFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;
        int min = Integer.MAX_VALUE;

        for (int col = 0; col < n; col++) {
            min = Math.min(min, recur(matrix, 0, col));
        }

        return min;
    }

    public int recur(int[][] matrix, int row, int col) {

        int n = matrix.length;

        if (col < 0 || col >= n) {
            return Integer.MAX_VALUE;
        }

        if (row == n - 1) {
            return matrix[row][col];
        }

        int down = recur(matrix, row + 1, col);
        int leftDiag = recur(matrix, row + 1, col - 1);
        int rightDiag = recur(matrix, row + 1, col + 1);

        return matrix[row][col] + Math.min(down, Math.min(leftDiag, rightDiag));
    }
}