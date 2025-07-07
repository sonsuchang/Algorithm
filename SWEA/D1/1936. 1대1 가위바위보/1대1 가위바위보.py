import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.next());
        int b = Integer.parseInt(sc.next());
        if (a > b) {
            System.out.println("A");
        } else {
        	System.out.println("B");
        }
	}
}