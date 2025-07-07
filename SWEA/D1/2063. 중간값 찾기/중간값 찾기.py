import java.util.Scanner;
import java.util.Arrays;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
        int[] nList = new int[N];
        for (int i = 0; i < N; i++) {
            nList[i] = sc.nextInt();
        }
        Arrays.sort(nList);
        System.out.println(nList[N / 2]);
	}
}