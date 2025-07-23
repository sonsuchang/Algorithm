import java.io.*;

public class Main {
    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[N][2 * N - 1];

        star(0, N - 1, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                sb.append(map[i][j] == 1 ? "*" : " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void star(int row, int col, int size) {
        if (size == 3) {
            map[row][col] = 1;
            map[row + 1][col - 1] = 1;
            map[row + 1][col + 1] = 1;
            for (int i = -2; i <= 2; i++) {
                map[row + 2][col + i] = 1;
            }
            return;
        }

        int newSize = size / 2;
        star(row, col, newSize);
        star(row + newSize, col - newSize, newSize);
        star(row + newSize, col + newSize, newSize);
    }
}
