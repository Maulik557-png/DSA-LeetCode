import java.util.ArrayList;
import java.util.List;

public class Sep13P835 {
    public int largestOverlap(int[][] img1, int[][] img2) {
        List<int[]> ones1 = new ArrayList<>();
        List<int[]> ones2 = new ArrayList<>();
        for (int i = 0; i < img1.length; i++) {
            for (int j = 0; j < img1[i].length; j++) {
                if (img1[i][j] == 1)
                    ones1.add(new int[] { i, j });
                if (img2[i][j] == 1)
                    ones2.add(new int[] { i, j });
            }
        }

        int[][] count = new int[59][59];
        int maxOverlap = 0;
        for (int[] p1 : ones1) {
            for (int[] p2 : ones2) {
                int di = p1[0] - p2[0] + 29;
                int dj = p1[1] - p2[1] + 29;
                count[di][dj]++;
                maxOverlap = Math.max(maxOverlap, count[di][dj]);
            }
        }

        return maxOverlap;
    }
}
