class Solution {
    private int distinct(String s,String t,int i,int j,int[][] dp){
        //basecase
        if(i==s.length() && j==t.length()){
            return 1;
        }
        if(i!=s.length() && j==t.length()){
            return 1;
        }
        if(i==s.length() && j!=t.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        //recursion
        int ans = 0;
        if(s.charAt(i)==t.charAt(j)){
            ans += distinct(s,t,i+1,j+1,dp) + distinct(s,t,i+1,j,dp);
            //ans += distinct(s,t,i+1,j);
        }else{
            ans += distinct(s,t,i+1,j,dp);
        }
        return dp[i][j] = ans;
    }
    public int numDistinct(String s, String t) {
        //String build = new String();
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return distinct(s,t,0,0,dp);
    }
}