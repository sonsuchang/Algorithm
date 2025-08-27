import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class State {
        int x, y, steps, keys;

        public State(int x, int y, int steps, int keys) {
            this.x = x;
            this.y = y;
            this.steps = steps;
            this.keys = keys;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        map = new char[N][M];

        int startX = 0, startY = 0;

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j);
                if (map[i][j] == '0') {
                    startX = i;
                    startY = j;
                }
            }
        }

        System.out.println(bfs(startX, startY));
    }

    static int bfs(int startX, int startY) {
        Queue<State> queue = new ArrayDeque<>();
        Map<String, Set<Integer>> visited = new HashMap<>();

        State start = new State(startX, startY, 0, 0);
        queue.offer(start);
        markVisited(visited, startX, startY, 0);

        while (!queue.isEmpty()) {
            State now = queue.poll();

            if (map[now.x][now.y] == '1') return now.steps;

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                int key = now.keys;

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                char c = map[nx][ny];
                if (c == '#') continue;

                if (c >= 'A' && c <= 'F') {
                    if ((key & (1 << (c - 'A'))) == 0) continue;
                }

                if (c >= 'a' && c <= 'f') key = key | (1 << (c - 'a'));

                if (!hasVisited(visited, nx, ny, key)) {
                    markVisited(visited, nx, ny, key);
                    queue.offer(new State(nx, ny, now.steps + 1, key));
                }
            }
        }

        return -1;
    }

    static boolean hasVisited(Map<String, Set<Integer>> visited, int x, int y, int keyMask) {
        String pos = x + "," + y;
        return visited.containsKey(pos) && visited.get(pos).contains(keyMask);
    }

    static void markVisited(Map<String, Set<Integer>> visited, int x, int y, int keyMask) {
        String pos = x + "," + y;
        visited.computeIfAbsent(pos, k -> new HashSet<>()).add(keyMask);
    }
}
