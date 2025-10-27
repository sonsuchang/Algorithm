import java.io.*;
import java.util.*;

public class Main {
	
    static int N, M, K;
    static int[] parent;
    static boolean[] isPowerPlant;

    static class Edge implements Comparable<Edge> {
        int u, v, w;
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
        public int compareTo(Edge other) {
            return this.w - other.w;
        }
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (isPowerPlant[a]) parent[b] = a;
        else if (isPowerPlant[b]) parent[a] = b;
        else parent[b] = a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        isPowerPlant = new boolean[N + 1];
        
        for (int i = 1; i <= N; i++) parent[i] = i;

        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < K; i++) {
            int p = Integer.parseInt(st.nextToken());
            isPowerPlant[p] = true;
        }

        ArrayList<Edge> edges = new ArrayList<>();
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u, v, w));
        }

        Collections.sort(edges);

        int totalCost = 0;

        for (Edge e : edges) {
            int pu = find(e.u);
            int pv = find(e.v);

            if (pu == pv) continue;

            if (isPowerPlant[pu] && isPowerPlant[pv]) continue;

            union(pu, pv);
            totalCost += e.w;
        }

        System.out.println(totalCost);
    }
}
