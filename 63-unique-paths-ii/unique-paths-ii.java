class Solution {
    private int solve(int[][] grid ,int i,int j,int[][] dp){
        if(i==grid.length-1 && j==grid[0].length-1){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans = 0;
        //move down
        if(i!=grid.length-1 && grid[i+1][j]!=1){
            ans += solve(grid,i+1,j,dp);
        }
        //move right
        if(j!=grid[0].length-1 && grid[i][j+1]!=1){
            ans += solve(grid,i,j+1,dp);
        }
        return dp[i][j] = ans;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int i=0;
        int j=0;
        int[][] dp = new int[obstacleGrid.length+1][obstacleGrid[0].length+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        if(obstacleGrid[0][0]==1){
            return 0;
        }
        return solve(obstacleGrid,i,j,dp);
    }
}