import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[][] menu = new int[N][2];
        int total = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            menu[i][0] = Integer.parseInt(st.nextToken());
            menu[i][1] = Integer.parseInt(st.nextToken());
            total += menu[i][1];
        }

        Arrays.sort(menu, (o1, o2) -> (o2[0] - o2[1]) - (o1[0] - o1[1]));

        int can = (X - 1000 * N) / 4000;

        for (int i = 0; i < N && can > 0; i++) {
            int A = menu[i][0];
            int B = menu[i][1];
            int diff = A - B;

            if (diff > 0) {
                total += diff;
                can--;
            }
        }

        System.out.println(total);
    }
}
