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
    private int tabulation(int[][] cuboids){
        // Sort dimensions of each cuboid
        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }

        // Sort cuboids lexicographically
        Arrays.sort(cuboids, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[2], b[2]);
        });

        int n = cuboids.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int prev = i - 1; prev >= -1; prev--) {

                int exclude = dp[i + 1][prev + 1];

                int include = 0;

                if (prev == -1 ||
                    (cuboids[i][0] >= cuboids[prev][0] &&
                     cuboids[i][1] >= cuboids[prev][1] &&
                     cuboids[i][2] >= cuboids[prev][2])) {

                    include = cuboids[i][2] + dp[i + 1][i + 1];
                }

                dp[i][prev + 1] = Math.max(include, exclude);
            }
        }

        return dp[0][0];
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
        //return maxHeight(cuboids,0,-1,dp);
        return tabulation(cuboids);
        

    }
}