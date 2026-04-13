import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode187 {
    public static void main(String[] args) {
        String s = "AAAAAAAAAAA";
        System.out.println(findRepeatedDnaSequences(s));
        return;
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10)
            return new ArrayList<String>();
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (!seen.add(sub))
                repeated.add(sub);
        }
        return new ArrayList<>(repeated);
    }

    // public static List<String> findRepeatedDnaSequences(String s) {
    //     int sLength = s.length();
    //     if (sLength <= 10)
    //         return new ArrayList<>();

    //     boolean[] uniqueDNAs = new boolean[1048576];
    //     boolean[] uniqueDNAsAdded = new boolean[1048576];
    //     List<String> results = new ArrayList<>();

    //     int dnaBitRepresentation = 0;

    //     for (int i = 0; i < sLength; i++) {
    //         dnaBitRepresentation = dnaBitRepresentation << 2;

    //         switch (s.charAt(i)) {
    //             case 'A':
    //                 break;
    //             case 'C':
    //                 dnaBitRepresentation += 1;
    //                 break;
    //             case 'G':
    //                 dnaBitRepresentation += 2;
    //                 break;
    //             case 'T':
    //                 dnaBitRepresentation += 3;
    //                 break;
    //         }

    //         if (i >= 9) {
    //             dnaBitRepresentation = dnaBitRepresentation & 0xFFFFF;
    //             if (uniqueDNAs[dnaBitRepresentation]) {
    //                 if (!uniqueDNAsAdded[dnaBitRepresentation]) {
    //                     uniqueDNAsAdded[dnaBitRepresentation] = true;
    //                     results.add(s.substring(i - 9, i + 1));
    //                 }
    //             } else {
    //                 uniqueDNAs[dnaBitRepresentation] = true;
    //             }
    //         }
    //     }
    //     return results;
    // }
}
