public class Sep14P836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int[] x1 = { rec1[0], rec1[2] };
        int[] y1 = { rec1[1], rec1[3] };
        int[] x2 = { rec2[0], rec2[2] };
        int[] y2 = { rec2[1], rec2[3] };

        boolean x = x2[0] < x1[1] && x1[0] < x2[1];
        boolean y = y2[0] < y1[1] && y1[0] < y2[1];

        return x && y;
    }
}
