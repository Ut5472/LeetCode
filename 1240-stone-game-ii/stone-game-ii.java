class Solution {

    Integer[][][] dp;

    private int stoner(int[] piles, int start, int M, boolean aliceTurn) {

        // Base case
        if (start >= piles.length) {
            return 0;
        }

        int turn = aliceTurn ? 1 : 0;

        if (dp[start][M][turn] != null) {
            return dp[start][M][turn];
        }

        if (aliceTurn) {

            int ans = Integer.MIN_VALUE;
            int sum = 0;

            for (int i = start; i < start + 2 * M && i < piles.length; i++) {

                sum += piles[i];

                ans = Math.max(
                        ans,
                        sum + stoner(piles, i + 1,
                                Math.max(M, i - start + 1), false));
            }

            return dp[start][M][turn] = ans;

        } else {

            int ans = Integer.MAX_VALUE;

            for (int i = start; i < start + 2 * M && i < piles.length; i++) {

                ans = Math.min(
                        ans,
                        stoner(piles, i + 1,
                                Math.max(M, i - start + 1), true));
            }

            return dp[start][M][turn] = ans;
        }
    }

    public int stoneGameII(int[] piles) {

        int n = piles.length;
        dp = new Integer[n][n + 1][2];

        return stoner(piles, 0, 1, true);
    }
}