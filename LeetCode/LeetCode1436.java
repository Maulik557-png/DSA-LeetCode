import java.util.*;

public class LeetCode1436 {
    public static void main(String[] args) {
        List<String> l1 = Arrays.asList("London", "New York");
        List<String> l2 = Arrays.asList("New York", "Lima");
        List<String> l3 = Arrays.asList("Lima", "Sao Paulo");

        System.out.println(destCity(Arrays.asList(l1, l2, l3)));
    }

    public static String destCity(List<List<String>> paths) {
        if (paths.size() == 1) return paths.get(0).get(1);
        Set<String> set = new HashSet<>();
        for(List<String> l: paths) set.add(l.get(0));
        for(List<String> l: paths) if(!set.contains(l.get(1))) return l.get(1);
        return "";
    }

    // public static String destCity(List<List<String>> paths) {
    //     if (paths.size() == 1) return paths.get(0).get(1);
    //     Map<String, Integer> map = new HashMap<>();
    //     for(List<String> l: paths) map.put(l.get(0), map.getOrDefault(l.get(0), 0) + 1);
    //     for(List<String> l: paths) if(!map.containsKey(l.get(1))) return l.get(1);
    //     return "";
    // }
}
