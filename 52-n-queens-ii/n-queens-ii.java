class Solution {
    List<List<String>> ans = new ArrayList<>();
    private void solve(int[][] board,List<String> cl,int n,int row){
        if(row==n){
            ans.add(new ArrayList<>(cl));
            return;
        }
        for(int j=0;j<n;j++){
            StringBuilder queen = new StringBuilder();
            //Yaha par queen rakh sakte h;
            if(board[row][j]==0){
                for(int k=0;k<n;k++){
                   if(k==j){
                    queen.append("Q");
                   } 
                   else{ 
                    queen.append(".");
                   }
                }
                cl.add(queen.toString());
                //horizontal
                for(int i=0;i<n;i++){
                    board[row][i]++;
                }//vertical
                for(int i=0;i<n;i++){
                    board[i][j]++;
                }
                int dr = row;
                int dc = j;
                // fourth quadrant
                while(dr < n && dc < n){
                    board[dr][dc]++;
                    dr++;
                    dc++;
                }
                dr=row;
                dc=j;
                //first quadrant
                while(dr >= 0 && dc < n){
                    board[dr][dc]++;
                    dr--;
                    dc++;
                }
                dr=row;
                dc=j;
                //second quadrant
                while(dr >= 0 && dc >= 0){
                    board[dr][dc]++;
                    dr--;
                    dc--;
                }
                dr=row;
                dc=j;
                //third quadrant
                while(dr < n && dc >= 0){
                    board[dr][dc]++;
                    dr++;
                    dc--;
                }
                //calling recursion for backtracking
                solve(board,cl,n,row+1);
                //backtracking start here:
                dr=row;
                dc=j;
                // fourth quadrant
                while(dr < n && dc < n){
                    board[dr][dc]--;
                    dr++;
                    dc++;
                }
                dr=row;
                dc=j;
                //first quadrant
                while(dr >= 0 && dc < n){
                    board[dr][dc]--;
                    dr--;
                    dc++;
                }
                dr=row;
                dc=j;
                //second quadrant
                while(dr >= 0 && dc >= 0){
                    board[dr][dc]--;
                    dr--;
                    dc--;
                }
                dr=row;
                dc=j;
                //third quadrant
                while(dr < n && dc >= 0){
                    board[dr][dc]--;
                    dr++;
                    dc--;
                }
                for(int i=0;i<n;i++){
                    board[i][j]--;
                }
                //horizontal
                for(int i=0;i<n;i++){
                    board[row][i]--;
                }
                cl.remove(cl.size()-1);
            }
        }
        return;
    }
    public int totalNQueens(int n) {
        int row = 0;
        int[][] board = new int[n][n];
        List<String> CurrentList = new ArrayList<>();
        solve(board,CurrentList,n,row);
        return ans.size();
    }
}