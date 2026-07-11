class Solution {
    private int solve(String text1,String text2,int i,int j,int[][] dp){
        if(i==text1.length() || j==text2.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans = 0;
        int ans1 = 0;
        int ans2 = 0;
        if(text1.charAt(i)==text2.charAt(j)){
            ans = 1 + solve(text1,text2,i+1,j+1,dp);
        }else{
            ans1 = solve(text1,text2,i+1,j,dp);
            ans2 = solve(text1,text2,i,j+1,dp);
            ans1 = Math.max(ans1,ans2);
        }
        dp[i][j] = Math.max(ans1,ans);
        return  dp[i][j];
    }
   
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(text1,text2,0,0,dp);
    }
}