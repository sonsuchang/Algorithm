import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        int K = Integer.parseInt(st.nextToken());

        int len = N.length();
        if (len == 1) {
            System.out.println(-1);
            return;
        }

        Queue<String> q = new LinkedList<>();
        boolean[][] visited = new boolean[K + 1][1000001]; 
        q.offer(N);
        visited[0][Integer.parseInt(N)] = true;

        for (int cnt = 0; cnt < K; cnt++) {
            int size = q.size();
            if (size == 0) {
                System.out.println(-1);
                return;
            }

            for (int s = 0; s < size; s++) {
                String cur = q.poll();
                char[] arr = cur.toCharArray();

                for (int i = 0; i < len; i++) {
                    for (int j = i + 1; j < len; j++) {
                        char tmp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = tmp;

                        if (arr[0] != '0') {
                            int num = Integer.parseInt(new String(arr));
                            if (!visited[cnt + 1][num]) {
                                visited[cnt + 1][num] = true;
                                q.offer(String.valueOf(num));
                            }
                        }

                        arr[j] = arr[i];
                        arr[i] = tmp;
                    }
                }
            }
        }

        int ans = -1;
        while (!q.isEmpty()) {
            ans = Math.max(ans, Integer.parseInt(q.poll()));
        }
        System.out.println(ans);
    }
}
