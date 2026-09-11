class Solution {
    public int totalNumbers(int[] digits) {
        boolean[] used = new boolean[digits.length];
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 0) continue; // first digit cannot be 0

            used[i] = true;

            for (int j = 0; j < digits.length; j++) {
                if (used[j]) continue;

                used[j] = true;

                for (int k = 0; k < digits.length; k++) {
                    if (used[k]) continue;

                    if ((digits[k] & 1) == 0) { // last digit must be even
                        int num = digits[i] * 100
                                + digits[j] * 10
                                + digits[k];

                        set.add(num);
                    }
                }

                used[j] = false;
            }

            used[i] = false;
        }

        return set.size();
    }
}