// import java.util.HashMap;
// import java.util.Map;

public class LeetCode205 {
    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        System.out.println(isIsomorphic(s, t));
    }
    
    public static boolean isIsomorphic(String s, String t) {
        int arrs[] = new int[128];
        int arrt[] = new int[128];
        for(int i = 0 ;i<s.length(); i++) {
            char chars = s.charAt(i);
            char chart = t.charAt(i);
            if(arrs[chars] != arrt[chart]) return false;
            arrs[chars] = i+1;
            arrt[chart] = i+1;
        }    
        return true;
    }

    // public static boolean isIsomorphic(String s, String t) {
    //     Map<Character, Character> map = new HashMap<>();
    //     for(int i = 0; i < s.length(); i++) {
    //         char sChar = s.charAt(i);
    //         char tChar = t.charAt(i);

    //         if((map.containsKey(sChar) && map.get(sChar) != tChar) 
    //         || (!map.containsKey(sChar) && map.values().contains(tChar))) 
    //             return false;
    //         map.put(sChar, tChar);
    //     }
    //     return true;
    // }
}
