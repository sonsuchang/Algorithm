import java.io.*;
import java.util.*;

public class Main {

    static int T, k;
    static int[] dp;
    static List<int[]> coins = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            coins.add(new int[]{p, n});
        }

        dp = new int[T + 1];
        dp[0] = 1;

        for (int i = 0; i < k; i++) {
            int value = coins.get(i)[0];
            int count = coins.get(i)[1];

            int[] temp = dp.clone();

            for (int amount = 0; amount <= T; amount++) {
                if (dp[amount] == 0) continue;

                for (int j = 1; j <= count; j++) {
                    int next = amount + value * j;
                    if (next > T) break;
                    temp[next] += dp[amount];
                }
            }

            dp = temp;
        }

        System.out.println(dp[T]);
    }
}
