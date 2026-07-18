class Solution {
    private int Squares(int n,int[] dp){
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int ans = Integer.MAX_VALUE;
        int i = 1;
        int end = (int)Math.sqrt(n);
        while(i<=end){
            int sq = i*i;
            int reans = 1 + Squares(n-sq,dp);
            i++;
            if(reans<ans){
                ans = reans;
            }
        }
        return dp[n] = ans;
    }
    private int tabulation(int n){
        int[] dp = new int[n+1];
        dp[n] = 0;
        for(int k=1;k<=n;k++){
            int ans = Integer.MAX_VALUE;
            int i = 1;
            int end = (int)Math.sqrt(k);
            while(i<=end){
                int sq = i*i;
                int reans = 1 + dp[k-sq];
                i++;
                if(reans<ans){
                    ans = reans;
                }
            }
            dp[k] = ans;
        }
        return dp[n];
        
    }
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        //return Squares(n,dp);
        return tabulation(n);
    }
}