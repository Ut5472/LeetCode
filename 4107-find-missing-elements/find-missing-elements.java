class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Set<Integer> store = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            store.add(nums[i]);
            smallest = Math.min(smallest,nums[i]);
            largest = Math.max(largest,nums[i]);
        }
        for(int i=smallest;i<=largest;i++){
            if(!store.contains(i)){
                ans.add(i);
            }
        }
        return ans;
    }
}