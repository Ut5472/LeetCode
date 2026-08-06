class Solution {
    public int smallestNumber(int n, int t) {
        for(int i=n;i<=n+10;i++){
            int num = 1;
            int div = i;
            while(div>0){
                num = num * (div%10);
                div=div/10;
            }
            System.out.println("The Number is : " + num);
            if(num%t==0){
                return i;
            }
        }
        return -1;
    }
}