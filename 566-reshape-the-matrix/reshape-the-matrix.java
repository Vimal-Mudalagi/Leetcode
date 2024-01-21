class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(mat.length * mat[0].length != r * c) {
            return mat;
        }
        int arr[][] = new int[r][c];
        int m = 0;
        int n = 0;
        for(int i = 0; i <mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if(n == c) {
                    n = 0;
                    m++;
                }
                arr[m][n++] = mat[i][j];
            }
        }
        return arr;
    }
}