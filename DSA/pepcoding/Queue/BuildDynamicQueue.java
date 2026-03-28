package DSA.pepcoding.Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BuildDynamicQueue {
    private int[] data;
    private int front;
    private int rear;
    private int size;

    BuildDynamicQueue(int n) {
        data = new int[n];
        front = 0;
        rear = 0;
        size = 0;
    }

    private int size() {
        return size;
    }

    private void display() {
        for (int i = 0; i < size; i++) {
            int idx = (front + i) % data.length;
            System.out.println(data[idx]);
        }
    }

    private void enque(int val) {
        if (size == data.length) {
            int[] arr = new int[data.length * 2];
            for (int i = 0; i < size; i++) {
                int idx = (front + i) % data.length;
                arr[i] = data[idx];
            }
            data = arr;
            front = 0;
            rear = size;
        }
        data[rear] = val;
        rear = (rear + 1) % data.length;
        size++;
    }

    private int deque() {
        if (size == 0) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int temp = data[front];
        front = (front + 1) % data.length;
        size--;
        return temp;
    }

    private int peek() {
        if (size == 0) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return data[front];
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BuildDynamicQueue st = new BuildDynamicQueue(n);

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("enque")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.enque(val);
            } else if (str.startsWith("deque")) {
                int val = st.deque();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = st.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(st.size());
            } else if (str.startsWith("display")) {
                st.display();
            }
            str = br.readLine();
        }
    }
}
