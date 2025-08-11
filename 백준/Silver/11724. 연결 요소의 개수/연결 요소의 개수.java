import java.io.FileInputStream;
import java.io.FileNotFoundException;


import java.io.*;
import java.util.*;

public class Main {

	static int N, M, u, v, cnt;
	static int[][] map;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			map[u][v] = 1;
			map[v][u] = 1;
		}
		
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				DFS(i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	public static void DFS(int start) {
		for (int i = 1; i <= N; i++) {
			if (map[start][i] == 1) {
				map[start][i] = 0;
				visited[i] = true;
				DFS(i);
			}
		}
		return;
	}

}
