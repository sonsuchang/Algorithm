import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, X, answer;
    static int[][] dist;
    static ArrayList<ArrayList<Node>> graph;

    static class Node {
        int idx;
        int cost;
        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(node1).add(new Node(node2, w));
        }
        
        dist = new int[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i < N + 1; i++) {

            PriorityQueue<Node> pq = new PriorityQueue<Node>(((o1, o2) -> Integer.compare(o1.cost, o2.cost)));

            pq.offer(new Node(i, 0));

            dist[i][i] = 0;

            while (!pq.isEmpty()) {

                Node curNode = pq.poll();

                if (dist[i][curNode.idx] < curNode.cost) continue;

                for (int j = 0; j < graph.get(curNode.idx).size(); j++) {
                    Node nextNode = graph.get(curNode.idx).get(j);

                    if (dist[i][nextNode.idx] > curNode.cost + nextNode.cost) {
                        dist[i][nextNode.idx] = curNode.cost + nextNode.cost;
                        pq.offer(new Node(nextNode.idx, dist[i][nextNode.idx]));
                    }
                }
            }
        }

        answer = 0;

        for (int i = 1; i < N + 1; i++) {
            answer = Math.max(answer, dist[i][X] + dist[X][i]);
        }

        System.out.println(answer);
    }

}
