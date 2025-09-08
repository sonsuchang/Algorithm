import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] P;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		P = new int[N];

		String[] s = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(s[i]);
		}

		M = Integer.parseInt(br.readLine());

		String[] dp = new String[M + 1];
		Arrays.fill(dp, null);
		dp[0] = "";

		for (int i = 0; i <= M; i++) {
			if (dp[i] == null) continue;

			for (int d = 0; d < N; d++) {
				int cost = P[d];
				if (i + cost > M) continue;

				String next = dp[i] + d;
				if (next.charAt(0) == '0' && next.length() > 1) continue;

				if (dp[i + cost] == null || compare(dp[i + cost], next) < 0) {
					dp[i + cost] = next;
				}
			}
		}

		String answer = "";
		for (int i = 0; i <= M; i++) {
			if (dp[i] != null && compare(dp[i], answer) > 0) {
				answer = dp[i];
			}
		}
		System.out.println(answer.equals("") ? "0" : sortDesc(answer));
	}

	static int compare(String a, String b) {
		if (a.length() != b.length()) return a.length() - b.length();
		return a.compareTo(b);
	}

	static String sortDesc(String s) {
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		StringBuilder sb = new StringBuilder(new String(chars));
		return sb.reverse().toString();
	}
}
