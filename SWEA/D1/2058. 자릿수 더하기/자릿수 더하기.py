import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int length = s.length();
        int sum = 0;
        for (int i = 0; i < length; i++) {
        	sum += Character.getNumericValue(s.charAt(i));
        }
		System.out.println(sum);
	}
}