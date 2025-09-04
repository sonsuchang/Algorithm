import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int to;
        double cost;
        int state;

        Node(int to, double cost) {
            this.to = to;
            this.cost = cost;
        }

        Node(int to, double cost, int state) {
            this.to = to;
            this.cost = cost;
            this.state = state;
        }

        @Override
        public int compareTo(Node o) {
            return Double.compare(this.cost, o.cost);
        }
    }

    static final double INF = Double.MAX_VALUE;
    static int N, M;
    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) * 2;

            graph[u].add(new Node(v, d));
            graph[v].add(new Node(u, d));
        }

        double[] foxDist = dijkstraFox();
        double[][] wolfDist = dijkstraWolf();

        int result = 0;
        for (int i = 2; i <= N; i++) {
            double fox = foxDist[i];
            double wolf = Math.min(wolfDist[i][0], wolfDist[i][1]);
            if (fox < wolf) result++;
        }

        System.out.println(result);
    }

    static double[] dijkstraFox() {
        double[] dist = new double[N + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[1] = 0;
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > dist[cur.to]) continue;

            for (Node next : graph[cur.to]) {
                double newCost = dist[cur.to] + next.cost;
                if (newCost < dist[next.to]) {
                    dist[next.to] = newCost;
                    pq.offer(new Node(next.to, newCost));
                }
            }
        }
        return dist;
    }

    static double[][] dijkstraWolf() {
        double[][] dist = new double[N + 1][2];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dist[i], INF);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[1][0] = 0;
        pq.offer(new Node(1, 0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > dist[cur.to][cur.state]) continue;

            for (Node next : graph[cur.to]) {
                int nextState = 1 - cur.state;
                double speed = (cur.state == 0) ? next.cost / 2 : next.cost * 2;
                double newCost = dist[cur.to][cur.state] + speed;

                if (newCost < dist[next.to][nextState]) {
                    dist[next.to][nextState] = newCost;
                    pq.offer(new Node(next.to, newCost, nextState));
                }
            }
        }
        return dist;
    }
}
