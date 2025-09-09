import java.io.*;
import java.util.*;

public class Main {

    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        int vertex, dist;
        Node(int vertex, int dist) {
            this.vertex = vertex;
            this.dist = dist;
        }
        public int compareTo(Node other) {
            return Integer.compare(this.dist, other.dist);
        }
    }

    static int N, M, nodeCount;
    static final int INF = Integer.MAX_VALUE;
    static List<List<Edge>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        int rowCnt = N + 1;
        int colCnt = M + 1;
        nodeCount = rowCnt * colCnt;
        graph = new ArrayList<>();
        for (int i = 0; i <= nodeCount; i++) {
            graph.add(new ArrayList<>());
        }

        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            if (line.length() != M) {
                System.out.println("NO SOLUTION");
                return;
            }
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int tl = i * (M + 1) + j;
                int tr = i * (M + 1) + (j + 1);
                int bl = (i + 1) * (M + 1) + j;
                int br_ = (i + 1) * (M + 1) + (j + 1);

                if (board[i][j] == '/') {
                    // / 연결: bl <-> tr (0), tl <-> br (1)
                    addEdge(bl, tr, 0);
                    addEdge(tl, br_, 1);
                } else if (board[i][j] == '\\') {
                    // \ 연결: tl <-> br (0), bl <-> tr (1)
                    addEdge(tl, br_, 0);
                    addEdge(bl, tr, 1);
                }
            }
        }

        int result = dijkstra(0, N * (M + 1) + M);
        System.out.println(result == INF ? "NO SOLUTION" : result);
    }

    static void addEdge(int u, int v, int weight) {
        graph.get(u).add(new Edge(v, weight));
        graph.get(v).add(new Edge(u, weight));
    }

    static int dijkstra(int start, int end) {
        int[] dist = new int[nodeCount + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int u = cur.vertex;

            if (dist[u] < cur.dist) continue;

            for (Edge edge : graph.get(u)) {
                int v = edge.to;
                int w = edge.weight;

                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    pq.offer(new Node(v, dist[v]));
                }
            }
        }

        return dist[end];
    }
}
