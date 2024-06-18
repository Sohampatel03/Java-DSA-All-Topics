import java.util.*;

public class Hashset {
    public static void main(String args[]) {
        HashSet<String> set = new HashSet<>();
        set.add("Indore");
        set.add("Bhopal");
        set.add("Jabalpur");
        set.add("Khandwa");
        set.add("Telangana");

        Iterator i = set.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }

}
