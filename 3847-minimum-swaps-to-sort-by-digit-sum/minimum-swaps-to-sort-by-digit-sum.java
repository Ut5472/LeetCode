import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    private int getDigitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;
        
        // Step 1: Create a boxed array to easily sort with a custom comparator
        Integer[] numsBoxed = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsBoxed[i] = nums[i];
        }
        
        // Sort based on digit sum first, then numerical value
        Arrays.sort(numsBoxed, (a, b) -> {
            int sumA = getDigitSum(a);
            int sumB = getDigitSum(b);
            if (sumA != sumB) {
                return Integer.compare(sumA, sumB);
            }
            return Integer.compare(a, b);
        });
        
        // Step 2: Map each sorted value to its target index
        Map<Integer, Integer> targetIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            targetIndex.put(numsBoxed[i], i);
        }
        
        // Step 3: Find permutation cycles to calculate minimum swaps
        boolean[] visited = new boolean[n];
        int cycles = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int j = i;
                while (!visited[j]) {
                    visited[j] = true;
                    // Jump to the index where nums[j] belongs in the sorted array
                    j = targetIndex.get(nums[j]);
                }
                cycles++;
            }
        }
        
        // Minimum swaps = total elements - number of cycles
        return n - cycles;
    }
}