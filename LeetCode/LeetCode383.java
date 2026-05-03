// import java.util.ArrayList;

public class LeetCode383 {
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    // public static boolean canConstruct(String ransomNote, String magazine) {
    //     if(ransomNote.length() > magazine.length())  return false;

    //     ArrayList<Character> list = new ArrayList<>();
    //     for (Character ch : magazine.toCharArray())  list.add(ch);

    //     for (int i = 0; i < ransomNote.length(); i++) {
    //         if(!list.contains(ransomNote.charAt(i)))  return false;
    //         else  list.remove(list.indexOf(ransomNote.charAt(i)));
    //     }
    //     return true;   
    // }

    public static boolean canConstruct(String ransomNote, String magazine)  {
        int[] arr = new int[26];
        for(int i = 0; i < magazine.length(); i++)    {
            arr[magazine.charAt(i) - 'a']--;
        }
        for(int i = 0; i < ransomNote.length(); i++)    {
            arr[ransomNote.charAt(i) - 'a']++;
        }
        for(int i: arr) {
            if(i > 0)  return false;
        }
        return true;
    }  
}
