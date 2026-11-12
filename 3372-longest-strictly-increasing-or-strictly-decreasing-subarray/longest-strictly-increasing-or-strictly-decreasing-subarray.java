class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int curr_length = 0;
        int max_length = Integer.MIN_VALUE;
        int prev = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=prev){
                curr_length=1;
            }else{
                curr_length++;
            }
            prev = nums[i];
            max_length = Math.max(curr_length,max_length);
        }
        curr_length = 0;
        prev = -1;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]<=prev){
                curr_length=1;
            }else{
                curr_length++;
            }
            prev = nums[i];
            max_length = Math.max(curr_length,max_length);
        }
        return max_length;
    }
}