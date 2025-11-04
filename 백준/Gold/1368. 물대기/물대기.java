import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] well;
    static int[] parent;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    
    static class Node implements Comparable<Node> {
        int from, to, cost;
        
        Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        well = new int[N + 1];
        parent = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            well[i] = Integer.parseInt(br.readLine());
            parent[i] = i;
        }
        
        for (int i = 1; i <= N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                if (i != j) pq.offer(new Node(i, j, Integer.parseInt(s[j - 1])));
            }
        }
        
        for (int i = 1; i <= N; i++) pq.offer(new Node(0, i, well[i]));
        
        int cost = 0;
        
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int from = now.from;
            int to = now.to;
            
            if (find(from) != find(to)) {
                parent[find(from)] = find(to);
                cost += now.cost;
            }
        }
        
        System.out.println(cost);
    }
    
    public static int find(int num) {
        if (parent[num] == num) return num;
        return parent[num] = find(parent[num]);
    }
}
