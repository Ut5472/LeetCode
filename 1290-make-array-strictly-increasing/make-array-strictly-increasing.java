class Solution {
    private int solve(int[] arr1, int[] arr2, int i, int prev, Map<String, Integer> map) {
        if(i == arr1.length){
            return 0;
        }
        String key = i + "," + prev;
        if(map.containsKey(key)){
            return map.get(key);
        }
        if(arr1[i] > prev){
            int start = 0;
            int end = arr2.length - 1;
            int idx = arr2.length;
            while(start<=end){
                int mid = start + (end - start) / 2;
                if(arr2[mid]>prev){
                    idx = mid;
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
            int min = Integer.MAX_VALUE / 2;
            min = Math.min(min, solve(arr1, arr2, i + 1, arr1[i], map));
            if(idx < arr2.length){
                min = Math.min(min,1 + solve(arr1, arr2, i + 1, arr2[idx], map));
            }
            map.put(key,min);
            return min;
        } else {
            int start = 0;
            int end = arr2.length - 1;
            int idx = arr2.length;
            while(start <= end){
                int mid = start + (end - start) / 2;
                if (arr2[mid] > prev) {
                    idx = mid;
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            int min = Integer.MAX_VALUE / 2;
            if(idx < arr2.length){
                min = Math.min(min,1 + solve(arr1, arr2, i + 1, arr2[idx], map));
            }
            map.put(key, min);
            return min;
        }
    }

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        Map<String, Integer> map = new HashMap<>();
        int ans = solve(arr1, arr2, 0, Integer.MIN_VALUE, map);
        return ans >= Integer.MAX_VALUE / 2 ? -1 : ans;
    }
}