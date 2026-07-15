class Solution {
    public int gcdOfOddEvenSums(int N) {
        if(N==1){
            return 1;
        }
        double n = (double)(N);
        double sumOdd = n/2*(2+(n-1)*2);
        double sumEven = n/2*(4+(n-1)*2);
        double min = Math.min(sumEven,sumOdd);
        int ans = 0;
        for(int i=2;i<=min;i++){
            if(sumOdd%i == 0 && sumEven%i==0){
                ans = i;
            }
        }if(ans==0){
         ans = (int)sumOdd*(int)sumEven;}
        return ans;
    }
}