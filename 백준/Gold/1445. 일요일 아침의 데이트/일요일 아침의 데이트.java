import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static int[][][] dist;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    static class Node implements Comparable<Node> {
        int r, c;
        int trash, nearTrash;
        Node(int r, int c, int trash, int nearTrash) {
            this.r = r;
            this.c = c;
            this.trash = trash;
            this.nearTrash = nearTrash;
        }
        public int compareTo(Node o) {
            if (this.trash != o.trash) return this.trash - o.trash;
            return this.nearTrash - o.nearTrash;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        int sr = 0, sc = 0, fr = 0, fc = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'S') { sr = i; sc = j; }
                if (map[i][j] == 'F') { fr = i; fc = j; }
            }
        }

        boolean[][] near = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'g') {
                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        if (inRange(nr, nc) && map[nr][nc] == '.') {
                            near[nr][nc] = true;
                        }
                    }
                }
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[N][M];
        pq.offer(new Node(sr, sc, 0, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (visited[now.r][now.c]) continue;
            visited[now.r][now.c] = true;

            if (map[now.r][now.c] == 'F') {
                System.out.println(now.trash + " " + now.nearTrash);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];
                if (!inRange(nr, nc)) continue;
                if (visited[nr][nc]) continue;

                int t = now.trash;
                int nt = now.nearTrash;

                if (map[nr][nc] == 'g') t++;
                else if (near[nr][nc]) nt++;

                pq.offer(new Node(nr, nc, t, nt));
            }
        }
    }

    static boolean inRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
