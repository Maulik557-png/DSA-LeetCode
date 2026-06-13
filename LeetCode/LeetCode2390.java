import java.util.*;

public class LeetCode2390 {
    public static void main(String[] args) {
        String s = "leet**cod*e";
        System.out.println(removeStars(s));
    }

    // v3 StringBuilder as Stack
    // public static String removeStars(String s) {
    //     StringBuilder sb = new StringBuilder();
    //     for (char ch : s.toCharArray()) {
    //         if (ch == '*') {
    //             sb.deleteCharAt(sb.length() - 1);
    //         } else {
    //             sb.append(ch);
    //         }
    //     }
    //     return sb.toString();
    // }

    // v2 (36 ms)
    public static String removeStars(String s) {
        Deque<Character> st = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                st.pop();
            } else {
                st.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (st.size() > 0) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }

    // v1 (80 ms)
    // public static String removeStars(String s) {
    //     Stack<Character> st = new Stack<>();

    //     for (char ch : s.toCharArray()) {
    //         if (ch == '*') {
    //             st.pop();
    //         } else {
    //             st.push(ch);
    //         }
    //     }

    //     StringBuilder sb = new StringBuilder();

    //     while (st.size() > 0) {
    //         sb.append(st.pop());
    //     }

    //     return sb.reverse().toString();
    // }
}
