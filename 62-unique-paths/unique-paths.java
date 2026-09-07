class Solution {
    private int solve(int m,int n,int[][] dp){
        if(m == 0 && n == 0){
            return 1;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        int ans = 0;
        if(m!=0){
        ans += solve(m-1,n,dp);
        }
        if(n!=0){
        ans += solve(m,n-1,dp);
        }
        return dp[m][n] = ans ;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(m-1,n-1,dp);
    }
}