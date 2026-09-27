class Solution {
    public String reverseParentheses(String s) {
        //StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int j=0;j<s.length();j++){
            if(s.charAt(j)==')'){
                //fuck9ng reverse it
                StringBuilder sb = new StringBuilder();
                while(stack.peek()!='('){
                    sb.append(stack.pop());
                }
                stack.pop();
                for(int i=0;i<sb.length();i++){
                    stack.push(sb.charAt(i));
                }
            }else{
                stack.push(s.charAt(j));
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
        return ans.reverse().toString();

    }
}