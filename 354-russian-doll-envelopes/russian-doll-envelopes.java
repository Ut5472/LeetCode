class Solution {
    private int envelopesEnclosure(int[][] envelopes,int i,int j,int[][] dp){
       if(i==envelopes.length){
        return 0;
       }
       int exc = 0;
       int inc = 0;
       if(j!=-1){
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
       }
       exc = envelopesEnclosure(envelopes,i+1,j,dp);
       if(j==-1){
        inc = 1 + envelopesEnclosure(envelopes,i+1,i,dp);
        return Math.max(exc,inc);
       }
       if(envelopes[i][0]<envelopes[j][0] && envelopes[i][1]<envelopes[j][1]){
        inc = 1 + envelopesEnclosure(envelopes,i+1,i,dp);         
       }
       dp[i][j] = Math.max(inc,exc);
       return dp[i][j];
    }
    private int lis(int[] nums) {
    int[] tail = new int[nums.length];
    int size = 0;

    for (int num : nums) {
        int left = 0;
        int right = size;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (tail[mid] < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        tail[left] = num;

        if (left == size) {
            size++;
        }
    }

    return size;
}
    private int tabulation(int[][] envelopes){
        int n = envelopes.length;
        int[] curr = new int[n+2];
        int[] prev = new int[n+2];
        //Arrays.fill(curr,0);
        //Arrays.fill(prev,0);
        for(int i=n-1;i>=0;i--){
            for(int j=i-1;j>=-1;j--){
                int exc = prev[j+1];
                int inc = 0;
                if(j==-1 || envelopes[i][0]<envelopes[j][0] && envelopes[i][1]<envelopes[j][1]){
                    inc = 1 + prev[i+1];
                }
                //inc = 1 + prev[i+1];
                curr[j+1] = Math.max(exc,inc);
            }
            prev = curr;
            curr = new int[n+1];
        }
        return prev[0];
    }
    public int maxEnvelopes(int[][] envelopes) {
       // int[][] dp = new int[envelopes.length+1][envelopes.length+1];
        //for(int[] row:dp){
        //    Arrays.fill(row,-1);
       // }
        Arrays.sort(envelopes,(a,b)->{
            if(a[0]!=b[0]){
                return a[0]-b[0];
            }
            return b[1] - a[1];
        });
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            heights[i] = envelopes[i][1];
        }
        return lis(heights);
        //return envelopesEnclosure(envelopes,0,-1,dp);
        //return tabulation(envelopes);   
    }
}