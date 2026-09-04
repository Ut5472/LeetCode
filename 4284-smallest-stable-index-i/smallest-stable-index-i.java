class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] preMax = new int[n];
        int[] postMin = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(max<nums[i]){
                max = nums[i];               
            }
            preMax[i] = max;
        }
        for(int i=n-1;i>=0;i--){
            if(nums[i]<min){
                min = nums[i];
            }
            postMin[i] = min;
        }
        int stable = Integer.MAX_VALUE;
        int idx = -1;
        for(int i=0;i<n;i++){
            if(preMax[i]-postMin[i]<=k){
                stable = preMax[i]-postMin[i];
                idx = i;
                break;
            }
        }
        return idx;
    }
}