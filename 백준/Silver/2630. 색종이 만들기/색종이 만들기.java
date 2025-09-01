import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int wCnt = 0;
	static int bCnt = 0;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		//--------------솔루션 코드를 작성하세요.---------------------------

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
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
	
	public static void divide(int r, int c, int depth) {
		for (int i = r; i < r + depth; i++) {
			for (int j = c; j < c + depth; j++) {
				if (map[i][j] != map[r][c]) {
					int next = depth / 2;
					divide(r, c, next);
					divide(r + next, c, next);
					divide(r, c + next, next);
					divide(r + next, c + next, next);
					return;
				}
			}
		}
		
		if (map[r][c] == 0) wCnt++;
		else bCnt++;
	}
}
