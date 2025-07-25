import java.util.*;
import java.io.*;

class segmentTree {
	
	int len;
	int[] maxTree;
	
	public segmentTree(int len, int[] base) {
		this.len = len;
		this.maxTree = new int[4 * len];
		build(base, 0, len - 1, 0);
	}

	private void build (int[] base, int start, int end, int idx) {
		
		if (start == end) {
			this.maxTree[idx] = base[start];
		} else {
			
			int mid = (start + end) / 2;
			build(base, start, mid, 2 * idx + 1);
			build(base, mid + 1, end, 2 * idx + 2);
			this.maxTree[idx] = Math.max(this.maxTree[2 * idx + 1], this.maxTree[2 * idx + 2]);
		}
		
		return ;
	}
	
	public int findMax(int idx, int start, int end, int l, int r) {
		
		if (r < start || end < l) {
			return 0;
		}
		
		if (l <= start && end <= r) {
			return this.maxTree[idx];
		}
		
		int mid = (start + end) / 2;
		int leftMax = findMax(2 * idx + 1, start, mid, l, r);
		int rightMax = findMax(2 * idx + 2, mid + 1, end, l, r);

		return Math.max(leftMax, rightMax);
	}
}


public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		int N, M;
		int[] map;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		map = new int[N];
		
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		segmentTree maxst = new segmentTree(N, map);
		
		int left = M - 1;
		int right = M + 1;
		
		for (int i = M - 1; i < N - M + 1; i++) {
			sb.append(maxst.findMax(0, 0, N - 1, i - left, i + left));
			sb.append(" ");
		}
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}
