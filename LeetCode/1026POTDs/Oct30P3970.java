public class Oct30P3970 {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        if (n == 1) {
            return (k >= 1) ? 0 : -1;
        }

        if (k < 1) {
            return -1;
        }

        List<int[]>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            adj[e[0]].add(new int[] { e[1], e[2] });
        }

        long[][] dist = new long[n][k + 1];
        for (long[] row : dist) {
            Arrays.fill(row, Long.MAX_VALUE);
        }

        dist[0][1] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>(
                (a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[] { 0L, 0L, 1L });

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long d = curr[0];
            int node = (int) curr[1];
            int r = (int) curr[2];

            if (d > dist[node][r]) {
                continue;
            }

            if (node == n - 1) {
                return (int) d;
            }

            for (int[] edge : adj[node]) {
                int v = edge[0];
                int w = edge[1];
                int nr = (labels.charAt(v) == labels.charAt(node)) ? r + 1 : 1;

                if (nr > k) {
                    continue;
                }

                long newDist = d + w;
                if (newDist < dist[v][nr]) {
                    dist[v][nr] = newDist;
                    pq.offer(new long[] { newDist, v, nr });
                }
            }
        }

        return -1;
    }
}
