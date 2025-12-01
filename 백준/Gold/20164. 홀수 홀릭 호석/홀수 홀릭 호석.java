import java.io.*;

public class Main {
    static int minValue = Integer.MAX_VALUE;
    static int maxValue = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        dfs(N, countOdd(N));
        System.out.println(minValue + " " + maxValue);
    }

    static int countOdd(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            int n = c - '0';
            if (n % 2 == 1) cnt++;
        }
        return cnt;
    }

    static void dfs(String num, int cnt) {
        int len = num.length();

        if (len == 1) {
            minValue = Math.min(minValue, cnt);
            maxValue = Math.max(maxValue, cnt);
            return;
        }

        if (len == 2) {
            int sum = (num.charAt(0) - '0') + (num.charAt(1) - '0');
            dfs(Integer.toString(sum), cnt + countOdd(Integer.toString(sum)));
            return;
        }

        for (int i = 1; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {

                int a = Integer.parseInt(num.substring(0, i));
                int b = Integer.parseInt(num.substring(i, j));
                int c = Integer.parseInt(num.substring(j));

                int sum = a + b + c;
                String ns = Integer.toString(sum);

                dfs(ns, cnt + countOdd(ns));
            }
        }
    }
}
