import java.util.*;
public class java{
    public static void printspiral(int matrix[][]){
        int strow =0;
        int endrow = matrix.length-1;
        int stcol = 0;
        int endcol = matrix[0].length-1;
        while(strow <=endrow && stcol <=endcol){
            for(int j=stcol;j<=endcol;j++){
                System.out.print(matrix[strow][j]+" ");
            }
            for(int i=strow+1;i<=endrow;i++){
                System.out.print(matrix[i][endcol]+" ");
            }
            for(int j=endcol-1;j>=stcol;j--){
                 if(strow == endrow){
                    break;
                }
               
                System.out.print(matrix[endrow][j]+" ");
            }
            for(int i=endrow-1;i>=strow+1;i--){
                 if(stcol == endcol){
                    break;
                }
                System.out.print(matrix[i][stcol]+" ");
            }
            strow++;
            stcol++;
            endrow--;
            endcol--;
        }
        System.out.println();

    }
    public static boolean search(int matrix[][],int key){
        for(int i=0;i<matrix.length;i++){
    for(int j=0;j<matrix[0].length;j++){
        if(matrix[i][j] == key){
            System.out.print(i+" ,"+j);
            return true;
        }
    }
}
System.out.print("not found");
return false;
    }
    public static int diagonal(int matrix[][]){
        int sum =0;
        for(int i=0;i<matrix.length;i++){
            sum += matrix[i][i];
            if(i != matrix.length-1-i){
                sum += matrix[i][matrix.length-1-i];
            }
        }
        return sum;
    }

    public static boolean staircasesearch(int matrix[][],int key){
        int row =0, colounm = matrix[0].length-1;
        while(row < matrix.length && colounm >=0){
            if(matrix[row][colounm] == key){
            System.out.print(row+","+colounm);
            return true;
            }
        else if(key < matrix[row][colounm]){
             colounm--;
        }
        else{
            row++;
        }
         }
         return false;
    

    }
    public static void main(String args[]){
        int matrix[][] = {{1,2,3,4},
                           {5,6,7,8},
                        {9,10,11,12},
                    {13,14,15,16} };
                    int key = 16;
                
            staircasesearch(matrix,key) ; 
    }
}
      /*    int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int key = 5;
       int matrix[][] = new int[3][3];
        int n = matrix.length , m= matrix[0].length;
         Scanner sc = new Scanner(System.in);
for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
        matrix[i][j] = sc.nextInt();
        if(matrix[i][j]<min){
            min = matrix[i][j];
        }
    }
}
System.out.println("max is "+min);
for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
        System.out.print(matrix[i][j]+" ") ;
    }
     System.out.println();
}

     search(matrix,5);

    }*/
    

   