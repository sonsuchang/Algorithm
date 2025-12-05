import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 100000;

    static class Node implements Comparable<Node> {
        int pos, time;

        Node(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }

        @Override
        public int compareTo(Node other) {
            return this.time - other.time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dist = new int[MAX + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(N, 0));
        dist[N] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            int pos = cur.pos;
            int time = cur.time;

            if (time > dist[pos]) continue;

            if (pos == K) {
                System.out.println(time);
                return;
            }

            int next = pos * 2;
            if (next <= MAX && dist[next] > time) {
                dist[next] = time;
                pq.offer(new Node(next, time));
            }

            next = pos + 1;
            if (next <= MAX && dist[next] > time + 1) {
                dist[next] = time + 1;
                pq.offer(new Node(next, time + 1));
            }

            next = pos - 1;
            if (next >= 0 && dist[next] > time + 1) {
                dist[next] = time + 1;
                pq.offer(new Node(next, time + 1));
            }
        }
    }
}
