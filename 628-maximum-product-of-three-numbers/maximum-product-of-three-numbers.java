class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int ans = 1;
        int li = nums.length-1;
        ans = ans*nums[li];
        ans = ans*nums[li-1];
        ans = ans*nums[li-2];
        int ans2 = 1;
        ans2 = nums[0]*nums[1]*nums[li];
        return Math.max(ans,ans2);
    }
}