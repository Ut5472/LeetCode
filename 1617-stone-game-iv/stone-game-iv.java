class Solution{
    boolean canWin(int n,int[] squares,int[] dp){
        if(n==0){
            return false;
        }
        if(dp[n]!=-1){
            return dp[n]==1?true:false;
        }
        for(int square : squares){
            if(square > n){
                break;
            }
            if(!canWin(n - square,squares,dp)){
                dp[n] = 1;
                return true;
            }
        }
        dp[n] = 0;
        return false;
    }
    public boolean winnerSquareGame(int n){
        int[] sqrs = new int[318];
        int[] dp = new int[n+1];
        for(int i=0;i<dp.length;i++){
            dp[i] = -1;
        }
        for(int i=0;i<sqrs.length;i++){
            sqrs[i] = (i+1)*(i+1);
        }
        return canWin(n,sqrs,dp);
    }
}