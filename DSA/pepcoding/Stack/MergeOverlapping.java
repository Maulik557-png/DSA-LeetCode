import java.util.Arrays;
import java.util.Stack;

public class MergeOverlapping {
    public static void main(String[] args) {
        int[][] arr = new int[6][2];
        arr[0][0] = 22;
        arr[1][0] = 1;
        arr[2][0] = 25;
        arr[3][0] = 14;
        arr[4][0] = 27;
        arr[5][0] = 5;
        arr[0][1] = 28;
        arr[1][1] = 8;
        arr[4][1] = 27;
        arr[2][1] = 19;
        arr[3][1] = 30;
        arr[5][1] = 12;
        mergeOverlappingInterval(arr);
    }

    public static void mergeOverlappingInterval(int[][] arr)   {

        Pair[] pairs = new Pair[arr.length];
        for (int i = 0; i < pairs.length; i++) {
            pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }
        Arrays.sort(pairs);

        Stack<Pair> st = new Stack<>();
        for (int i = 0; i < pairs.length; i++) {
            if(i == 0)  st.push(pairs[i]);
            else  {
                Pair top = st.peek();
                if (pairs[i].st > top.et) {
                    st.push(pairs[i]);
                } else  {
                    top.et = Math.max(pairs[i].et, top.et);
                }
            }
        }

        Stack<Pair> res = new Stack<>();
        while(st.size() > 0)  {
            res.push(st.pop());
        }
        while (res.size() > 0) {
            Pair p = res.pop();
            System.out.println(p.st + "-" + p.et);
        }
    }

    public static class Pair implements Comparable<Pair> {
        int st;
        int et;

        Pair(int st, int et)    {
            this.st = st;
            this.et = et;
        }

        @Override
        public int compareTo(Pair other) {
            if(this.st == other.st)  return this.st - other.st;
            else  return this.et - other.et;
        }
    }
}
