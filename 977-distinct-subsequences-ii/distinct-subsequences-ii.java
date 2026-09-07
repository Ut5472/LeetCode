class Solution {
    static final int MOD = 1000000007;
    private int solve(String s, int i, int[] dp, int[] prev) {
        if (i < 0) {
            return 1;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        long ans = 2L * solve(s, i - 1, dp, prev)%MOD;
        if (prev[i] != -1) {
            ans = (ans - solve(s, prev[i] - 1, dp, prev)+MOD)%MOD;
        }
        return dp[i] = (int)ans;
    }

    public int distinctSubseqII(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int[] prev = new int[n];
        Arrays.fill(prev, -1);
        int[] last = new int[26];
        Arrays.fill(last, -1);
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            prev[i] = last[c];
            last[c] = i;
        }
        return (solve(s, n - 1, dp, prev) - 1 + MOD) % MOD;
    }
}