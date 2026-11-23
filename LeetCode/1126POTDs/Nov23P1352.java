public class Nov23P1352 {
    class ProductOfNumbers {
        private final List<Integer> list = new ArrayList<>(List.of(1));

        public void add(int num) {
            if (num == 0) {
                list.clear();
                list.add(1);
            } else {
                list.add(list.get(list.size() - 1) * num);
            }
        }

        public int getProduct(int k) {
            int n = list.size();
            if (k >= n)
                return 0;
            return list.get(n - 1) / list.get(n - 1 - k);
        }
    }
}
