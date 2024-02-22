class Solution {
    int[][] grid;
    int m;
    int n;
    public int getMaximumGold(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int max = 0;
        this.grid = grid;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]!=0)
                    max = Math.max(DFS(i,j,new int[m][n]),max);
            }
        return max;
    }
    int DFS(int i, int j, int[][] visited )
    {

        int[] x = new int[]{1,-1,0,0};
        int[] y = new int[]{0,0,1,-1};
        visited[i][j] = 1;
        int max = 0;
        for(int k=0;k<4;k++)
        {
            int xCor = i+x[k];
            int yCor = j+y[k];
            if(xCor>=0 && xCor<m && yCor>=0 && yCor<n && visited[xCor][yCor]==0 && grid[xCor][yCor]!=0)
            {
                max = Math.max(DFS(xCor,yCor,visited),max);
                visited[xCor][yCor] = 0;
            }
        }
        return max+grid[i][j];
    }
}