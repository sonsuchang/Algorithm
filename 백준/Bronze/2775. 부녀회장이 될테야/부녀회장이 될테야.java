import java.io.*;

public class Main {

    static int T, k, n;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        dp = new int[15][15];

        for (int i = 1; i < 15; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < 15; i++) {
            dp[i][1] = dp[i - 1][1];
            for (int j = 2; j < 15; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        for (int i = 0; i < T; i++) {
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            sb.append(dp[k][n] + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}
