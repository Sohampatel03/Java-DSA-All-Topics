import java.util.Collections;
import java.util.ArrayList;
import java.util.*;

public class arraylist {
    public static void swap(ArrayList<Integer> list, int indx1, int indx2) {
        int temp = list.get(indx1);
        list.set(indx1, list.get(indx2));
        list.set(indx2, temp);
    }

    public static void trapwater(ArrayList<Integer> list) {
        int maxwater = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int height = Math.min(list.get(i), list.get(j));
                int widgth = j - i;
                int trapwater = height * widgth;
                maxwater = Math.max(trapwater, maxwater);
            }
        }
        System.out.println(maxwater);

    }

    public static void twopointertrapwater(ArrayList<Integer> list) {
        int maxwater = 0;
        int lp = 0;
        int rp = list.size() - 1;
        while (lp < rp) {
            int height = Math.min(list.get(lp), list.get(rp));
            int widgth = rp - lp;
            int curr = height * widgth;
            maxwater = Math.max(curr, maxwater);
            if (list.get(lp) < list.get(rp)) {
                lp++;
            } else {

                rp--;
            }

        }
        System.out.print(maxwater);

    }

    public static boolean pairsum(ArrayList<Integer> list, int target) {
        int lp = 0;
        int rp = list.size() - 1;
        while (lp != rp) {
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            }
            if (list.get(lp) + list.get(rp) < target) {
                lp++;
            } else {
                rp--;
            }
        }
        return false;
    }
    public static boolean mono(ArrayList<Integer> list){
        boolean inc = true;
        boolean dec = true;
        for(int i = 0;i<list.size()-1;i++){
            if(list.get(i) < list.get(i+1)){
                dec = false;
            }
            if(list.get(i) > list.get(i+1)){
                inc = false;
            }
            
        }
        return inc || dec;
    }

    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> mainlist = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        // list.add(4);
        // list.add(5);
        // list.add(6);

       // trapwater(list);
        //twopointertrapwater(list);
        System.out.print(mono(list));
        // mainlist.add(list);
        // ArrayList<Integer> list2 = new ArrayList<>();
        // list2.add(3);
        // list2.add(4);
        // mainlist.add(list2);
        // for(int i =0;i<mainlist.size();i++){
        // ArrayList<Integer> currlist = mainlist.get(i);
        // for(int j = 0; j<currlist.size();j++){
        // System.out.print(currlist.get(j));
        // }
        // System.out.println();
        // }
    }
}
