class Solution {
    public int maximumLengthSubstring(String s) {
        int i=0;
        int j=0;
        int currSize = 0;
        int maxSize = 0;
        Map<Character,Integer> map = new HashMap<>();
        while(i<s.length()){
            Character c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,1);
                i++;
                currSize++;
            }else{
                if(map.get(c)==2){
                    while(j<i){
                        map.put(s.charAt(j),map.get(s.charAt(j))-1);
                        currSize--;
                        j++;
                        if(s.charAt(j-1)==c){
                            break;
                        }                        
                    }
                }else{
                    map.put(c,map.get(c)+1);
                    currSize++;
                    i++;
                }
            }
            maxSize = Math.max(currSize,maxSize);
        }
        return maxSize;
    }
}