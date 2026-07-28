class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        if(n<4){
            return s; 
        }
        String firsthalf = "";
        if(n%2==0){
            char[] chararray = s.substring(0,n/2).toCharArray();
            Arrays.sort(chararray);
            firsthalf = new String(chararray);
            return firsthalf + new StringBuilder(firsthalf).reverse().toString();
        }else{
            int mid = n/2;
            char[] chararray = s.substring(0,mid).toCharArray();
            Arrays.sort(chararray);
            firsthalf = new String(chararray);
            return firsthalf +s.charAt(mid)+ new StringBuilder(firsthalf).reverse().toString();
        }
    }
}