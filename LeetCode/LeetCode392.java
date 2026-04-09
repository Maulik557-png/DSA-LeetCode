public class LeetCode392 {

    // public static boolean isSubsequence(String s, String t) {

    //     if(s.length() > t.length()) return false;

    //     char[] arrayOfT = t.toCharArray();
    //     char[] arrayOfS = s.toCharArray();

    //     int indexOfS = 0;
    //     int indexOfT = 0;

    //     int res = 0;
        
    //     while(indexOfS < s.length() && indexOfT < t.length())   {
    //         if (arrayOfS[indexOfS] == arrayOfT[indexOfT]) {
    //             indexOfT++;
    //             indexOfS++;
    //             res++;
    //         }
    //         else  indexOfT++;
    //     }

    //     return res == s.length();
    // }

    public static boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;

        int indexOfS = 0;
        int indexOfT = 0;

        while (indexOfS < s.length() && indexOfT < t.length()) {
            if (s.charAt(indexOfS) == t.charAt(indexOfT)) {
                indexOfS++;
            }
            indexOfT++;
        }

        return indexOfS == s.length();
    }

    public static void main(String[] args) {
        
        String s = "abc";
        //          012
        String t = "ahbgdc";
        //          012345

        System.out.println(isSubsequence(s, t));
    }
}
