import java.io.*;
import java.util.*;

public class Main {
    static class Ball {
        int idx, color, size;
        Ball(int idx, int color, int size) {
            this.idx = idx;
            this.color = color;
            this.size = size;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Ball[] balls = new Ball[N];
        int[] result = new int[N];
        int[] colorSum = new int[N + 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            balls[i] = new Ball(i, c, s);
        }

        Arrays.sort(balls, (a, b) -> a.size - b.size);

        int totalSum = 0;
        int idx = 0;

        while (idx < N) {
            int sameSize = balls[idx].size;
            int start = idx;

            while (idx < N && balls[idx].size == sameSize) idx++;

            for (int i = start; i < idx; i++) {
                Ball b = balls[i];
                result[b.idx] = totalSum - colorSum[b.color];
            }

            for (int i = start; i < idx; i++) {
                Ball b = balls[i];
                totalSum += b.size;
                colorSum[b.color] += b.size;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int r : result) sb.append(r).append("\n");

        System.out.print(sb);
    }
}
