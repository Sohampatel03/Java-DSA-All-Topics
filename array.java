import java.util.*;

public class array {
    public static void pair(int mark[]) {
        int total = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < mark.length; i++) {

            for (int j = i; j < mark.length; j++) {
                sum = 0;

                for (int k = i; k <= j; k++) {

                    System.out.print(mark[k] + " ");

                    sum = sum + mark[k];

                    if (max < sum) {
                        max = sum;
                    }
                }
                total++;
                System.out.print(" = " + sum);
                System.out.println();

            }
            System.out.print("sum of first subarray" + sum);
            System.out.println();

        }
        System.out.println("total is" + total);
        System.out.print("the max number" + max);
    }

    public static void kadanes(int mark[]) {
        int ms = Integer.MIN_VALUE;
        int curr = 0;
        for (int i = 0; i < mark.length; i++) {
            curr = curr + mark[i];
            if (curr < 0) {
                curr = 0;
            }
            ms = Math.max(curr, ms);
        }
        System.out.print("maximum sun array is = " + ms);
    }
    
    public static int trappedwater(int mark[]) {
        int n = mark.length;
        int leftmax[] = new int[n];
        leftmax[0] = mark[0];
        // for left max vlaue
        for (int i = 1; i < n; i++) {
            leftmax[i] = Math.max(mark[i], leftmax[i - 1]);
        }
        // for right max value
        int rightmax[] = new int[n];
        rightmax[n - 1] = mark[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightmax[i] = Math.max(mark[i], rightmax[i + 1]);
        }
        int trappedwater = 0;
        for (int i = 1; i < n; i++) {
            int waterlevel = Math.min(leftmax[i], rightmax[i]);
            trappedwater += waterlevel - mark[i];

        }
        return trappedwater;

    }

    public static int buyandsell(int mark[]) {
        int buyprice = Integer.MAX_VALUE;
        int maxprice = 0;
        for (int i = 0; i < mark.length; i++) {
            if (buyprice < mark[i]) {
                int profit = mark[i] - buyprice;
                maxprice = Math.max(profit, maxprice);
            } else {
                buyprice = mark[i];
            }
        }
        return maxprice;

    }

    public static void main(String args[]) {
        int mark[] = { 7, 1, 5, 3, 6, 4 };
        System.out.print(buyandsell(mark));

    }
}