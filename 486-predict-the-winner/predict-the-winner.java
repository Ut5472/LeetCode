class Solution {
    private int predicter(int[] nums,int i,int j){
        if(i>j){
            return 0;
        }
        int ans = 0;
        //take first
        int first = nums[i] + predicter(nums,i+2,j);
        int first1 = nums[i] + predicter(nums,i+1,j-1);
        int last = nums[j] + predicter(nums,i,j-2);
        int last1 = nums[j] + predicter(nums,i+1,j-1);
        return Math.max(Math.min(first,first1),Math.min(last,last1));

    }
    public boolean predictTheWinner(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        int max = predicter(nums,0,nums.length-1);
        int p2max = sum - max;
        if(max>=p2max){
            return true;
        }
        else{
            return false;
        }
    }
}