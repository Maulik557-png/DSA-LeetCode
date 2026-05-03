package DSA.pepcoding.Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueToStackAdapterPopEff {
    private Queue<Integer> mainQ;

    QueueToStackAdapterPopEff() {
        mainQ = new ArrayDeque<>();
    }

    private int size() {
        return mainQ.size();
    }

    private void push(int val) {
        int size = size();
        mainQ.add(val);
        for (int i = 0; i < size; i++) {
            mainQ.add(mainQ.poll());
        }
    }

    private int pop() {
        if(size() == 0) {
            System.out.println("Stack is underflow");
            return -1;
        } else{
            return mainQ.poll();
        }
    }

    private int top() {
        if(size() == 0) {
            System.out.println("Stack is underflow");
            return -1;
        } else{
            return mainQ.peek();
        }   
    }

    private void display() {
        int size = size();
        for (int i = 0; i < size; i++) {
            int val = mainQ.poll();
            mainQ.add(val);
            System.out.println(val);
        }
    }

    public static void main(String[] args) {
        QueueToStackAdapterPopEff stackAdapter = new QueueToStackAdapterPopEff();
        stackAdapter.push(2);
        stackAdapter.push(5);
        stackAdapter.push(1);
        stackAdapter.push(9);
        stackAdapter.push(6);
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
