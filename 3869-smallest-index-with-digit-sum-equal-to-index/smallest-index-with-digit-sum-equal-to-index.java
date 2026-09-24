class Solution {
    private int digitSum(int num){
        int sum = 0;
        while(num>0){
            sum += num%10;
            num = num/10;
        }
        return sum;
    }
    public int smallestIndex(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            int sum = digitSum(nums[i]);
            if(sum==i){
                return i;
            }
        }
        return -1;
    }
}