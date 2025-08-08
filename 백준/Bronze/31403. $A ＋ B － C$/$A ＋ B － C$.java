import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        System.out.println(A + B - C);
        String sb = String.valueOf(A) + String.valueOf(B);
        int AB = Integer.parseInt(sb);
        System.out.println(AB - C);
    }
}
