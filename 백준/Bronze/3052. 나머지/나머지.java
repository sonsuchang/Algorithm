import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] map = new int[10];
        for (int i = 0; i < 10; i++) {
            map[i] = sc.nextInt();
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < 10; i++) {
            set.add(map[i] % 42);
        }
        System.out.println(set.size());
    }
}
