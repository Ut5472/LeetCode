class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }
        }
        int longest = Integer.MIN_VALUE;
        int length = 1;
        for(Integer key:map.keySet()){
            if(!map.containsKey(key-1)){
                int temp = key;
                while(map.containsKey(temp+1)){
                    length++;
                    temp++;
                }
                longest = Math.max(length,longest);
                length = 1;
            }
        }
        return longest;
        
    }
}