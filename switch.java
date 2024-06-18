import java.util.*;

public class switch{
   
   // private static final String Break = null;

    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();


char operator  = sc.next().charAt(0)  ;
switch(operator){
    case '+' : System.out.println("1 number dabaya h apne ne"+(a+b));
    break;
    case '-' : System.out.println("2 number dabaya h apne ne"+(a-b));
    break;
    case '%' : System.out.println("3 number dabaya h apne"+(a%b));
    break;
    case '*' :System.out.println("humare network se bahar ho ap"+(a*b));
}

    }
}
    

