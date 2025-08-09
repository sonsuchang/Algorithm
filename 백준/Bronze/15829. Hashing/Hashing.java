import java.util.Scanner;

public class Main {

    static int r = 31;
    static int M = 1234567891;
    static int L;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();

        String s = sc.next();

        long sum = 0;
        long pow = 1;

        for (int i = 0; i < L; i++) {
            int val = s.charAt(i) - 'a' + 1;
            sum = (sum + (val * pow) % M) % M;
            pow = (pow * r) % M;
        }

        System.out.println(sum);

    }

}
