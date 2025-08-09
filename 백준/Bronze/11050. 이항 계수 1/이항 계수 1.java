import java.util.Scanner;

public class Main {

    static int N, K, range;
    static boolean[] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        visited = new boolean[N];

        combination(0, 0);

        System.out.println(range);

    }

    public static void combination(int cnt, int start) {

        if (cnt == K) {
            range++;
            return ;
        }

        for (int i = start; i < N; i++) {
            visited[i] = true;
            combination(cnt + 1, i + 1);
            visited[i] = false;
        }

    }


}
