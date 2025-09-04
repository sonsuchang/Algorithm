import java.io.*;
import java.util.*;

public class Main {

	static int T, N, M, C;
	static int INF = 2_000_000_000;
	static List<List<Edge>> graph;
	
	static class Edge {
		int to, weight;
		Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	
	static class Node implements Comparable<Node> {
		int vertex, cost;
		Node(int vertex, int cost) {
			this.vertex = vertex;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node other) {
			return this.cost - other.cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList<>();
			for (int j = 0; j <= N; j++) graph.add(new ArrayList<>());
			
			for (int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				if (v1 == C) continue;
				graph.get(v2).add(new Edge(v1, cost));
			}
			dij();
		}
	}
	
	public static void dij() {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, INF);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(C, 0));
		dist[C] = 0;
		
		while (!pq.isEmpty()) {
			
			Node now = pq.poll();
			int vertex = now.vertex;
			int cost = now.cost;
			
			if (dist[vertex] < cost) continue;
			for (Edge edge : graph.get(vertex)) {
				int next = edge.to;
				int weight = cost + edge.weight;
				if (dist[next] > weight) {
					dist[next] = weight;
					pq.offer(new Node(next, weight));
				}
			}
		}
		
		int time = 0;
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (dist[i] != INF) {
				time = Math.max(time, dist[i]);
				cnt++;
			}
		}
		
		System.out.printf("%d %d\n", cnt, time);
	}
}
