class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
         List<Integer> result = new ArrayList<>();

        int m = matrix.length;    
        int n = matrix[0].length; 
        int[] minInRow = new int[m];
        for (int i = 0; i < m; i++) {
            int minRow = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                minRow = Math.min(minRow, matrix[i][j]);
            }
            minInRow[i] = minRow;
        }
        int[] maxInCol = new int[n];
        for (int j = 0; j < n; j++) {
            int maxCol = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                maxCol = Math.max(maxCol, matrix[i][j]);
            }
            maxInCol[j] = maxCol;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == minInRow[i] && matrix[i][j] == maxInCol[j]) {
                    result.add(matrix[i][j]);
                }
            }
        }
        return result;
    }
}