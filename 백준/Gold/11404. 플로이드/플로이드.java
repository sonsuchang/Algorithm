import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, M;
    static int[][] dist;
    static int[][] adj;
    static int MAX_VALUE = 100_000_000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adj = new int[N + 1][N + 1];
        dist = new int[N + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            String[] s = br.readLine().split(" ");
            int A = Integer.parseInt(s[0]);
            int B = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);
            if (adj[A][B] != 0) {
                adj[A][B] = Math.min(cost, adj[A][B]);
            } else {
                adj[A][B] = cost;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) dist[i][j] = 0;
                else if (adj[i][j] != 0) dist[i][j] = adj[i][j];
                else dist[i][j] = MAX_VALUE;
            }
        }


        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
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
    }
}
