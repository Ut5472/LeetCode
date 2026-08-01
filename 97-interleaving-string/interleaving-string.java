class Solution {
    private boolean ils(String s1, String s2, String s3, int i, int j,boolean[][] dp, boolean[][] vis) {
        // Base case
        if(i == s1.length() && j == s2.length()){
            return true;
        }
        if(i == s1.length() && j != s2.length()){
            while (j != s2.length()) {
                if (s2.charAt(j) != s3.charAt(i+j)){
                    return false;
                }
                j++;
            }
            return true;
        }
        if(i != s1.length() && j == s2.length()){
            while (i != s1.length()){
                if(s1.charAt(i) != s3.charAt(i+j)){
                    return false;
                }
                i++;
            }
            return true;
        }
        if(vis[i][j]){
            return dp[i][j];
        }
        //recursion
        vis[i][j] = true;
        if(s1.charAt(i) != s3.charAt(i + j) && s2.charAt(j) != s3.charAt(i+j)){
            dp[i][j] = false;
        }else if(s1.charAt(i) == s3.charAt(i+j) && s2.charAt(j) != s3.charAt(i+j)){
            dp[i][j] = ils(s1,s2,s3,i+1,j,dp,vis);
        }else if(s1.charAt(i) != s3.charAt(i+j) && s2.charAt(j) == s3.charAt(i+j)){
            dp[i][j] = ils(s1, s2, s3, i, j + 1, dp, vis);
        }else{
            dp[i][j] = ils(s1,s2, s3,i+1,j,dp,vis)|| ils(s1,s2,s3,i,j+1,dp,vis);
        }
        return dp[i][j];
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int s1l = s1.length();
        int s2l = s2.length();
        int s3l = s3.length();
        if(s1l+s2l != s3l){
            return false;
        }
        boolean[][] dp = new boolean[s1l+1][s2l+1];
        boolean[][] vis = new boolean[s1l+1][s2l+1];
        return ils(s1,s2,s3,0,0,dp,vis);
    }
}