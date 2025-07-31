import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
            int divide = sc.nextInt();
            int[] nList = new int[divide];
            int idx = 0;
            for(int i = 0; i < N; i++) {
                if (idx == divide) {
                    idx = 0;
                }
                nList[idx]++;
                idx += 1;
            }
            long answer = 1;
            for (int i : nList) {
                answer *= i;
            }
            System.out.printf("#%d %d\n", test_case, answer);
		}
	}
}