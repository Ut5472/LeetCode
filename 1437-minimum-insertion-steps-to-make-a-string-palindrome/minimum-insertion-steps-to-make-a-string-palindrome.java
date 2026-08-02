class Solution {
    private int solve(String s,int i,int j,int[][] dp){
        //base case
        if(i>=j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        //recursion
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j] = solve(s,i+1,j-1,dp);
        }else{
            return dp[i][j] = 1+Math.min(solve(s,i,j-1,dp),solve(s,i+1,j,dp));
        }

    }
    public int minInsertions(String s) {
        int[][] dp = new int[s.length()+1][s.length()+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(s,0,s.length()-1,dp);
    }
}