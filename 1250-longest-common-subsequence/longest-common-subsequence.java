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
    private int tabulation(String text1,String text2){
        int[] prev = new int[text2.length()+1];
        int[] curr = new int[text2.length()+1];
        for(int i=text1.length()-1;i>=0;i--){
            for(int j=text2.length()-1;j>=0;j--){
               
                if(text1.charAt(i)==text2.charAt(j)){
                    curr[j] = 1 + prev[j+1];
                }else{
                    curr[j] = Math.max(curr[j+1],prev[j]);
                }
                //curr[j] = Math.max(ans,ans1);
            }
            prev = curr;
            if(i>0){
            curr = new int[text2.length()+1];}
        }
        return curr[0];
    }
   
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        //return solve(text1,text2,0,0,dp);
        return tabulation(text1,text2);
    }
}