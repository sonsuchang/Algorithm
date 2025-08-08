import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] map = new  int[n];

        for (int i = 0; i < n; i++) {
            map[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (map[i] < x) {
                System.out.print(map[i] + " ");
            }
        }
    }
}
