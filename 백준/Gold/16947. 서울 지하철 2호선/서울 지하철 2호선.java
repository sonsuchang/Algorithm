import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] degree;
    static boolean[] isCycle;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        degree = new int[N + 1];
        isCycle = new boolean[N + 1];
        dist = new int[N + 1];

        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);

            degree[a]++;
            degree[b]++;
        }

        findCycle();

        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) sb.append(dist[i]).append(" ");
        System.out.println(sb);
    }

    static void findCycle() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (degree[i] == 1) q.add(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            degree[cur]--;

            for (int next : graph.get(cur)) {
                if (degree[next] > 1) {
                    degree[next]--;
                    if (degree[next] == 1) q.add(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (degree[i] >= 2) isCycle[i] = true;
        }
    }

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (isCycle[i]) {
                dist[i] = 0;
                q.add(i);
            } else dist[i] = -1;
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph.get(cur)) {
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                }
            }
        }
    }
}
