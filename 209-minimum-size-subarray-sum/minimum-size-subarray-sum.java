class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minDiff = Integer.MAX_VALUE;
        int i=0;
        int j=0;
        int swsum = 0;
        while(j<=nums.length){
            if(swsum<target && i<nums.length){
                swsum += nums[i];
                i++;
            }
            else if(swsum>target && j<nums.length){
                swsum -= nums[j];
                j++;
            }
            if(swsum>=target){
                while(swsum>=target){
                minDiff=Math.min(minDiff,(i-j));
                //System.out.println()
                //if(i!=nums.length){
                    //swsum += nums[i];
                    //i++;
                //}
                //else
                {
                    swsum -= nums[j];
                    j++;
                }}
            }
            if(swsum<target && i==nums.length){
                break;
            }
        }
        if(minDiff==Integer.MAX_VALUE){
            return 0;
        }
        return minDiff;
        
    }
}