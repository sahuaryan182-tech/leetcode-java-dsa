class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        //create a cheas-board
        char [][] board = new char[n][n];

        //filles board with '.' string
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                board[i][j] = '.';
            }
        }
        //call the Recursive function
        solve(0, board, ans, n);
        //return thr ans
        return ans;
    }
    //Backtraking Recusive function
    private void solve(int col, char [][] board, List<List<String>> ans, int n){
        
        //Base Case: if all colum are filled
        if(col == n){
            List<String> temp = new ArrayList<>(); //store whole ans board
            for(int i = 0; i<n; i++){
                temp.add(new String(board[i])); //add borad in temp
            }
            ans.add(temp); //add temp , whole ans in board
            return;
        }

        //trying placing Queen each and every row
        for(int row = 0; row<n; row++){
            //call a function that tell is it same to place it queen
            if(isSafe(row, col, board, n)){

                //if true function then placing a queen
                board[row][col] = 'Q';

                //call the recusive funtion and move next colum
                solve(col + 1, board, ans, n);

                //Backtraking , go back -> remove Q by replaceing -> '.' character
                board[row][col] = '.';
            }
        }
    }
    //Cheak whetever we can place a Queen at n * n chead borad[row][col]
    private boolean isSafe(int row, int col, char [][] board, int n){
        //we cheak only  3 diraction , left, upper-left diagonal, lower-left-diagonal, beacause we move or place a queen in left to rigth direction so no  need to cheak rigth side directions

        //Cheak : upper- left- diagobnal -> row & col dicrese
        int dupRow = row;
        int dupCol = col;

        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q'){
                return false;
            }
            row--;
            col--;
        }

        //cheak: left side of the same row -> only  col is dicrease , same row
        row = dupRow;
        col = dupCol;

        while(col >= 0){
            if(board[row][col] == 'Q'){
                return false;
            }
            col--;
        }

        //cheak: lower - left - diagonal -> col is dicrease & row is increase becaue we go lower-left-diagonal
        row = dupRow;
        col = dupCol;

        while(row <n && col >= 0 ){
            if(board[row][col] == 'Q'){
                return false;
            }
            row++;
            col--;
        }
        //if non of the above comditions is true the retur true
        return true;
    }
}