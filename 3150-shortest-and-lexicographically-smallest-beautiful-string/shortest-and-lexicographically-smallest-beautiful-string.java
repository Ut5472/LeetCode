class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        //sliding window algorithm
        int i=0;
        int j=0;
        int onec = 0;
        List<String> ans = new ArrayList<>();
        while(j<s.length() && i<s.length()){
            if(s.charAt(i)=='1'){
                onec++;
                if(onec==k){
                    while(onec==k){
                        if(s.charAt(j)=='1'){
                            ans.add(s.substring(j,i+1));
                            j++;
                            onec--;
                            break;
                        }else{
                            j++;
                        }
                    }
                }
                i++;
            }else{
                i++;
            }
        }
        if(ans.size()==0){
            return "";
        }
        int smallest=Integer.MAX_VALUE;
        int idx = -1;
        for(int p=0;p<ans.size();p++){
            if(ans.get(p).length() < smallest || (ans.get(p).length() == smallest && ans.get(p).compareTo(ans.get(idx)) < 0)){
                smallest = ans.get(p).length();
                idx = p;
            }
        }
        return ans.get(idx);
    }
}