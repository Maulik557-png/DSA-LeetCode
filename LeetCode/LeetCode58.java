package LeetCode;

public class LeetCode58 {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    }

    // public static int lengthOfLastWord(String s) {

    // String newString = s.strip();
    // char space = ' ';

    // int counter = -1;

    // for (int i = 0; i < newString.length(); i++) {
    // if(newString.charAt(i) == space) {
    // counter = i;
    // }
    // }

    // String sub = newString.substring(counter + 1);

    // return sub.length();
    // }

    // public static int lengthOfLastWord(String s) {

    // String trimmedString = s.strip();
    // StringBuilder sb = new StringBuilder(trimmedString);
    // String reversedString = sb.reverse().toString();

    // char space = ' ';
    // int counter = 0;

    // for (int i = 0; i < reversedString.length(); i++) {
    // if(reversedString.charAt(i) != space) {
    // counter++;
    // }
    // else break;
    // }

    // return counter;
    // }

    // public static int lengthOfLastWord(String s) {
    //     String str = new StringBuilder(s.strip()).reverse().toString();
    //     int count = 0;

    //     for (int i = 0; i < str.length(); i++) {
    //         if (str.charAt(i) != ' ')
    //             count++;
    //         else
    //             break;
    //     }

    //     return count;
    // }

    public static int lengthOfLastWord(String s) {
        s = s.trim();
        return s.length() - s.lastIndexOf(' ') - 1;
    }
}
