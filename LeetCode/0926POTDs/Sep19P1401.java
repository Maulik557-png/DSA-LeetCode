public class Sep19P1401 {
    public boolean checkOverlap(int r, int xc, int yc, int x1, int y1, int x2, int y2) {
        int px = xc;
        int py = yc;

        if (xc < x1) {
            px = x1;
        } else if (xc > x2) {
            px = x2;
        }

        if (yc < y1) {
            py = y1;
        } else if (yc > y2) {
            py = y2;
        }

        int dx = xc - px;
        int dy = yc - py;

        return dx * dx + dy * dy <= r * r;
    }
}
