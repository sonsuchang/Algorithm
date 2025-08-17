import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    static int N;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {1, 0, -1, 0};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt( o -> o[3]));
        pq.offer(new int[] {2, 0, 0, 0});
        visited[0][0] = true;
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int pos = now[0], r = now[1], c = now[2], cnt = now[3];

            if (r == N - 1 && c == N - 1) {
                System.out.println(cnt);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (check(nr, nc)) {
                    visited[nr][nc] = true;
                    if (map[nr][nc] == 0) pq.offer(new int[] {1, nr, nc, cnt + 1});
                    else pq.offer(new int[]{2, nr, nc, cnt});
                }
            }
        }
    }

    public static boolean check(int nr, int nc) {
        return 0 <= nr && nr < N && 0 <= nc && nc < N && !visited[nr][nc];
    }
}
