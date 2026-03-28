package DSA.pepcoding.Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueImplementation {
    public static void main(String[] args) {
        
        Queue<Integer> que = new ArrayDeque<>();

        que.add(10);
        System.out.println(que.peek());
        que.add(20);
        System.out.println(que.peek());
        que.remove();
        for (Integer integer : que) {
            System.out.println(integer);
        }
    }
}
