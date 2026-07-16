import java.util.HashMap;
import java.util.Map;

class LeetCode146 {

    public class Node {
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    Node head;
    Node tail;
    Map<Integer, Node> map;

    public LeetCode146(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = null;
        this.tail = null;
    }

    public int get(int key) {

        if (map.isEmpty() || !map.containsKey(key)) {
            return -1;
        }

        Node curr = map.get(key);

        if (curr != head) {
            if (curr == tail) {
                tail = tail.prev;
                tail.next = null;
            } else {
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
            }

            curr.next = head;
            curr.prev = null;
            head.prev = curr;
            head = curr;
        }

        return curr.val;
    }

    public void put(int key, int value) {
        if (map.isEmpty()) {
            head = new Node(key, value);
            tail = head;
            map.put(key, head);
            return;
        }

        if (map.containsKey(key)) {
            Node curr = map.get(key);
            curr.val = value;

            if (curr != head) {
                if (curr == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                }
                curr.next = head;
                curr.prev = null;
                head.prev = curr;
                head = curr;
            }

            return;
        }

        if (map.size() == capacity) {
            map.remove(tail.key);

            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
        }

        Node newNode = new Node(key, value);
        map.put(key, newNode);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void display() {
        Node node = head;

        while (node.next != null) {
            System.out.println(node.val);
            node = node.next;
        }
        System.out.println(node.val);
    }

    public static void main(String[] args) {
        LeetCode146 lru = new LeetCode146(2);
        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru.get(1));
        lru.put(3, 3);
        System.out.println(lru.get(2));
        lru.put(4, 4);
        System.out.println(lru.get(1));
        System.out.println(lru.get(3));
        System.out.println(lru.get(4));
    }
}