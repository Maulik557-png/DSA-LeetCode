public class Nov26P3360 {
    public boolean canAliceWin(int n) {
        int r = 10;
        boolean res = true;
        while (n >= r) {
            n -= r;
            r--;
            res = !res;
        }
        return !res;
    }
}
