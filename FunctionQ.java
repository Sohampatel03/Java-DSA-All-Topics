import java.util.*;

public class FunctionQ {
    public static int lol(int x , int y,int z){
    int avg = (x+y+z)/3;
    return avg ;
   
}

    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
       
         System.out.print(lol(a,b,c));


    }
}


