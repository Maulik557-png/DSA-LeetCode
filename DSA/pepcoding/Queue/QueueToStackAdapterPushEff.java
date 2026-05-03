package DSA.pepcoding.Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueToStackAdapterPushEff {
    private Queue<Integer> mainQ;

    QueueToStackAdapterPushEff() {
        mainQ = new ArrayDeque<>();
    }

    private int size() {
        return mainQ.size();
    }

    private void push(int val) {
        mainQ.add(val);
    }

    private int pop() {
        if (size() == 0) {
            System.out.println("Stack is underflow");
            return -1;
        } else {
            int size = size() - 1;

            for (int i = 0; i < size; i++) {
                mainQ.add(mainQ.poll());
            }
            return mainQ.poll();
        }
    }

    private int top() {
        if (size() == 0) {
            System.out.println("Stack is underflow");
            return -1;
        } else {
            int size = size() - 1;

            for (int i = 0; i < size; i++) {
                mainQ.add(mainQ.poll());
            }
            mainQ.add(mainQ.poll());
            return mainQ.peek();
        }
    }

    private void display() {
        Queue<Integer> tempQ = new ArrayDeque<>(mainQ);
        int size = size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                tempQ.add(tempQ.poll());
            }
            System.out.println(tempQ.poll());
        }
    }

    public static void main(String[] args) {
        QueueToStackAdapterPushEff stackAdapter = new QueueToStackAdapterPushEff();
        stackAdapter.push(10);
        stackAdapter.push(20);
        stackAdapter.push(30);
        stackAdapter.push(40);
        stackAdapter.push(50);
        stackAdapter.display();
        System.out.println("===");
        System.out.println("popped:" + stackAdapter.pop());
        System.out.println("===");
        stackAdapter.display();
        System.out.println("===");
        System.out.println("top: " + stackAdapter.top());
        System.out.println("===");
    }
}
