public class Apr4LeetCode2075 {
    public static void main(String[] args) {
        String encodedText = "iveo    eed   l te   olc";
        int rows = 4;
        System.out.println(decodeCiphertext(encodedText, rows));
    }

    public static String decodeCiphertext(String s, int rows) {
        if(rows == 1) return s;

        int col = (int) Math.ceil((double) s.length() / rows);
        char[][] matrix = new char[rows][col];

        int i = 0, j = 0;
        for (int idx = 0; idx < s.length(); idx++) {
            matrix[i][j] = s.charAt(idx);
            if(j < col - 1) {
                j++;
            } else {
                i++;
                j = 0;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int k = 0; k < col; k++) {
            int sl = 0;
            for (int l = 0; l < rows; l++) {
                if(k + sl < col) {
                    sb.append(matrix[l][k + sl]);
                    sl++;
                }
            }
        }

        return sb.toString().stripTrailing();
    }

    // public static String decodeCiphertext(String s, int rows) {
    //     if(rows == 1) return s;

    //     int col = (int) Math.ceil((double) s.length() / rows);
    //     char[][] matrix = new char[rows][col];

    //     String[] chunks = new String[col];


    //     int i = 0;
    //     for (String t: chunks) {
    //         int j = 0;
    //         for (char c: t.toCharArray()) {
    //             matrix[i][j] = c;
    //             j++;
    //         }
    //         i++;
    //     }

    //     StringBuilder sb = new StringBuilder();
    //     for (int m = 0; m < rows; m++) {
    //         for (int n = 0; n < col; n++) {
    //             sb.append(matrix[m][n]);
    //         }
    //     }

    //     return null;
    // }
}
