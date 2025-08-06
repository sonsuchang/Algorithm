import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, game, value;

    static int[][] map;
    static boolean[][] visited;

    static int[] dr = {0, -1, 1, 0};
    static int[] dc = {-1, 0, 0, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        game = 1;
        value = 0;
        while (N != 0) {
            map = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }


            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
            pq.offer(new int[] {0, 0, map[0][0]});
            visited[0][0] = true;

            while (!pq.isEmpty()) {
                int[] cur = pq.poll();

                if (cur[0] == N - 1 && cur[1] == N - 1) {
                    value = cur[2];
                }

                for (int i = 0; i < 4; i++) {
                    int nr = cur[0] + dr[i];
                    int nc = cur[1] + dc[i];
                    if (check(nr, nc)) {
                        pq.offer(new int[]{nr, nc, cur[2] + map[nr][nc]});
                        visited[nr][nc] = true;
                    }
                }
            }

            sb.append(String.format("Problem %d: %d\n", game, value));
            N = Integer.parseInt(br.readLine());
            game++;
            value = 0;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static boolean check(int nr, int nc) {
        return nr < N && nc < N && nr >= 0 && nc >= 0 && !visited[nr][nc];
    }
}
