public class NQueens {

    public static boolean isSafe(char board[][],int row,int col){

        //vertical check:
        for(int i=row-1;i>=0;i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        //diagnol-left:
        for(int i=row-1 ,j=col-1; i>=0 && j>=0 ;i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        //diagnol-right:
        for(int i=row-1,j=col+1;i>=0 && j<=board.length-1;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
     

    static int count =0;
    public static void nQueens(char board[][],int row){
        if(row == board.length){ 
            print(board);
            // count++;
            return;
        }

        for(int col=0;col<board.length;col++){
            if(isSafe(board,row,col)){
                board[row][col] = 'Q';
                nQueens(board, row+1); // function call
                board[row][col] = 'x';  //backtracking
            }
        }
    }

    public static void print(char board[][]){
        System.out.println("-----------chess board------");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
               System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n = 4;
        char board[][] = new char[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = 'X';
            }
        }

        nQueens(board,0);
        System.out.println("The total counts are : " + count);
    }
}