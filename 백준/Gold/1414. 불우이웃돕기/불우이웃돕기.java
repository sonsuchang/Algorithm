import java.io.*;
import java.util.*;

public class Main {
	
    static int N;
    static int[] parent;

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

    public static void main(String[] args) throws Exception {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
    	N = Integer.parseInt(br.readLine());
        parent = new int[N];
        for (int i = 0; i < N; i++) parent[i] = i;

        List<Edge> list = new ArrayList<>();
        int total = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = s.charAt(j);
                int cost = 0;
                if (c >= 'a' && c <= 'z') cost = c - 'a' + 1;
                else if (c >= 'A' && c <= 'Z') cost = c - 'A' + 27;
                else continue;

                total += cost;
                if (i != j) list.add(new Edge(i, j, cost));
            }
        }

        Collections.sort(list);

        int mst = 0;
        int used = 0;

        for (Edge e : list) {
            if (union(e.u, e.v)) {
                mst += e.w;
                used++;
            }
        }

        if (used != N - 1) System.out.println(-1);
        else System.out.println(total - mst);
    }
}
