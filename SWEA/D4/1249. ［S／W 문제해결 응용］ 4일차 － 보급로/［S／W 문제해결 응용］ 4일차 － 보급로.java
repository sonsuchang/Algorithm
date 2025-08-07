/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution
{
    static int T, N, minValue;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static boolean[][] visited;
    static int[][] map;
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {

            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            visited = new boolean[N][N];

            for (int j = 0; j < N; j++) {
                String[] temp = br.readLine().split("");
                for (int k = 0; k < N; k++) {
                    map[j][k] = Integer.parseInt(temp[k]);
                }
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
            pq.offer(new int[]{map[0][0], 0, 0});

            while (!pq.isEmpty()) {

                int[] cur = pq.poll();
                int cnt = cur[0], r = cur[1], c = cur[2];

                if (r == N - 1 && c == N - 1) {
                    minValue = cnt;
                    break;
                }

                for (int k = 0; k < 4; k++) {

                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    if (check(nr, nc)) {
                        visited[nr][nc] = true;
                        pq.offer(new int[] {cnt + map[nr][nc], nr, nc});
                    }
                }

            }

            sb.append(String.format("#%d %d\n", i, minValue));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
	}
    
    public static boolean check(int nr, int nc) {
        return nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc];
    }
    
}