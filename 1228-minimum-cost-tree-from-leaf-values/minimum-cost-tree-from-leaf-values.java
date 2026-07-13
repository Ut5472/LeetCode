class Solution {
    private int solver(int[] arr,int[][] matrix,int i,int j,int[][] dp){
        //base case
        if(i>=j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        //recursion
        int min = Integer.MAX_VALUE;
        for(int part=i;part<j;part++){
            int ans =  solver(arr,matrix,i,part,dp);
            int ans2 = solver(arr,matrix,part+1,j,dp);
            int temp = matrix[i][part] * matrix[part+1][j] + ans + ans2;
            min = Math.min(temp,min);      
            System.out.println(temp);
            System.out.println(ans);
            System.out.println(ans2);
            System.out.println("\n");      
        }
        dp[i][j] = min;
        return min;
    }
    private int tabulation(int[] arr,int[][] matrix){
        int n = arr.length;
        int[][] dp = new int[n+1][n+1];
        //int min = Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                int min = Integer.MAX_VALUE;
                for(int part = i;part<j;part++){
                    int ans = dp[i][part];
                    int ans2 = dp[part+1][j];
                    int temp = matrix[i][part]*matrix[part+1][j] + ans + ans2;
                    min = Math.min(temp,min);
                }
                dp[i][j] = min;
            }
        }
        return dp[0][n-1];

    }

    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int[][] matrix = new int[n][n];
        for(int i=0;i<n;i++){
            matrix[i][i] = arr[i];
            for(int j=i+1;j<n;j++){
                matrix[i][j] = Math.max(matrix[i][j-1],arr[j]); 
            }
        }
        return tabulation(arr,matrix);
        //return solver(arr,matrix,0,n-1,dp);
    }
}