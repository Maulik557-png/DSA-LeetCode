public class Apr24LeetCode2833 {
    public static void main(String[] args) {
        String moves = "L_RL__R";
        System.out.println(furthestDistanceFromOrigin(moves));

        
    }

    public static int furthestDistanceFromOrigin(String moves) {
        int net = 0;
        int blanks = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
               case 'R' -> net++;
               case 'L' -> net--;
               case '_' -> blanks++;
            }
        }
        return Math.abs(net) + blanks;
    }

    // public static int furthestDistanceFromOrigin(String moves) {
    //     int cR = 0;
    //     int cL = 0;
    //     int cA = 0;

    //     for (char c : moves.toCharArray()) {
    //         switch (c) {
    //             case 'R' -> cR++;                    
    //             case 'L' -> cL++;
    //             case '_' -> cA++;
    //         }
    //     }

    //     if(cL >= cR) {
    //         cL += cA;
    //     } else {
    //         cR += cA;
    //     }

    //     return Math.abs(cL - cR);
    // }
}
