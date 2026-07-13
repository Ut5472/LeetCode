class Solution {
    private int rec(int s,int e,int[][] dp){
        if(s>=e){
            return 0;
        }
        if(dp[s][e]!=-1){
            return dp[s][e];
        }
        int ans = Integer.MAX_VALUE;
        for(int i=s;i<e;i++){
            ans = Math.min(ans,(i + Math.max(rec(s,i-1,dp),rec(i+1,e,dp))));
        }
        dp[s][e] = ans;
        return ans;
    }
    private int tabulation(int n){
        int[][] dp = new int[n+2][n+2];
        for(int i=n;i>=1;i--){
            
            for(int j=i+1;j<=n;j++){
                int ans = Integer.MAX_VALUE;
                for(int k=i;k<=j;k++){
                    ans = Math.min(ans,(k+Math.max(dp[i][k-1],dp[k+1][j])));
                }
                dp[i][j] = ans;
            }
        }
        return dp[1][n];

    }
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        //return rec(1,n,dp);
        return tabulation(n);
    }
}