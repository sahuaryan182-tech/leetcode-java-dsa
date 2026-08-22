class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        //traverse each cell
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                //if we found frist chater in word , we seach for next word , character -> backtracking top, bottom, left, rigth
                if(board[i][j] == word.charAt(0) && find(board, i, j, 0, word)){
                    return true;
                }
            }
        }
        //if we not found return false
        return false;
    }

     //find the next(after frist character, latter) character, latter in cell that mactch in word, and backtring
    private boolean find(char[][] board, int i, int j, int index, String word){
            //we tarverse all word length or idex reaches word length means we found 
            if(index == word.length()) return true;

            //Boundry mistmatch cheak
            if(i<0 || j<0 || i>= board.length || j>= board[0].length || board[i][j] == '$') return false;

            //board cell charater, not macth wrod character
            if(board[i][j] != word.charAt(index)) return false;

            //if we found word
            //backtraking -> store found word, maker it or visited as -> $, and backtarking next found word is all possibilites -> top, bottom, left, rigth
            char temp = board[i][j]; //store
            board[i][j] = '$'; //markit or visited
            //found all posibites -> top, bottom, left, rigth
             // Explore in all four directions
            boolean found = find(board,  i + 1, j, index + 1, word) || //-> (1, 0)
                            find(board,  i - 1, j, index + 1, word) || //-> (-1, 0)
                            find(board,  i, j + 1, index + 1, word) || //-> (0, 1)
                            find(board,  i, j - 1, index + 1, word); //-> (0, -1)

            
            //backtraking -> re-store character
            board[i][j] = temp;

            return found;
    }
    
}