class Solution {
    private String returnSum(String part) {
        int ans = 0;
        for (int i = 0; i < part.length(); i++) {
            ans += (part.charAt(i) - '0');
        }
        return String.valueOf(ans);
    }

    public String digitSum(String s, int k) {
        // Base case: Stop when string length is less than or equal to k
        if (s.length() <= k) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int n = s.length();

        for (int i = 0; i < n; i += k) {
            sb.append(returnSum(s.substring(i, Math.min(i + k, n))));
        }

        return digitSum(sb.toString(), k);
    }
}