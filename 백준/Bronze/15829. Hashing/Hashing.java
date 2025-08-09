import java.util.Scanner;

public class Main {

    static int r = 31;
    static int M = 1234567891;
    static int L;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();

        String s = sc.next();

        int sum = 0;

        for (int i = 0; i < L; i++) {
            sum += ((((int) s.charAt(i) - 96) * (Math.pow(r, i))) % M);
        }

        System.out.println(sum);

    }

}
