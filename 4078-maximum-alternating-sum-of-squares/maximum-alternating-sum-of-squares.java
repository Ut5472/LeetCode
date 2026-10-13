class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i] = nums[i]*nums[i];
        }
        Arrays.sort(nums);
       // Arrays.reverse(nums);
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<nums.length;i++){
            dq.offerFirst(nums[i]);
        }
        long ans  = 0;
        while(!dq.isEmpty()){
            ans += dq.pollFirst();
            if(!dq.isEmpty()){
                ans -= dq.pollLast();
            }
        }
        return ans;

    }
}