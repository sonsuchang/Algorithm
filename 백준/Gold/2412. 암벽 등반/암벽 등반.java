import java.io.*;
import java.util.*;

public class Main {

    static int N, T;
    static Set<String> pos = new HashSet<>();

    static class Node implements Comparable<Node> {

        int x, y, cnt;

        Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        public int compareTo(Node other) {
            if (this.cnt == other.cnt) return Math.abs(this.y - T) - Math.abs(other.y - T);
            return this.cnt - other.cnt;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = "x" + st.nextToken() + "y" + st.nextToken();
            pos.add(temp);
        }

        System.out.println(dij());
    }

    public static int dij() {

        Set<String> visit = new HashSet<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(0, 0, 0));

        while (!pq.isEmpty()) {

            Node now = pq.poll();

            if (now.y == T) return now.cnt;

            for (int i = -2; i < 3; i++) {
                for (int j = -2; j < 3; j++) {
                    int nx = now.x + i;
                    int ny = now.y + j;
                    String temp = "x" + nx + "y" + ny;
                    if (pos.contains(temp) && !visit.contains(temp)) {
                        visit.add(temp);
                        pq.offer(new Node(nx, ny, now.cnt + 1));
                    }
                }
            }
        }

        return -1;
    }
}