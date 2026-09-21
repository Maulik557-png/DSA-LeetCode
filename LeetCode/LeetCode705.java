public class LeetCode705 {
    private final boolean[] storage;

    public LeetCode705() {
        storage = new boolean[1_000_001];
    }

    public void add(int key) {
        storage[key] = true;
    }

    public void remove(int key) {
        storage[key] = false;
    }

    public boolean contains(int key) {
        return storage[key];
    }
}
