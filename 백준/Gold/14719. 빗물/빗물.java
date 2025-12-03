import java.io.*;
import java.util.*;

public class Main {

    static int H;
    static int W;
    static int[] block;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        block = new int[W];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < W; i++) block[i] = Integer.parseInt(st.nextToken());

        int answer = 0;

        for (int i = 1; i < W - 1; i++) {
            int leftMax = 0;
            int rightMax = 0;

            for (int l = 0; l < i; l++) leftMax = Math.max(leftMax, block[l]);

            for (int r = i + 1; r < W; r++) rightMax = Math.max(rightMax, block[r]);

            int height = Math.min(leftMax, rightMax);

            if (height > block[i]) answer += height - block[i];
        }

        System.out.println(answer);
    }
}
