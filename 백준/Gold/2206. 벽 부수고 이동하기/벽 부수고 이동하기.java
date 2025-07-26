import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int cnt = Integer.MAX_VALUE;
    static int[][] map;
    static int[][][] visited;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {0, 0, 0});
        visited[0][0][0] = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            int r = now[0];
            int c = now[1];
            int w = now[2];

            if (r == N - 1 && c == M - 1) {
                if (visited[r][c][w] < cnt)
                    cnt = visited[r][c][w];
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (check(nr, nc)) {
                    if (map[nr][nc] == 0 && visited[nr][nc][w] == 0) {
                        visited[nr][nc][w] = visited[r][c][w] + 1;
                        queue.add(new int[] {nr, nc, w});
                    } else if (map[nr][nc] == 1 && w == 0) {
                        visited[nr][nc][w + 1] = visited[r][c][w] + 1;
                        queue.add(new int[] {nr, nc, w + 1});
                    }
                }
            }
        }

        if (cnt == Integer.MAX_VALUE) {
            sb.append(-1);
        } else {
            sb.append(cnt);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static boolean check(int nr, int nc) {
        return nr >= 0 && nr < N && nc < M && nc >= 0;
    }

}
