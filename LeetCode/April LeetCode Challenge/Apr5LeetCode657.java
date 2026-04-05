// import java.util.HashMap;
// import java.util.Map;

public class Apr5LeetCode657 {

    public static void main(String[] args) {
        String moves = "UD";

        System.out.println(judgeCircle(moves));
    }

    public static boolean judgeCircle(String moves) {
        int[] ch = new int[26];
        for (char c : moves.toCharArray()) ch[c - 'A']++;
        return ch['U' - 'A'] == ch['D' - 'A'] && ch['L' - 'A'] == ch['R' - 'A'];
    }

    // public static boolean judgeCircle(String moves) {
    // int R = 0;
    // int U = 0;
    // for (char c : moves.toCharArray()) {
    // switch (c) {
    // case 'R' -> R++;
    // case 'L' -> R--;
    // case 'U' -> U++;
    // default -> U--;
    // }
    // }
    // return R == 0 && U == 0;
    // }

    // public static boolean judgeCircle(String moves) {
    // Map<Character, Integer> map = new HashMap<>();
    // for (char c : moves.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
    // return (map.getOrDefault('R', 0) - map.getOrDefault('L', 0) == 0) &&
    // (map.getOrDefault('U', 0) - map.getOrDefault('D', 0) == 0);
    // }

    // public static boolean judgeCircle(String moves) {
    // int R = 0;
    // int U = 0;

    // for (char c : moves.toCharArray()) {
    // if (c == 'R') {
    // R++;
    // } else if (c == 'L') {
    // R--;
    // } else if (c == 'U') {
    // U++;
    // } else {
    // U--;
    // }
    // }
    // return R == 0 && U == 0;
    // }
}
