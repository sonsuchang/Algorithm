import java.util.Scanner;

public class Main {

    static int N, M;
    static int gcdNum;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        if (N < M) {
            int temp = N;
            N = M;
            M = temp;
        }

        gcdNum = gcd(N, M);
        System.out.println(gcdNum);
        System.out.println(N * M / gcdNum);
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

}
