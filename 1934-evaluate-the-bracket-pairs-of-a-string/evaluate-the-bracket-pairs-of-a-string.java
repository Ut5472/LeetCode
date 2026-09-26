class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> map = new HashMap<>();
        for(int i=0;i<knowledge.size();i++){
            map.put(knowledge.get(i).get(0),knowledge.get(i).get(1));
        }
        //System.out.println(map);
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)=='('){
                StringBuilder key = new StringBuilder();
                i++;
                while(s.charAt(i)!=')'){
                    key.append(s.charAt(i));
                    i++;
                }
               // System.out.println(key.toString());
                if(map.containsKey(key.toString())){
                    sb.append(map.get(key.toString()));
                    i++;
                }else{
                    sb.append('?');
                    i++;
                }
            }else{
                sb.append(s.charAt(i));
                i++;
                
            }
        }
        return sb.toString();
    }
}