class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber!=0){
            columnNumber--;
            int remain = columnNumber%26;
            columnNumber = columnNumber/26;
            sb.append((char)(remain + 'A'));
        }
        return sb.reverse().toString();
    }
}