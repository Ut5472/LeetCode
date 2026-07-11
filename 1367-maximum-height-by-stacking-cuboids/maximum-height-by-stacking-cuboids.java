class Solution {
    private int maxHeight(int[][]cuboids,int i,int j,int[][] dp){
        if(i==cuboids.length){
            return 0;
        }
        if(j!=-1){
        if(dp[i][j]!=-1){
            return dp[i][j];
        }}
        int exc = maxHeight(cuboids,i+1,j,dp);
        int widthcurr = cuboids[i][0];
        int lengthcurr = cuboids[i][1];
        int heightcurr = cuboids[i][2];
        int inc = 0;
        if(j==-1){
            inc = heightcurr + maxHeight(cuboids,i+1,i,dp);
            return Math.max(exc,inc);
        }
        int widthprev = cuboids[j][0];
        int lengthprev = cuboids[j][1];
        int heightprev = cuboids[j][2];
       
        if(widthcurr<=widthprev && lengthcurr<=lengthprev && heightcurr<=heightprev){
            inc = heightcurr + maxHeight(cuboids,i+1,i,dp);
        }
        dp[i][j] = Math.max(exc,inc);
        return dp[i][j];
    }
    public int maxHeight(int[][] cuboids){
        int[][] dp = new int[cuboids.length+1][cuboids.length+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        for(int[] cuboid:cuboids){
            Arrays.sort(cuboid);
        }
        Arrays.sort(cuboids,(a,b)->{
           if(a[0]!=b[0]){
            return b[0]-a[0];
           }
           if(a[1]!=b[1]){
            return b[1]-a[1];
           }
            return b[2]-a[2];
        });
        int n = cuboids.length;
        return maxHeight(cuboids,0,-1,dp);
        

    }
}