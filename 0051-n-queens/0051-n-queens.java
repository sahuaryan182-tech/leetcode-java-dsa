class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0; i<n; i++){
            Arrays.fill(board[i], '.');
        }
        solve(0, board, ans, n);
        return ans;
        
    }
    private void solve(int col, char[][] board, List<List<String>> ans, int n){

            if(col == n){
                List<String> temp = new ArrayList<>();
                for(int i = 0; i<n; i++){
                temp.add(new String(board[i]));
                }
                ans.add(temp);
                return;
            }


        for(int row = 0; row < n; row++){
           if(isSafe(row, col, board, n)){
            board[row][col] = 'Q';
            solve(col + 1, board, ans, n);
            board[row][col] = '.';
            }

        }
    }
    private boolean isSafe(int row, int col, char[][] board, int n){

        int drow = row;
        int dcol = col;

        while(col >= 0 && row >= 0){
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = drow;
        col = dcol;

        while(col >= 0){
            if(board[row][col] == 'Q') return false;
            col--;
        }

        row = drow;
        col = dcol;

        while(row < n && col >= 0){
            if(board[row][col] == 'Q') return false;
            row++;
            col--;
        }
        return true;
    }
}