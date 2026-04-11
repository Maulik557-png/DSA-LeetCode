import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode1496 {

    public static void main(String[] args) {
        String path = "NES";
        System.out.println(isPathCrossing(path));
    }

    public static boolean isPathCrossing(String path) {
        Set<List<Integer>> set = new HashSet<>();
        set.add(Arrays.asList(0, 0));
        int x = 0, y = 0;
        for (char d: path.toCharArray()) {
            switch (d) {
                case 'N' -> y++;
                case 'S' -> y--;
                case 'E' -> x++;
                case 'W' -> x--;
            }
            List<Integer> ls = Arrays.asList(x, y);
            if (set.contains(ls)) return true;
            set.add(ls);
        }
        return false;
    }

    // public static boolean isPathCrossing(String path) {
    //     Set<String> set = new HashSet<>();
    //     int x = 0;
    //     int y = 0;
    //     set.add(0 + "," + 0);
    //     for(char p: path.toCharArray()) {
    //         switch(p) {
    //             case 'N' -> y++;
    //             case 'S' -> y--;
    //             case 'E' -> x++;
    //             case 'W' -> x--;
    //         }
    //         String co = x + "," + y;
    //         if(set.contains(co)) return true;
    //         set.add(co);
    //     }
    //     return false;
    // }
}
