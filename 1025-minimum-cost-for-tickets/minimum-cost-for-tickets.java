class Solution {
    private int minCostCalc(int[] days,int[] costs,int ValidTill,int i,int[][] dp){
        //baseCase
        if(i==days.length){
            return 0;
        }
        if(dp[ValidTill][i]!=-1){
            return dp[ValidTill][i];
        }
        //recursionstarts
        if(ValidTill<days[i]){
            int pass1 = costs[0] + minCostCalc(days,costs,days[i],i+1,dp);
            int pass7 = costs[1] + minCostCalc(days,costs,days[i]+6,i+1,dp);
            int pass30 = costs[2] + minCostCalc(days,costs,days[i]+29,i+1,dp);
            return dp[ValidTill][i] = Math.min(pass1,Math.min(pass7,pass30));
        }else{
            return dp[ValidTill][i] = minCostCalc(days,costs,ValidTill,i+1,dp);
        }
    }
    public int mincostTickets(int[] days, int[] costs) {
        int[][] dp = new int[365+30][days.length+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return minCostCalc(days,costs,0,0,dp);
    }
}