import java.util.*;

public class selectionsort {
   public static void main(String args[]) {
      int a[] = { 2, 4, 7, 1, 5 };
      int al = a.length;
      int max = Integer.MAX_VALUE;

      for (int i = 0; i < al - 1; i++) {
         int index = i;

         for (int j = i + 1; j < al; j++) {
            if (a[j] < a[index]) {
               index = j;

            }

         }
         int tem = a[index];
         a[index] = a[i];
         a[i] = tem;

      }
      for (int i = 0; i < a.length; i++) {
         System.out.print(a[i]);
      }

   }

}
