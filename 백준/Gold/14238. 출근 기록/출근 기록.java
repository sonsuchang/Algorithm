import java.io.*;
import java.util.*;

public class Main {

    static int length;
    static String s;
    static HashSet<String> visit = new HashSet<>();
    static HashMap<Character, Integer> count = new HashMap<>();

    static class Node {
        int A, B, C, len;
        char[] pos;

        Node(int A, int B, int C, int len, char[] pos) {
            this.A = A;
            this.B = B;
            this.C = C;
            this.len = len;
            this.pos = pos;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        length = s.length();

        if (length == 1) {
            System.out.println(s);
            return;
        }

        count.put('A', 0);
        count.put('B', 0);
        count.put('C', 0);

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            count.put(c, count.get(c) + 1);
        }

        char[] answer = bfs();

        if (answer[0] == 'Z') System.out.println(-1);
        else for (char c : answer) System.out.print(c);
    }

    public static char[] bfs() {

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(count.get('A'), count.get('B'), count.get('C'), 0, new char[length]));

        while (!queue.isEmpty()) {

            Node now = queue.poll();

            if (now.len == length) return now.pos;

            char last1 = (now.len == 0 ? '0' : now.pos[now.len - 1]);
            char last2 = (now.len <= 1 ? '0' : now.pos[now.len - 2]);

            String key = now.A + "," + now.B + "," + now.C + "," + last1 + "," + last2;
            if (visit.contains(key)) continue;
            visit.add(key);

            if (now.A != 0) {
                char[] temp = Arrays.copyOf(now.pos, length);
                temp[now.len] = 'A';
                queue.offer(new Node(now.A - 1, now.B, now.C, now.len + 1, temp));
            }

            if (now.B != 0) {
                if (now.len == 0 || now.pos[now.len - 1] != 'B') {
                    char[] temp = Arrays.copyOf(now.pos, length);
                    temp[now.len] = 'B';
                    queue.offer(new Node(now.A, now.B - 1, now.C, now.len + 1, temp));
                }
            }

            if (now.C != 0) {
                if (now.len == 0 || (now.len == 1 && now.pos[now.len - 1] != 'C')
                        || (now.len >= 2 && now.pos[now.len - 2] != 'C' && now.pos[now.len - 1] != 'C')) {
                    char[] temp = Arrays.copyOf(now.pos, length);
                    temp[now.len] = 'C';
                    queue.offer(new Node(now.A, now.B, now.C - 1, now.len + 1, temp));
                }
            }
        }

        return new char[]{'Z'};
    }
}
