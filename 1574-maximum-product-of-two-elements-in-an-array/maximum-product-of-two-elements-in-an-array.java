class Solution {
    public int maxProduct(int[] nums) {
        int max = -1;
        int second_max = -1;
        for(int i=0;i<nums.length;i++){
            int d = nums[i];
            if(d>max){
                second_max = max;
                max = d;
            }else if(d<=max && d>=second_max){
                second_max = d;
            }
        }
        return (max-1)*(second_max-1);
    }
}