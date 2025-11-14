import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static int rr, rc, br, bc;
    static boolean[][][][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Node {
        int rr, rc, br, bc, cnt;
        Node(int rr, int rc, int br, int bc, int cnt) {
            this.rr = rr; this.rc = rc; this.br = br; this.bc = bc; this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader brd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(brd.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M][N][M];

        for (int i = 0; i < N; i++) {
            String line = brd.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'R') { rr = i; rc = j; }
                if (map[i][j] == 'B') { br = i; bc = j; }
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(rr, rc, br, bc, 0));
        visited[rr][rc][br][bc] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nrr = cur.rr, nrc = cur.rc, nbr = cur.br, nbc = cur.bc;
                boolean rIn = false, bIn = false;

                while (map[nrr + dr[d]][nrc + dc[d]] != '#') {
                    nrr += dr[d];
                    nrc += dc[d];
                    if (map[nrr][nrc] == 'O') { rIn = true; break; }
                }

                while (map[nbr + dr[d]][nbc + dc[d]] != '#') {
                    nbr += dr[d];
                    nbc += dc[d];
                    if (map[nbr][nbc] == 'O') { bIn = true; break; }
                }

                if (bIn) continue;
                if (rIn) return cur.cnt + 1;

                if (nrr == nbr && nrc == nbc) {
                    if (d == 0) {
                        if (cur.rr < cur.br) nbr++;
                        else nrr++;
                    } else if (d == 1) {
                        if (cur.rr < cur.br) nrr--;
                        else nbr--;
                    } else if (d == 2) {
                        if (cur.rc < cur.bc) nbc++;
                        else nrc++;
                    } else {
                        if (cur.rc < cur.bc) nrc--;
                        else nbc--;
                    }
                }

                if (!visited[nrr][nrc][nbr][nbc]) {
                    visited[nrr][nrc][nbr][nbc] = true;
                    q.add(new Node(nrr, nrc, nbr, nbc, cur.cnt + 1));
                }
            }
        }
        return -1;
    }
}
