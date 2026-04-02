package LeetCode;

import java.util.ArrayList;
// import java.util.Collections;
import java.util.HashMap;
// import java.util.HashSet;
import java.util.List;
import java.util.Map;
// import java.util.Set;

public class LeetCode451 {
    public static void main(String[] args) {
        String s = "Aabb";
        System.out.println(frequencySort(s));
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character> list = new ArrayList<>(map.keySet());

        list.sort((a, b) -> map.get(b) - map.get(a));

        StringBuilder sb = new StringBuilder();

        for (char c : list) {
            int freq = map.get(c);
            for (int i = 0; i < freq; i++)  sb.append(c);
        }

        return sb.toString();
    }

    // public static String frequencySort(String s) {
    // int[] arr = new int[128];
    // Set<Character> set = new HashSet<>();
    // Map<Character, Integer> map = new HashMap<>();
    // StringBuilder sb = new StringBuilder();

    // for(char ch: s.toCharArray()) {
    // arr[ch]++;
    // set.add(ch);
    // }

    // for(char ch: set) {
    // map.put(ch, arr[ch]);
    // }

    // for (int i = 0; i < set.size(); i++) {
    // int max = Collections.max(map.values());
    // char ch = map.entrySet()
    // .stream()
    // .max(Map.Entry.comparingByValue())
    // .map(Map.Entry::getKey)
    // .get();
    // for(int j = 0; j < max; j++) {
    // sb.append(ch);
    // }
    // map.remove(ch);
    // }
    // return sb.toString();
    // }
}
