class Solution {
    public int totalMoney(int n) {
        int count = 1;
        int sum = 0;
        int updater = 0;
        int lc = 0;
        while(n!=0){
            sum += count + updater;
            updater++;
            n--;
            if(updater == 7){
                updater = 0;
                count++;
            }
        }
        return sum;
    }
}