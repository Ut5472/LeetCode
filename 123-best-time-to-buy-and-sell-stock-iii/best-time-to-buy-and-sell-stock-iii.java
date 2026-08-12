class Solution {
    private int solve(int[] prices,int pos,int ledger,int[][][] dp,int ctr){
        //base case
        if(ctr==2){
            return 0;
        }
        if(pos==prices.length){ return 0;}
        //dp
        if(dp[pos][ledger][ctr]!=-1){
            return dp[pos][ledger][ctr];
        }
        //recursion
        //if ledger == 0 or we don't hold any stock
        if(ledger==0){
            //buy
            int buy = -prices[pos] + solve(prices,pos+1,1,dp,ctr);
            //dont buy
            int dbuy = solve(prices,pos+1,0,dp,ctr);
            return dp[pos][ledger][ctr] = Math.max(buy,dbuy);
        }else{
            //we have a stock in hold
            //dont sell
            int dontsell = solve(prices,pos+1,1,dp,ctr);
            //sell
            int sell = prices[pos] + solve(prices,pos+1,0,dp,ctr+1);
            return dp[pos][ledger][ctr] = Math.max(sell,dontsell);
        }
    }
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length+1][2][2];
        for(int[][] row:dp){
            for(int[] deep:row){
                Arrays.fill(deep,-1);
            }
        }
        return solve(prices,0,0,dp,0);

    }
}