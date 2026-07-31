class Solution {
    private int solve(int[] nums, int start,int end,int[][] dp){
        if(start>end){
            return 0;
        }
        if(dp[start][end]!=-1){
            return dp[start][end];
        }
        int coins = 0;
        int maxc = Integer.MIN_VALUE;
        for(int i=start;i<=end;i++){
            coins = nums[start-1] * 
            nums[i] * nums[end+1]
             + solve(nums,start,i-1,dp) + solve(nums,i+1,end,dp);
            maxc = Math.max(coins,maxc);
        }
        return dp[start][end] = maxc;
    }
    public int maxCoins(int[] nums){
        int[] arr = new int[nums.length+2];
        arr[0] = 1;
        arr[arr.length-1] = 1;
        for(int i=0;i<nums.length;i++){
            arr[i+1] = nums[i];
        }
        int start = 1;
        int end = arr.length-2;
        int[][] dp = new int[arr.length+1][arr.length+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(arr,start,end,dp);
        
    }
}