class Solution {
    private boolean solve(String s,List<String> dict,int i,boolean[] dp,boolean[] vis){
        if(i==s.length()){
            return true;
        }
        if(vis[i]==true){
            return dp[i];
        }
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for(int j=i;j<s.length();j++)
        {
            sb.append(s.charAt(j));
            if(dict.contains(sb.toString())){
                flag = flag || solve(s,dict,j+1,dp,vis);
            }
        }
        vis[i] = true;
        return dp[i] = flag;

    }
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        boolean[] vis = new boolean[s.length()+1];
       // Arrays.fill(dp,-1);
        return solve(s,wordDict,0,dp,vis);
    }
}