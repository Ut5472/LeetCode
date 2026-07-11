class Solution {
    private boolean isVowel(String word){
        char first = word.charAt(0);
        char last = word.charAt(word.length()-1);
        if(first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u'){
            if(last == 'a' || last == 'e' || last == 'i' || last == 'o' || last == 'u'){
                return true;
            }
        }
        return false;
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] vowel = new int[words.length];
        for(int i=0;i<words.length;i++){
            boolean tf = isVowel(words[i]);
                if(i==0){
                    if(tf==true){
                    vowel[i] =  1;
                }else{
                    vowel[i] =  0;
                }
                continue;
            }
            if(tf==true){
                vowel[i] = vowel[i-1] + 1;
            }else{
                vowel[i] = vowel[i-1] + 0;
            }
        }
        int[] ans = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int startidx = queries[i][0];
            int endidx = queries[i][1];
            if(startidx==endidx && endidx!=0){
                ans[i] = vowel[endidx] - vowel[endidx-1];
                continue;
            }
            if(startidx==0){
                ans[i] = vowel[endidx];
            }else{
                ans[i] = (vowel[endidx]-vowel[startidx-1]) ;
            }
        }
        return ans;
    }
}