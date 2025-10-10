import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] map = new int[101][101];
	static HashMap<Integer, Integer> dirConvert = new HashMap<>();
	static HashMap<Integer, int[]> dir = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		init();
		
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			int c = Integer.parseInt(s[0]);
			int r = Integer.parseInt(s[1]);
			int d = Integer.parseInt(s[2]);
			int g = Integer.parseInt(s[3]);
			
			map[r][c] += 1;
			ArrayList<Integer> base = new ArrayList<>();
			base.add(d);
			
			int[] next = dir.get(d);
			r += next[0];
			c += next[1];
			map[r][c] += 1;
			base.add(dirConvert.get(d));
			
			for (int j = 0; j < g; j++) {
				
				for (int k = base.size() - 1; k >= 1; k--) {
					int now = base.get(k);
					next = dir.get(now);
					if (check(r + next[0], c + next[1])) {
						r += next[0];
						c += next[1];
					}
					map[r][c] += 1;
					base.add(dirConvert.get(now));
				}
			}
		}
		
		int cnt = 0;
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] != 0 && map[i + 1][j] != 0 && map[i][j + 1] != 0 && map[i + 1][j + 1] != 0) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
	
	public static void init() {
		dirConvert.put(0, 1);
		dirConvert.put(1, 2);
		dirConvert.put(2, 3);
		dirConvert.put(3, 0);
		
		dir.put(0, new int[] {0, 1});
		dir.put(1, new int[] {-1, 0});
		dir.put(2, new int[] {0, -1});
		dir.put(3, new int[] {1, 0});
	}
	
	public static boolean check(int row, int col) {
		return row >= 0 && row <= 100 && col >= 0 && col <= 100;
	}
}
