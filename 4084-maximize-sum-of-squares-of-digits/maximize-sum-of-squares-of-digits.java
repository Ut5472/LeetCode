class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(num*9<sum){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<num;i++){
            if(sum>=9){
                sb.append("9");
                sum -= 9;
            }else{
                sb.append((char)(sum + '0'));
                sum = 0;
            }
        }
        return sb.toString();

    }
}