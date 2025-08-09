import java.util.Scanner;

public class Main {

    static String ISBN;
    static int length, sum;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ISBN = sc.next();
        length = ISBN.length();

        int one = 0;
        int three = 0;

        sum = 0;

        for (int i = 0; i < length - 1; i++) {
            char c = ISBN.charAt(i);
            if (c == '*') {
                if (i % 2 == 0) one++;
                else three++;
                continue;
            }
            if (i % 2 == 0) {
                sum += c - 48;
            } else {
                sum += (c - 48) * 3;
            }
        }

        char check = ISBN.charAt(12);

        sum += (check - 48);

        if (one == 1) {
            System.out.println((sum / 10 + 1) * 10 - sum);
        } else {
            int num = 0;
            while (true) {
                if (sum % 10 == 0) {
                    System.out.println(num);
                    break;
                }
                sum += 3;
                num++;
            }
        }
    }

}
