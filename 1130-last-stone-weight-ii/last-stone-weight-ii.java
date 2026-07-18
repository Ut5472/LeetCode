class Solution {
    private int minVal(int[] stones,int i,int sum,int[][] dp,int totalSum){
        if(i==stones.length){
            return Math.abs(sum);
        }
        if(dp[i][totalSum+sum]!=-1){
            return dp[i][totalSum+sum];
        }
        int positive = minVal(stones,i+1,sum+stones[i],dp,totalSum);
        int negative = minVal(stones,i+1,sum-stones[i],dp,totalSum);
        dp[i][totalSum+sum] = Math.min(positive,negative);
        return dp[i][totalSum+sum];
    }
    public int lastStoneWeightII(int[] stones){
        int sum = 0;
        for(int i=0;i<stones.length;i++){
            sum += stones[i];
        }
        int[][] dp = new int[stones.length+1][sum*2];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return minVal(stones,0,0,dp,sum);
    }
}