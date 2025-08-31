import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, wCnt, bCnt;
    static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        wCnt = 0;
        bCnt = 0;
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }
        divide(0, 0, N);
        System.out.println(wCnt);
        System.out.println(bCnt);
    }

    public static void divide(int r, int c, int size) {

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                int color = map[r][c];
                if (map[i][j] != color) {
                    int next = size / 2;
                    divide(r, c, next);
                    divide(r, c + next, next);
                    divide(r + next, c, next);
                    divide(r + next, c + next, next);
                    return;
                }
            }
        }

        if (map[r][c] == 0) wCnt++;
        else bCnt++;
    }
}
