class Solution {
    public int[] decompressRLElist(int[] nums) {
        int length = 0;
        for(int i=0;i<nums.length;i=i+2){
            length += nums[i];
        }
        int[] ans = new int[length];
        int ptr = 0;
        for(int i=0;i<nums.length;i=i+2){
            for(int j=0;j<nums[i];j++){
                ans[ptr] = nums[i+1];
                ptr++;
            }
        }
        return ans;
    }
}