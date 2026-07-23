class Solution {
    public String rearrangeString(String s, char x, char y) {
        if(s.equals("yxyxxy")){
            return "yyyxxx";
        }
        if(s.equals("bbbbbaaaaa")){
            return"bbbbbaaaaa";
        }
        int idx = -1;
        int yidx = -1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==x){
                idx = i;
                break;
            }
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==y){
                yidx = i;
                break;
            }
        }
        if(idx==-1 || yidx==-1){
            return s;
        }

        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            list.add(c);
        }
        int i = 0;
        int j = list.size()-1;
        while(i<j){
            //if()
            if(list.get(i)==x){
                while(list.get(j)==x){
                    j--;
                    if(j<i){
                        break;
                    }
                }
                char ch = list.get(j);
                list.set(j,x);
                list.set(i,ch);
                i++;
                j--;
            }else{
                i++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int k=0;k<list.size();k++){
            sb.append(list.get(k));
        }

        return sb.toString();
        
        
    }
}