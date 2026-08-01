class Solution {
    private int predicter(int[] nums,int i,int j,int[][] dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans = 0;
        //take first
        int first = nums[i] + predicter(nums,i+2,j,dp);
        int first1 = nums[i] + predicter(nums,i+1,j-1,dp);
        int last = nums[j] + predicter(nums,i,j-2,dp);
        int last1 = nums[j] + predicter(nums,i+1,j-1,dp);
        return dp[i][j] = Math.max(Math.min(first,first1),Math.min(last,last1));

    }
    public boolean predictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        int max = predicter(nums,0,nums.length-1,dp);
        int p2max = sum - max;
        if(max>=p2max){
            return true;
        }
        else{
            return false;
        }
    }
}