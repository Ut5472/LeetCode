class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];
        int maxSoFar = 0;
        for (int i = 0; i < n; i++) {
            maxSoFar = Math.max(maxSoFar, nums[i]);
            prefixGcd[i] = gcd(nums[i], maxSoFar);
        }
        Arrays.sort(prefixGcd);
        long ans = 0;
        int i = 0, j = n - 1;
        while (i < j) {
            ans += gcd(prefixGcd[i], prefixGcd[j]);
            i++;
            j--;
        }
        return ans;
    }
    private int gcd(int a,int b){
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}