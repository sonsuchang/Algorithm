import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] dist;
    static int[][] adj;
    static int[][] record;

    static int MAX_VALUE = 100_000_000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        dist = new int[N + 1][N + 1];
        adj = new int[N + 1][N + 1];
        record = new int[N + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            String[] s = br.readLine().split(" ");
            int A = Integer.parseInt(s[0]);
            int B = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);
            if (adj[A][B] != 0) adj[A][B] = Math.min(adj[A][B], cost);
            else adj[A][B] = cost;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) dist[i][j] = 0;
                else if (adj[i][j] != 0) dist[i][j] = adj[i][j];
                else dist[i][j] = MAX_VALUE;
                record[i][j] = j;
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        record[i][j] = record[i][k];
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (dist[i][j] == MAX_VALUE) System.out.print(0 + " ");
                else System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (dist[i][j] == 0 || dist[i][j] == MAX_VALUE) {
                    sb.append("0\n");
                    continue;
                }
                ArrayList<Integer> temp = new ArrayList<>();
                int st = i;
                while (st != j) {
                    temp.add(st);
                    st = record[st][j];
                }

                temp.add(j);
                sb.append(temp.size()).append(" ");
                for (Integer num : temp) sb.append(num).append(" ");
                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}