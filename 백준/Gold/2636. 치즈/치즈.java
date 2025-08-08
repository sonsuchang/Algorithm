import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, cnt, time, now;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static boolean[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                if (Integer.parseInt(s[j]) == 1) {
                    map[i][j] = true;
                    cnt++;
                } else {
                    map[i][j] = false;
                }
            }
        }

        time = 0;
        while (cnt != 0) {
            time++;
            visited = new boolean[N][M];
            now = bfs();
            cnt -= now;
        }
        System.out.println(time);
        System.out.println(now);
    }

    public static int bfs() {

        int find = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0});

        visited[0][0] = true;

        while (!q.isEmpty()) {

            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (check(nr, nc)) {
                    visited[nr][nc] = true;
                    if (!map[nr][nc]) q.offer(new int[] {nr, nc});
                    else {
                        find++;
                        map[nr][nc] = false;
                    }
                }
            }
        }

        return find;
    }



    public static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M && !visited[r][c];
    }
}
