class Solution {
    public int maxProduct(int n) {
        String str = String.valueOf(n);
        int a = (str.charAt(0))-'0';
        int b = (str.charAt(1))-'0';
        if(str.length()==2){
            return a * b;
        }
        int max = a>b?a:b;
        int second_max = a<b?a:b;
        for(int i=2;i<str.length();i++){
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