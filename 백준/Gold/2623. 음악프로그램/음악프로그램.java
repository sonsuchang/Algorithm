import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        int[] indegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());

            if (cnt == 0) continue;

            int prev = Integer.parseInt(st.nextToken());
            for (int j = 1; j < cnt; j++) {
                int curr = Integer.parseInt(st.nextToken());

                graph.get(prev).add(curr);
                indegree[curr]++;

                prev = curr;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        ArrayList<Integer> answer = new ArrayList<>();

        while (!q.isEmpty()) {
            int now = q.poll();
            answer.add(now);

            for (int next : graph.get(now)) {
                indegree[next]--;
                if (indegree[next] == 0) q.add(next);
            }
        }

        if (answer.size() != N) {
            System.out.println(0);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int x : answer) sb.append(x).append("\n");
            System.out.print(sb);
        }
    }
}
