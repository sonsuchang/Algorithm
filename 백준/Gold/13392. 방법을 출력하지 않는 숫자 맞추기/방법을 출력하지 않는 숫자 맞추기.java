import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] now, target;
    static int[][] dp;
    static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        now = new int[N];
        target = new int[N];
        dp = new int[N + 1][10];

        String nowStr = br.readLine();
        String targetStr = br.readLine();

        for (int i = 0; i < N; i++) {
            now[i] = nowStr.charAt(i) - '0';
            target[i] = targetStr.charAt(i) - '0';
        }

        for (int[] row : dp) Arrays.fill(row, INF);
        dp[0][0] = 0;

        for (int i = 0; i < N; i++) {
            for (int r = 0; r < 10; r++) {
                if (dp[i][r] == INF) continue;

                int curr = (now[i] + r) % 10;
                int diffLeft = (target[i] - curr + 10) % 10;
                int diffRight = (curr - target[i] + 10) % 10;

                dp[i + 1][(r + diffLeft) % 10] = Math.min(dp[i + 1][(r + diffLeft) % 10], dp[i][r] + diffLeft);

                dp[i + 1][r] = Math.min(dp[i + 1][r], dp[i][r] + diffRight);
            }
        }

        int answer = INF;
        for (int i = 0; i < 10; i++) {
            answer = Math.min(answer, dp[N][i]);
        }

        System.out.println(answer);
    }
}
