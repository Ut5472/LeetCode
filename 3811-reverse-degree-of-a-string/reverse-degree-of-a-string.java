class Solution {
    int reversedeg = 0;
    public int reverseDegree(String s) {
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            int lex = (int)(ch - 'a');
            lex++;
            lex = 27 - lex;
            //System.out.println(lex);
            reversedeg += lex * (i+1);
        }
        return reversedeg;
        
    }
}