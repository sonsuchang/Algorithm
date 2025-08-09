import java.io.*;
import java.util.Arrays;

public class Main {

    static int N;
    static int[] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        map = new int[N];

        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(map);
        
        for (int i = 0; i < N; i++) {
            sb.append(map[i] + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}
