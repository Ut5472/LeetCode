class Solution {
    private boolean matcher(String s,String p,int i,int j,boolean[][] dp,boolean[][] vis){
        //base case 
        if(i==s.length() && j==p.length()){
            return true;
        }
        if(vis[i][j]){
            return dp[i][j];
        }
        if((i==s.length() && j<p.length()) || (i<s.length() && j==p.length())){
            if(j<p.length()){
                while(j!=p.length()){
                    if(p.charAt(j)=='*'){
                        j++;
                    }else{
                        vis[i][j] = true;
                        return false;
                    }
                }
                dp[i][j] = true;
                vis[i][j] = true;
                return true;
            }else{
                while(i!=s.length()){
                    if(s.charAt(i)=='*'){
                        i++;
                    }else{
                        vis[i][j] = true;
                        return false;
                    }
                }
                vis[i][j] = true;
                dp[i][j] = true;
                return true;
            }
        }
        //recursion
        vis[i][j] = true;
        if(s.charAt(i)==p.charAt(j)){
            dp[i][j] = matcher(s,p,i+1,j+1,dp,vis);
            return dp[i][j];//matcher(s,p,i+1,j+1);
        }
        else if(p.charAt(j) == '?'){
            dp[i][j] = matcher(s,p,i+1,j+1,dp,vis);
            return dp[i][j];//matcher(s,p,i+1,j+1);
        }else if(p.charAt(j) == '*'){
            dp[i][j] = matcher(s,p,i+1,j,dp,vis) || matcher(s,p,i,j+1,dp,vis) || matcher(s,p,i+1,j+1,dp,vis);
            return dp[i][j]; //matcher(s,p,i+1,j) || matcher(s,p,i,j+1) || matcher(s,p,i+1,j+1);
        }else{
            return false;
        }
    }
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        boolean[][] vis = new boolean[s.length()+1][p.length()+1];
        return matcher(s,p,0,0,dp,vis);
    }
}