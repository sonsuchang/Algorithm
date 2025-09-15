import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int INF = Integer.MAX_VALUE;
	static ArrayList<ArrayList<Edge>> graph;
	
	static class Edge {
		int to;
		int cost;
		Edge (int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
	
	static class Node implements Comparable<Node> {
		int vertex, dist;
		Node (int vertex, int dist) {
			this.vertex = vertex;
			this.dist = dist;
		}
		
		public int compareTo(Node other) {
			return this.dist - other.dist;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		
		for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph.get(start).add(new Edge(end, cost));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		System.out.println(dij(start, end));
	}
	
	public static int dij(int start, int end) {
		
		int[] dist = new int[N + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			int v = now.vertex;
			int d = now.dist;
			
			if (dist[v] < d) continue;
			
			for (Edge edge : graph.get(v)) {
				int next = edge.to;
				int weight = edge.cost;
				if (dist[next] > weight + d) {
					dist[next] = weight + d;
					pq.offer(new Node(next, weight + d));
				}
			}
		}
		return dist[end];
	}

}
