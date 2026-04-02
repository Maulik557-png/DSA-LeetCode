package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode49 {
    public static void main(String[] args) {
        String[] str = { "eat", "tea", "tan", "ate", "nat", "bat" };
        groupAnagrams(str);
        for (String string : str) {
            System.out.println(string);
        }
    }

    // public static void groupAnagrams(String[] str) {
    // int[] ascii = new int[str.length];
    // Map<Integer, List<String>> map = new HashMap<>();

    // List<String> list = new ArrayList<>();
    // // List<List<String>> l = new ArrayList<>();

    // for (int i = 0; i < ascii.length; i++) {
    // for (char c : str[i].toCharArray()) {
    // ascii[i] |= (1 << (c - 'a'));
    // }
    // if(map.containsKey(ascii[i])) {
    // // list.add(map.get(ascii[i]));
    // list.add(str[i]);
    // } else {
    // map.put(ascii[i], str[i]);
    // }
    // // l.add(list);
    // for (String string : list) {
    // System.out.println(string);
    // }
    // }

    // // return l;
    // }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];

            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            String key = Arrays.toString(count);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
