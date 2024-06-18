 import java.util.*;
public class Strings {
    public static boolean palindrone(String str){
       
        for(int i=0;i<str.length()/2;i++){
             int max = str.length();
            if(str.charAt(i) != str.charAt(max-1-i)){
                return false;
            }
        }
        return true;
    }

        public static float shortestpath(String str){
            int x=0,y=0;
            for(int i=0;i<str.length();i++){
                if(str.charAt(i) == 'S'){
                    y--;
                }
                else if(str.charAt(i) == 'N'){
                   y++;
                }
                else if(str.charAt(i)== 'E'){
                    x++;
                }
                else{
                    x--;
                }

            }
            int x2 = x*x;
            int y2 = y*y;
            return (float)Math.sqrt(x2+y2);
        }

        public static void substring(String str , int st,int ed){
            String sub = "";
            for(int i=st;i<ed;i++){
                sub += str.charAt(i);

            }
            System.out.print(sub);
        }

        public static void uppercase(String str){
            StringBuilder sb = new StringBuilder("");
            char ch = Character.toUpperCase(str.charAt(0));
            sb.append(ch);
            for(int i=1;i<str.length();i++){
               if(str.charAt(i) == ' ' && i<str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
               }
               else{
                sb.append(str.charAt(i));
               }
            }
            System.out.print(sb);


        }
       

    
    public static void main(String args[]){
        String str = "i am soham";
        uppercase(str);
        substring(str,0,str.length());
       
       

    }
    
}
