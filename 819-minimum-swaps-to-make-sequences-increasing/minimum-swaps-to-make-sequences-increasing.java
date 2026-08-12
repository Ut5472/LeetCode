class Solution {
    private static int solve(int[] nums1,int[] nums2,int i,int swap,int[][] dp){
        //baseCase
        if(i==nums1.length){
            return 0;
        }
        if(dp[i][swap]!=-1){
            return dp[i][swap];
        }
        //recursion
        if(i==0){
            int swaped = 1+solve(nums1,nums2,i+1,1,dp);
            int dontswap = solve(nums1,nums2,i+1,0,dp);
            return dp[i][swap]=Math.min(swaped,dontswap);
        }else{
            int prev1 = swap==0?nums1[i-1]:nums2[i-1];
            int prev2 = swap==0?nums2[i-1]:nums1[i-1];
            //don't swap
            int dontswap = Integer.MAX_VALUE;
            if(nums1[i]>prev1 && nums2[i]>prev2){
                dontswap = solve(nums1,nums2,i+1,0,dp);
            }
            //swap it
            int swaped = Integer.MAX_VALUE;
            if(nums1[i]>prev2 && nums2[i]>prev1){
                swaped = 1+solve(nums1,nums2,i+1,1,dp);
            }
            return dp[i][swap] = Math.min(swaped,dontswap);
        }
        //i don't need to swap
        //check previously swapped or not
    } 
    public int minSwap(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][2];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(nums1,nums2,0,0,dp);
    }
}