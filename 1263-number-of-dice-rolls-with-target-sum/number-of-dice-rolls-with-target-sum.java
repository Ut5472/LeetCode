class Solution {
    private int diceRoller(int n,int k,int target,int[][] dp){
        int MOD = 1000000007;
        if(target<0 ){
            return 0;
        }
        if(n==0 && target==0){
            return 1;
        }
        if(n==0 && target!=0){
            return 0;
        }
        if(target==0 && n!=0){
            return 0;
        }
        if(dp[n][target]!=-1){
            return dp[n][target];
        }
        long ans = 0;
        for(int i=1;i<=k;i++){
            ans =(ans + diceRoller(n-1,k,target-i,dp))%MOD;
        }
        dp[n][target] = (int)ans;
        return (int)ans;
    }
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n+1][target+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return diceRoller(n,k,target,dp);
    }
}