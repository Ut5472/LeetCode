class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if(n<=2){
            return n;
        }
        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;
        int minIdx = -1;
        int maxIdx = 1;
        for(int i=0;i<n;i++){
            if(nums[i]<minNum){
                minNum = nums[i];
                minIdx = i;
            }
            if(nums[i]>maxNum){
                maxNum = nums[i];
                maxIdx = i;
            }
        }
        int left = minIdx<maxIdx?minIdx:maxIdx;
        int right = maxIdx>minIdx?maxIdx:minIdx;
        int ans1 = left + 1 + (n-right);
        int ans2 = left + 1 + (right-left);
        int ans3 = (n-right) + (right-left);
        return Math.min(ans1,Math.min(ans2,ans3));



    }
}