import java.io.*;
import java.util.*;

public class Main {
	
    static class Edge implements Comparable<Edge> {
        int u, v, w;
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }

    static int[] parent;
    static String[] gender;
    static int N, M;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return false;
        parent[b] = a;
        return true;
    }

    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        gender = new String[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) gender[i] = st.nextToken();

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            if (!gender[u].equals(gender[v])) {
                edges.add(new Edge(u, v, w));
            }
        }

        Collections.sort(edges);
        parent = new int[N];
        for (int i = 0; i < N; i++) parent[i] = i;

        int sum = 0, cnt = 0;

        for (Edge e : edges) {
            if (union(e.u, e.v)) {
                sum += e.w;
                cnt++;
                if (cnt == N - 1) break;
            }
        }

        int root = find(0);
        for (int i = 1; i < N; i++) {
            if (find(i) != root) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(sum);
    }
}
