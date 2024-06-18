import java.util.*;

public class patterns{

    public static void hollowptrn(int x , int y){
        for(int i = 1; i<=x;i++){

            for(int j=1;j<=y;j++){
                if(i == 1 || i == x || j == 1 || j == y){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }


            }
            System.out.println();
        }


    }


    public static void invertptrn(int x ){
        for(int i=1;i<=x;i++){

            for(int j=1;j<=x-i;j++){
                System.out.print(" ");

            }

            for( int j=1;j<=i;j++){
                System.out.print("*");
            }

            System.out.println();
            
            
        }

    }

    public static void inverthptrn(int n){
        for(int i=1; i<=n;i++){
            for(int j=1;j<=n-i+1;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void floydptrn(int n){
        int counter =1 ;
        for(int i =1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(counter +" ");
                counter++;
            }
            System.out.println();

        }

    }

    public static void zero_oneptrn(int n){
        for(int i=1; i<=n;i++){
            for(int j=1;j<=i;j++){
                if((i+j) % 2 == 0){
                    System.out.print("1");
                }
                else{
                    System.out.print("0");
                }
            }
            System.out.println();
        }


    }

    public static void butterfly(int n){
        for(int i=1;i<=n; i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            for(int j =1;j<=2*(n-i);j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i=n;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            for(int j =1;j<=2*(n-i);j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();

        }
    }

    public static void rhombus(int n){
        for(int i=1;i<=n;i++){
           for(int j=1;j<=n-i;j++){
            System.out.print(" ");
           }
           for(int j=1;j<=n;j++){
            System.out.print("*");
           }
           System.out.println();
        }

    }

    public static void hrhombus(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=n;j++){
                if(i == 1 || i == n || j == 1 || j == n){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void daimond(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=(2*i)-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }

         for(int i=n;i>=1;i--){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=(2*i)-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }


    }

    public static void npyramid(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=(n-i);j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static void palindromic(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=(n-i);j++){
                System.out.print(" ");
            }
            for(int j=i;j>=1;j--){
                System.out.print(j);
            }
            for(int j=2;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }

    }
    


    public static void main(String args[]){
       Scanner sc = new Scanner(System.in);
       System.out.print("enter the rows and colounms");
       int a = sc.nextInt();
          palindromic(a);


    
    }
}