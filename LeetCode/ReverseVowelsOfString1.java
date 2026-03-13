//Most complex and bullshit way of solving this problem
//Never recommanded

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class ReverseVowelsOfString1 {
    public static String reverseVowels(String s) {
        String vowel = "aAeEiIoOuU";
        Map<Integer, Character> index = new Hashtable<>();
        
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j < vowel.length(); j++) {
                if(s.charAt(i) == vowel.charAt(j)) {
                    index.put(i, s.charAt(i)); // Use original character
                }
            }
        }

        int[] keys = index.keySet().stream()
                .mapToInt(Integer::intValue)
                .toArray();

        // Collect vowels in a list to preserve order
        List<Character> revList = new ArrayList<>();
        for (int key : keys) {
            revList.add(index.get(key));
        }

        int left = 0;
        int right = revList.size() - 1;

        while (left < right) {
            char temp = revList.get(left);
            revList.set(left, revList.get(right));
            revList.set(right, temp);
            left++;
            right--;
        }

        char[] result = s.toCharArray();
        for(int i = 0; i < keys.length; i++) {
            result[keys[i]] = revList.get(i);
        }

        return new String(result);
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(reverseVowels(s));
    }
}
