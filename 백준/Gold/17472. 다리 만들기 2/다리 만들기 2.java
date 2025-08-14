import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int islandCount = 0;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int[][] map;
    static int[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    islandCount++;
                    numberingIsland(i, j, islandCount);
                }
            }
        }

        graph = new int[islandCount + 1][islandCount + 1];
        for (int i = 1; i <= islandCount; i++) {
            for (int j = 1; j <= islandCount; j++) {
                if (i != j) {
                    graph[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    findBridge(i, j);
                }
            }
        }

        int result = findMinSpanningTree();
        System.out.println(result);
    }

    public static void numberingIsland(int r, int c, int num) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r, c});
        visited[r][c] = true;
        map[r][c] = num;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nr = now[0];
            int nc = now[1];

            for (int i = 0; i < 4; i++) {
                int nextR = nr + dr[i];
                int nextC = nc + dc[i];

                if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M
                        && !visited[nextR][nextC] && map[nextR][nextC] == 1) {
                    visited[nextR][nextC] = true;
                    map[nextR][nextC] = num;
                    queue.offer(new int[]{nextR, nextC});
                }
            }
        }
    }

    public static void findBridge(int r, int c) {
        int currentIsland = map[r][c];

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            int bridgeLength = 0;

            while (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
                bridgeLength++;
                nr += dr[i];
                nc += dc[i];
            }

            if (nr >= 0 && nr < N && nc >= 0 && nc < M
                    && map[nr][nc] > 0 && map[nr][nc] != currentIsland && bridgeLength >= 2) {
                int targetIsland = map[nr][nc];
                graph[currentIsland][targetIsland] = Math.min(graph[currentIsland][targetIsland], bridgeLength);
            }
        }
    }

    public static int findMinSpanningTree() {
        boolean[] inMST = new boolean[islandCount + 1];
        int[] minCost = new int[islandCount + 1];
        Arrays.fill(minCost, Integer.MAX_VALUE);

        minCost[1] = 0;
        int totalCost = 0;

        for (int count = 0; count < islandCount; count++) {
            int u = -1;

            for (int v = 1; v <= islandCount; v++) {
                if (!inMST[v] && (u == -1 || minCost[v] < minCost[u])) {
                    u = v;
                }
            }

            if (minCost[u] == Integer.MAX_VALUE) {
                return -1;
            }

            inMST[u] = true;
            totalCost += minCost[u];

            for (int v = 1; v <= islandCount; v++) {
                if (!inMST[v] && graph[u][v] < minCost[v]) {
                    minCost[v] = graph[u][v];
                }
            }
        }

        return totalCost;
    }
}