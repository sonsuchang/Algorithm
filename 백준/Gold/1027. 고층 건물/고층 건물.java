import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static long[] h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        h = new long[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) h[i] = Integer.parseInt(st.nextToken());

        int answer = 0;

        for (int i = 0; i < N; i++) {
            int count = 0;

            double maxSlope = -Double.MAX_VALUE;
            for (int j = i + 1; j < N; j++) {
                double slope = (double)(h[j] - h[i]) / (j - i);
                if (slope > maxSlope) {
                    maxSlope = slope;
                    count++;
                }
            }

            double minSlope = Double.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                double slope = (double)(h[j] - h[i]) / (j - i);
                if (slope < minSlope) {
                    minSlope = slope;
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
}
