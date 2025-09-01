import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static int sr, sc, er, ec;
    static char[][] map;
    static int[][] dist;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        st = new StringTokenizer(br.readLine());
        sr = Integer.parseInt(st.nextToken()) - 1;
        sc = Integer.parseInt(st.nextToken()) - 1;
        er = Integer.parseInt(st.nextToken()) - 1;
        ec = Integer.parseInt(st.nextToken()) - 1;

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sr, sc});
        dist[sr][sc] = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];

            if (row == er && col == ec) {
                return dist[row][col];
            }

            for (int dir = 0; dir < 4; dir++) {
                int nr = row;
                int nc = col;
                for (int step = 1; step <= K; step++) {
                    nr += dr[dir];
                    nc += dc[dir];
                    if (!inBounds(nr, nc) || map[nr][nc] == '#') break;
                    if (dist[nr][nc] < dist[row][col] + 1) break;
                    if (dist[nr][nc] == dist[row][col] + 1) continue;
                    dist[nr][nc] = dist[row][col] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        return -1;
    }

    public static boolean inBounds(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
