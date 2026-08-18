class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(freq.containsKey(nums[i])){
                freq.put(nums[i],freq.get(nums[i])+1);
            }else{
                freq.put(nums[i],1);
            }
            max = Math.max(max,nums[i]);
        }
        if(k==nums.length){
            return max;
        }
        else if(k==1 && nums.length!=2){
            max=-1;
            for(int key:freq.keySet()){
                if(freq.get(key)==1){
                    max = Math.max(max,key);
                }
            }
            return max;
        }else{
            int first = nums[0];
            int last = nums[nums.length-1];
            if(freq.get(first)==1 && freq.get(last)==1){
                return Math.max(first,last);
            }else if(freq.get(first)>1 && freq.get(last)==1){
                return last;
            }else if(freq.get(first)==1 && freq.get(last)>1){
                return first;
            }else{
                return -1;
            }
        }
    }
}