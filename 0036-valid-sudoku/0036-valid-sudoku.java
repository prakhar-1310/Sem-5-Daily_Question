class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i=0;i<board.length;i++){  // for row
            HashSet <Character> set = new HashSet<>();
            for (int j=0;j<board[0].length;j++){
                if(set.contains(board[i][j])){
                    return false;
                }
                if (board[i][j]=='.'){
                    continue;
                }
                else{
                    set.add(board[i][j]);
                }
            }
        }

        for (int j=0;j<board[0].length;j++){  // for column
            HashSet <Character> set = new HashSet<>();
            for (int i=0;i<board.length;i++){
                if(set.contains(board[i][j])){
                    return false;
                }
                if (board[i][j]=='.'){
                    continue;
                }
                else{
                    set.add(board[i][j]);
                }
            }
        }
        for (int i=0;i<board.length;i+=3){
            int sr =i;
            int er =i+2;
            for (int j=0;j<board[0].length;j+=3){
                int sc =j;
                int ec =j+2;
                HashSet <Character> set = new HashSet<>();
                for (int k=sr;k<=er;k++){
                    for (int l=sc;l<=ec;l++){
                        if(set.contains(board[k][l])){
                            return false;
                        }
                        if (board[k][l]=='.'){
                            continue;
                        }
                        else{
                            set.add(board[k][l]);
                        }
                    }
                }
            }
        }


        return true;
    }
}