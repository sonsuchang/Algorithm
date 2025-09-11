import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String S = sc.next();

        int countO = 0;

        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == 'O') {
                countO++;
            }
        }

        if (countO >= (N + 1) / 2) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
