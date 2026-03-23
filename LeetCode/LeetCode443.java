public class LeetCode443 {

    public static int compress(char[] chars) {
        int write = 0;  // position to write next compressed character
        int read = 0;   // position to read characters

        while (read < chars.length) {
            char currentChar = chars[read];
            int count = 0;

            // count how many times currentChar repeats consecutively
            while (read < chars.length && chars[read] == currentChar) {
                read++;
                count++;
            }

            // write the character
            chars[write++] = currentChar;

            // if count > 1, write each digit of the count
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write; // new length of compressed array
    }

    public static void main(String[] args) {
        char[] chars = {'a','a','a','a','b','b','c','c','c'};
        int newLength = compress(chars);

        System.out.print("Compressed Array: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(chars[i] + " ");
        }
        System.out.println("\nNew Length: " + newLength);
    }
}
