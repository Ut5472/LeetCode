class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length<=1){
            return 0;
        }
        Arrays.sort(nums);
        int max_diff = Integer.MIN_VALUE;
        for(int i=0;i<nums.length-1;i++){
            max_diff = Math.max(max_diff,Math.abs(nums[i]-nums[i+1]));
        }
        return max_diff;
    }
}