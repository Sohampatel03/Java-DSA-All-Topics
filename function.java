import java.util.*;

public class function{
  public static void prime(int binanum){
    int mynumber = binanum;
    int pow = 0;
    int deci = 0 ;
    while(binanum > 0){
      int lastdig = binanum%10;
      deci = deci+(lastdig*(int)Math.pow(2,pow));
      pow++;
      binanum = binanum/10;


    }
    System.out.print("binary number is"+mynumber +"decimalc number is "+deci);
  }

  public static void deci(int n){
    int mynum = n;
    int pow = 0;
    int bina = 0;
    while(n>0){
      int rem = n % 2 ;
      bina = bina+(rem*(int)Math.pow(10,pow));
      pow++;

      n  = n/2;

    }
    System.out.print("the binary form of"+mynum +"="+bina);


  }

  

  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
prime(n);

  }

}
