class Solution {
    private int minsumDel(String s1,String s2,int i,int j,int[][] dp){
        //basecase
        if(i==s1.length() && j==s2.length()){
            return 0;
        }
        else if(i==s1.length() && j!=s2.length()){
            int sum = 0;
            while(j!=s2.length()){
                sum += s2.charAt(j);
                j++;
            }
            return sum;
        }else if(i!=s1.length() && j==s2.length()){
            int sum=0;
            while(i!=s1.length()){
                sum += s1.charAt(i);
                i++;
            }
            return sum;
        }
        //dp
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        //recursion
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j] = minsumDel(s1,s2,i+1,j+1,dp);            
        }else{
            return dp[i][j] = Math.min((int)s1.charAt(i) + minsumDel(s1,s2,i+1,j,dp),(int)s2.charAt(j) + minsumDel(s1,s2,i,j+1,dp));
        }
    }
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return minsumDel(s1,s2,0,0,dp);
    }
}