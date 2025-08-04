import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] damage = {9, 3, 1};
    static boolean[][][] visited = new boolean[61][61][61]; // 최대 3개의 최대 hp는 60이므로 61로 초기화

    static class State {
        int a, b, c, count;

        State(int a, int b, int c, int count) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.count = count;
        }
    }

    static int[][] perm = {
            {0, 1, 2}, {0, 2, 1},
            {1, 0, 2}, {1, 2, 0},
            {2, 0, 1}, {2, 1, 0}
    };

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] hp = new int[3]; // N값이 최대 3이므로 3 유지
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            hp[i] = Integer.parseInt(input[i]);
        }

        Queue<State> queue = new ArrayDeque<>();
        queue.offer(new State(hp[0], hp[1], hp[2], 0));
        visited[hp[0]][hp[1]][hp[2]] = true;

        while (!queue.isEmpty()) {
            State now = queue.poll();
            int a = now.a, b = now.b, c = now.c;

            if (a <= 0 && b <= 0 && c <= 0) {
                System.out.println(now.count);
                break;
            }

            for (int[] p : perm) {
                int na = Math.max(0, a - damage[p[0]]);
                int nb = Math.max(0, b - damage[p[1]]);
                int nc = Math.max(0, c - damage[p[2]]);
                if (!visited[na][nb][nc]) {
                    visited[na][nb][nc] = true;
                    queue.offer(new State(na, nb, nc, now.count + 1));
                }
            }
        }
    }
}
