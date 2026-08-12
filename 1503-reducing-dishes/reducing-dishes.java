class Solution {
    private int solve(int[] satisfaction,int i,int time,int[][] dp){
        //baseCase
        if(i==satisfaction.length){
            return 0;
        }
        if(dp[i][time]!=-1){
            return dp[i][time];
        }
        //recursion
        int cook = satisfaction[i]*time + solve(satisfaction,i+1,time+1,dp);
        // don't cook dish i
        int dontCook = solve(satisfaction,i+1,time,dp);
        return dp[i][time] = Math.max(cook,dontCook);
    }
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int[][] dp = new int[satisfaction.length+1][satisfaction.length+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(satisfaction,0,1,dp);
    }
}