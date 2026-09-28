class Solution {
    public int maxDepth(String s) {
        int parCount = 0;
        int maxPar = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i) == ')'){
                if(s.charAt(i)=='('){
                    parCount++;
                }else{
                    parCount--;
                }
                maxPar = Math.max(maxPar,parCount);
            }
        }
        return maxPar;
    }
}