class Solution {
    public void solveSudoku(char[][] board) {
        solve(board); //call the funtion
    }
    private boolean solve(char[][] board){
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){

                if(board[i][j] == '.'){  //find empty space 

                for(char c = '1'; c<= '9'; c++){  // to fill only 1 tp 9
                    if(IsValid(board, i, j, c)){   //cheak follew all three 3 valid     conditions
                        board[i][j] = c;  //if yes then fill

                        if(solve(board) == true){  //call the recusily funtion
                        return true;
                        }
                        else{  
                            //backtraking removing last inserted number
                            board[i][j] = '.';
                        }
                        }
                } //if we can not fil 1 to 9 number, not even one single number to fill
                return false;
                }

            }
               
        }
        //we fil all numbers in 9*9 matrix -> find valid suduku
        return true; 
    }
    private boolean IsValid(char[][] board, int row, int col, char c){
        //matric lia row-> 0 to 8  and colum -> 0 to 8
        for(int i = 0; i<9; i++){
            //cheak it dose not conatin in row same char c -> '1 TO 9'
            if(board[row][i] == c){
                return false;
            }

            //cheak it dose not contains in colum in same char c -> '1 TO 9'
            if(board[i][col] == c){
                return false;
            }

            //now cheak only 3*3 matrix not conatis same char c -> '1 TO 9'
            if(board[ 3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] == c){
                return false;
            }

        }
        //if it follw all three conditions then return true
        return true;
    }
}