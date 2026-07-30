class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Set<Integer> map = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!map.contains(nums[i])){
                map.add(nums[i]);
            }
        }
        int longest = Integer.MIN_VALUE;
        int length = 1;
        for(Integer key: map){
            if(!map.contains(key-1)){
                int temp = key;
                while(map.contains(temp+1)){
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