import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int INF = Integer.MAX_VALUE;
	static List<List<Edge>> graph;
	
	static class Edge {
		int to, weight;
		
		Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	
	static class Node implements Comparable<Node> {
		int vertex, dist;
		
		public Node(int vertex, int dist) {
			this.vertex = vertex;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Node other) {
			return this.dist - other.dist;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		
		for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph.get(v1).add(new Edge(v2, cost));
			graph.get(v2).add(new Edge(v1, cost));
		}
		
		System.out.println(dij());
	}
	
	public static int dij() {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, INF);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(1, 0));
		dist[1] = 0;
		
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			int vertex = now.vertex;
			int cost = now.dist;
			
			if (dist[vertex] < cost) continue;
			
			for (Edge edge : graph.get(vertex)) {
				if (dist[edge.to] > cost + edge.weight) {
					dist[edge.to] = cost + edge.weight;
					pq.offer(new Node(edge.to, cost + edge.weight));
				}
			}
		}
		
		return dist[N];
	}
}
