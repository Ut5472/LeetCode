class Solution {
    private int solve(int[] prices,int pos,int ledger,int[][][] dp,int ctr,int k){
        //base case
        if(ctr==k){
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
            int buy = -prices[pos] + solve(prices,pos+1,1,dp,ctr,k);
            //dont buy
            int dbuy = solve(prices,pos+1,0,dp,ctr,k);
            return dp[pos][ledger][ctr] = Math.max(buy,dbuy);
        }else{
            //we have a stock in hold
            //dont sell
            int dontsell = solve(prices,pos+1,1,dp,ctr,k);
            //sell
            int sell = prices[pos] + solve(prices,pos+1,0,dp,ctr+1,k);
            return dp[pos][ledger][ctr] = Math.max(sell,dontsell);
        }
    }
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length+1][2][k+1];
        for(int[][] row:dp){
            for(int[] deep:row){
                Arrays.fill(deep,-1);
            }
        }
        return solve(prices,0,0,dp,0,k);
        
    }
}