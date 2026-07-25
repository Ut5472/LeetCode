class Solution {
    public int maxProduct(int n) {
       String str = String.valueOf(n);
        int max = -1;
        int second_max = -1;
        for(int i=0;i<str.length();i++){
            int d = (str.charAt(i))-'0';
            if(d>max){
                second_max = max;
                max = d;
            }else if(d<=max && d>=second_max){
                second_max = d;
            }
        }
        return max*second_max;
        
    }
}