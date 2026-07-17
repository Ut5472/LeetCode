class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length()-1;
        if(i==0){
            return 1;
        }
        while(i>=0){
            if(s.charAt(i)==' '){
                i--;
            }
            else{
                break;
            }
        }
        int firstidx = i;
        while(firstidx>=0){
            if(s.charAt(firstidx)!=' '){
                firstidx--;
            }else{
                break;                
            }
        }
        return i - firstidx;
    }
}