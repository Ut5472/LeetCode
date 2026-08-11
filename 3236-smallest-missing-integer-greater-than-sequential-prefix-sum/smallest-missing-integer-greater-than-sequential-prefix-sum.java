class Solution {
    public int missingInteger(int[] nums) {
        Set<Integer> store = new HashSet<>();
        int n = nums.length;
        //storing nums
        for(int i=0;i<n;i++){
            store.add(nums[i]);
        }
        //starting sequence
        int currSum = nums[0];
        for(int j=1;j<n;j++)
        {
            if(nums[j] == nums[j-1] + 1){
                currSum += nums[j];
            }else{
                break;
            }
        }
        while(store.contains(currSum)){
            currSum++;
        }
        return currSum;

    }
}