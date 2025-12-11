import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        String num;
        int cnt;

        Node(String num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        public int compareTo(Node other) {
            return this.cnt - other.cnt;
        }
    }

    public static int T;
    public static boolean[] primeNumber = new boolean[10000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        setPrimeNumber();

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            String prev = st.nextToken();
            String next = st.nextToken();
            if (prev.equals(next)) sb.append(0).append("\n");
            else if (dij(prev, next) == 0) sb.append("Impossible").append("\n");
            else sb.append(dij(prev, next)).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void setPrimeNumber() {
        for (int i = 0; i < 10000; i++) primeNumber[i] = true;

        for (int i = 2; i < 10000; i++) {
            if (!primeNumber[i]) continue;
            int temp = 2;
            while ((i * temp) < 10000) {
                primeNumber[i * temp] = false;
                temp++;
            }
        }
    }

    public static int dij(String prev, String next) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        HashSet<String> visit = new HashSet<>();

        pq.offer(new Node(prev, 0));
        visit.add(prev);

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.num.equals(next)) return now.cnt;

            char[] c = now.num.toCharArray();

            for (int i = 0; i < 4; i++) {
                char prevNumber = c[i];
                for (int j = 57; j > 47; j--) {
                    c[i] = (char) j;
                    String check = String.valueOf(c);
                    if (isPossible(check) && !visit.contains(check)) {
                        pq.offer(new Node(check, now.cnt + 1));
                        visit.add(check);
                    }
                    c[i] = prevNumber;
                }
            }
        }
        return 0;
    }

    public static boolean isPossible(String check) {
        int temp = Integer.parseInt(check);
        return temp >= 1000 && primeNumber[temp];
    }
}
