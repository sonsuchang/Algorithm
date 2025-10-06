import java.io.*;
import java.util.*;

public class Main {

    static int R, C;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static char[][] map;
    static ArrayList<int[]> record = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s = br.readLine().split(" ");

        R = Integer.parseInt(s[0]) + 2;
        C = Integer.parseInt(s[1]) + 2;

        map = new char[R][C];
        for (int i = 0; i < R; i++) Arrays.fill(map[i], '.');

        for (int i = 1; i < R - 1; i++) {
            String temp = br.readLine();
            for (int j = 1; j < C - 1; j++) {
                map[i][j] = temp.charAt(j - 1);
            }
        }

        for (int i = 1; i < R - 1; i++) {
            for (int j = 1; j < C - 1; j++) {
                if (map[i][j] == 'X') {
                    int count = 0;
                    for (int d = 0; d < 4; d++) {
                        if (map[i + dr[d]][j + dc[d]] == '.') count++;
                    }
                    if (count >= 3) record.add(new int[] {i, j});
                }
            }
        }

        for (int[] info : record) map[info[0]][info[1]] = '.';

        int rowStart = R;
        int rowEnd = 0;
        int colStart = C;
        int colEnd = 0;
        for (int i = 1; i < R - 1; i++) {
            for (int j = 1; j < C - 1; j++) {
                if (map[i][j] == 'X') {
                    rowStart = Math.min(rowStart, i);
                    rowEnd = Math.max(rowEnd, i);
                    colStart = Math.min(colStart, j);
                    colEnd = Math.max(colEnd, j);
                }
            }
        }
        for (int i = rowStart; i < rowEnd + 1; i++) {
            for (int j = colStart; j < colEnd + 1; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
