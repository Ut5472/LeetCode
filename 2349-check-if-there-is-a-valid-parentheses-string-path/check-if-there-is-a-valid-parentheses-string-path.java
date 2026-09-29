class Solution {
    int m, n;
    boolean[][][] visited;

    private boolean solve(char[][] grid, int i, int j, int bal) {
        bal += grid[i][j] == '(' ? 1 : -1;
        if (bal < 0) return false;

        if (i == m - 1 && j == n - 1) return bal == 0;

        int remaining = (m - 1 - i) + (n - 1 - j);
        if (bal > remaining) return false;

        if (visited[i][j][bal]) return false;
        visited[i][j][bal] = true;

        return (i + 1 < m && solve(grid, i + 1, j, bal))
            || (j + 1 < n && solve(grid, i, j + 1, bal));
    }

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        if ((m + n - 1) % 2 == 1) return false;
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') return false;

        visited = new boolean[m][n][(m + n) / 2 + 2];
        return solve(grid, 0, 0, 0);
    }
}