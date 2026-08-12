class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int maxSize = 0;
        int currSize = 0;
        int i = 0;
        int j = 0;
        Map<Integer,Integer> map = new HashMap<>();
        while(j<nums.length){
            if(map.containsKey(nums[j])){
                //already at max limit
                if(map.get(nums[j])==k){
                    while(i<j){
                        map.put(nums[i],map.get(nums[i])-1);
                        currSize--;
                        if(nums[i]==nums[j]){
                            i++;
                            break;
                        }
                        i++;
                    }
                }else{
                    map.put(nums[j],map.get(nums[j])+1);
                    j++;
                    currSize++;

                }
            }else{
                map.put(nums[j],1);
                j++;
                currSize++;
            }
            maxSize = Math.max(maxSize,currSize);
        }
        return maxSize;
    }
}