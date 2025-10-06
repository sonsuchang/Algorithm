import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int[] arr;
        int cost;

        Node(int[] arr, int cost) {
            this.arr = arr;
            this.cost = cost;
        }

        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    static int N, M;
    static int[] map;
    static ArrayList<int[]> cmd = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) map[i] = Integer.parseInt(s[i]);

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            cmd.add(new int[] {Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2])});
        }

        System.out.println(dij());

    }

    public static int dij() {

        int[] t;
        t = Arrays.copyOf(map, N);
        Arrays.sort(t);
        String target = Arrays.toString(t);

        HashMap<String, Integer> dist = new HashMap<>();
        dist.put(Arrays.toString(map), 0);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(map, 0));

        while (!pq.isEmpty()) {

            Node now = pq.poll();
            String nowKey = Arrays.toString(now.arr);

            if (nowKey.equals(target)) return now.cost;

            if (now.cost > dist.get(nowKey)) continue;

            for (int[] info : cmd) {
                int[] next = swap(now.arr, info[0], info[1]);
                String nextKey = Arrays.toString(next);
                int newCost = now.cost + info[2];

                if (!dist.containsKey(nextKey) || dist.get(nextKey) > newCost) {
                    dist.put(nextKey, newCost);
                    pq.offer(new Node(next, newCost));
                }
            }
        }

        if (dist.containsKey(target)) return dist.get(target);
        return -1;
    }

    public static int[] swap(int[] arr, int l, int r) {
        int[] next = arr.clone();
        int temp = next[l - 1];
        next[l - 1] = next[r - 1];
        next[r - 1] = temp;
        return next;
    }
}
