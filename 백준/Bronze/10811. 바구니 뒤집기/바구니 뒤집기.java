import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] map;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		map = new int[N];
		
		for (int i = 1; i <= N; i++) map[i - 1] = i;
		
		for (int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			int start = Integer.parseInt(s[0]);
			int end = Integer.parseInt(s[1]);
			swap(start - 1, end - 1);
		}
		
        for (int i = 0; i < N; i++) System.out.printf("%d ", map[i]);
	}

	public static void swap(int start, int end) {
		while (start <= end) {
			int temp = map[start];
			map[start] = map[end];
			map[end] = temp;
			start++;
			end--;
		}
	}
	
}
