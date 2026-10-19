class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length-1;
        int mid = start + (end-start)/2;
        while(start<end){
            if(nums[mid]<target){
                start = mid+1;
            }else if(nums[mid]>target){
                end = mid-1;
            }else{
                break;
            }
            mid = start+(end-start)/2;
        }
        if(mid-1>=0 && nums[mid-1]==nums[mid]){
            while(mid-1 >= 0 && nums[mid-1]==nums[mid]){
                mid--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        if(nums[mid]!=target){
            return ans;
        }
        while(mid<=nums.length-1 && nums[mid]==target ){
            ans.add(mid);
            mid++;
        }
        return ans;
    }
}