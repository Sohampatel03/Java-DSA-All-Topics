public class backtracking {
    public static void main(String args[]) {
       // int n = 3,m = 3;
       // int s = gridways(0,0,n,m);
      //  System.out.print(s);
      int n =4 ;
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '0';
            }
        }
        nqueen(board, 0);
 
        // System.out.print(count);*/
    }
    public static int gridways(int i,int j,int n,int m){
        if(i==n-1 && j==m-1){
            return 1;
        }else if(i == n || j == m){
            return 0;
        }
        return gridways(i+1,j,n,m) + gridways(i,j+1,n,m);
    }

    public static boolean issafe(char board[][], int row, int col) {
        // vertical safe
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == '1') {
                return false;
            }
        }
        // daigonal left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == '1') {
                return false;
            }
        }
        // daigonal right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == '1') {
                return false;
            }
        }
        return true;
    }

    static int count = 0;

    public static void nqueen(char board[][], int row) {
        if (row == board.length) {
            count++;
            printboard(board);
            return;
        }// else {
          //  System.out.println("not found"); 
     //   }
        for (int j = 0; j < board.length; j++) {
            if (issafe(board, row, j)) {
                board[row][j] = '1';
                nqueen(board, row + 1);
                board[row][j] = '0';
            }
        }
    }

    public static void printboard(char board[][]) {
        System.out.println("------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            // System.out.println();
        }
    }

    /*
     * public static void subset(String s,String e,int i){
     * if(i == s.length()){
     * System.out.print(e);
     * return;
     * }
     * subset(s,e+s.charAt(i)i+1);
     * subset(s,e,i+1);
     * }
     */
    public static void printarr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    public static void findpermutation(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
        }
        for (int i = 0; i <= str.length() - 1; i++) {
            char curr = str.charAt(i);
            String Newstr = str.substring(0, i) + str.substring(i + 1);
            findpermutation(Newstr, ans + curr);
        }
    }

    public static void arrbacktra(int arr[], int i, int value) {
        if (i == arr.length) {
            printarr(arr);
            return;
        }

        arr[i] = value;
        arrbacktra(arr, i + 1, value + 1);
        arr[i] = arr[i] - 2;
    }
}
