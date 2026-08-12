class Solution {
    private int solve(int[] nums,int target,int i,int sum){
        //base case
        if(i==nums.length){
            if(sum==target){
                return 1;
            }else{
                return 0;
            }
        }
        //recursion
        //+sign
        int pos = solve(nums,target,i+1,sum+nums[i]);
        //-sign
        int neg = solve(nums,target,i+1,sum-nums[i]);
        return pos+neg;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return solve(nums,target,0,0);
    }
}