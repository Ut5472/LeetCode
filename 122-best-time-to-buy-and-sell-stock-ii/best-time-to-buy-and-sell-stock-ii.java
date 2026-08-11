class Solution {
    private int solve(int[] prices,int pos,int ledger,int[][] dp){
        //base case
        if(pos==prices.length){ return 0;}
        //dp
        if(dp[pos][ledger]!=-1){
            return dp[pos][ledger];
        }
        //recursion
        //if ledger == 0 or we don't hold any stock
        if(ledger==0){
            //buy
            int buy = -prices[pos] + solve(prices,pos+1,1,dp);
            //dont buy
            int dbuy = solve(prices,pos+1,0,dp);
            return dp[pos][ledger] = Math.max(buy,dbuy);
        }else{
            //we have a stock in hold
            //dont sell
            int dontsell = solve(prices,pos+1,1,dp);
            //sell
            int sell = prices[pos] + solve(prices,pos+1,0,dp);
            return dp[pos][ledger] = Math.max(sell,dontsell);
        }
    }
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length+1][2];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(prices,0,0,dp);
    }
}