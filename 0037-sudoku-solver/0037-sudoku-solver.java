class Solution {
    public void solveSudoku(char[][] board) {
        helper(board,0,0);
    }
    public static boolean helper(char board[][],int row,int col){
        if(col==9){
            row++;
            col=0;
        }
        if(row==9){
            return true;
        }
        if(board[row][col]!='.'){
            return helper(board,row,col+1);
        }
        else{
            for(int val=1;val<=9;val++){
                if(isitsafe(board,row,col,val)){
                    board[row][col]=(char)(val+'0');
                    boolean ans = helper(board,row,col+1);
                    if(ans){
                        return true;
                    }
                    board[row][col]='.';
                }
            }
        }
        return false;
    }

    public static boolean isitsafe(char board[][],int row,int col, int value){
        char val = (char)(value+'0');
        for(int i=0;i<board[0].length;i++){ // row
            if(board[row][i]==val){
                return false;
            }
        }

        for(int i=0;i<board.length;i++){ // col
            if(board[i][col]==val){
                return false;
            }
        }

        int r = row - row%3;
        int c = col - col%3;

        for(int i=r;i<r+3;i++){   // 3*3 matrix
            for(int j=c;j<c+3;j++){
                if(board[i][j]==val){
                    return false;
                }
            }
        }
        return true;
    }
}