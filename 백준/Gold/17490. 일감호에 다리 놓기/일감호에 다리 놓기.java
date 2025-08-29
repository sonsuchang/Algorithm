import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static long K;
	static int[] map;
	static int[] parent;
	static boolean[] block;
	
	public static void union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);
		
		if (map[parentA] <= map[parentB]) parent[parentB] = parent[parent[parentA]];
		else parent[parentA] = parent[parent[parentB]];
	}
	
	public static int find(int child) {
		if (parent[child] == child) return child;
		return parent[child] = find(parent[child]);
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		K = Long.parseLong(s[2]);
		
		map = new int[N + 1];
		parent = new int[N + 1];
		block = new boolean[N + 1];
		
		s = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			map[i] = Integer.parseInt(s[i - 1]);
			parent[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			block[b] = true;
		}
		
		for (int i = 1; i <= N; i++) {
			int j = (i + 1) % (N + 1);
			if (j == 0) j = 1;
			if (find(i) != find(j)) {
				if (block[j]) continue;
				union(i, j);
			}
		}
		
		long sum = 0;
		int pCount = 0;
		
		for (int i = 1; i <= N; i++) {
			if (find(i) == i) {
				sum += map[i];
				pCount++;
			}
		}
		
		if (sum <= K || pCount <= 1) System.out.println("YES");
		else System.out.println("NO");
	}
}

