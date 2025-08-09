import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, blackJack;
    static int[] cards;
    static int[] pickCard;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cards = new int[N];
        pickCard = new int[3];
        visited = new boolean[N];
        blackJack = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) cards[i] = Integer.parseInt(st.nextToken());

        combi(0, 0);

        System.out.println(blackJack);
    }

    public static void combi(int cnt, int start) {

        if (cnt == 3) {
            int sum = 0;
            for (int i : pickCard) sum += i;
            if (sum <= M) blackJack = Math.max(blackJack, sum);
            return;
        }

        for (int i = start; i < N; i++) {
            visited[i] = true;
            pickCard[cnt] = cards[i];
            combi(cnt + 1, i + 1);
            pickCard[cnt] = 0;
            visited[i] = false;
        }
    }

}
