import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] map = new int[8];
        for (int i = 0; i < 8; i++) {
            map[i] = sc.nextInt();
        }
        int cnt = 0;
        for (int i = 0; i < 7; i++) {
            if (map[i] < map[i + 1]) {
                cnt++;
            }
        }
        if (cnt == 7) System.out.println("ascending");
        else if (cnt == 0) System.out.println("descending");
        else System.out.println("mixed");
    }
}
