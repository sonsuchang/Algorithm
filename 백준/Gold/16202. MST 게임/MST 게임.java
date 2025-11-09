import java.io.*;
import java.util.*;

public class Main {

    static class Edge {
        int from;
        int to;
        int dist;

        Edge(int from, int to, int dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }
    }

    static int N, M, K;
    static boolean flag = false;
    static int[] parent;
    static ArrayList<Edge> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.add(new Edge(start, end, i));
        }

        for (int i = 0; i < K; i++) {
            if (flag) sb.append("0 ");
            else sb.append(kruskal(i)).append(" ");
        }

        System.out.println(sb);
    }

    public static void makeParent() {
        for (int i = 0; i <= N; i++) parent[i] = i;
    }

    public static boolean validation() {

        int num = parent[1];

        for (int i = 1; i <= N; i++) {
            if (num != parent[i]) return false;
        }

        return true;
    }

    public static int find(int num) {
        if (parent[num] == num) return num;
        return find(parent[num]);
    }

    public static void union(int x, int y) {

        x = find(x);
        y = find(y);

        if (x < y) {
            parent[y] = x;
            for (int i = 1; i <= N; i++) {
                if (i == x || i == y) continue;
                if (parent[i] == y) parent[i] = x;
            }
        }
        else {
            parent[x] = y;
            for (int i = 1; i <= N; i++) {
                if (i == x || i == y) continue;
                if (parent[i] == x) parent[i] = y;
            }
        }
    }

    public static int kruskal(int range) {
        makeParent();

        int cost = 0;

        for (int i = range; i < M; i++) {
            Edge now = graph.get(i);

            if (parent[now.from] != parent[now.to]) {
                union(now.from, now.to);
                cost += now.dist;
            }
        }

        if (validation()) return cost;

        flag = true;
        return 0;
    }
}
