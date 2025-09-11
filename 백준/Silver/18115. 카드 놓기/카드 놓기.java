import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deck = new ArrayDeque<>();

        for (int i = N - 1; i >= 0; i--) {
            int card = N - i;
            int skill = A[i];

            if (skill == 1) {
                deck.addFirst(card);
            } else if (skill == 2) {
                if (!deck.isEmpty()) {
                    int first = deck.pollFirst();
                    deck.addFirst(card);
                    deck.addFirst(first);
                } else {
                    deck.addFirst(card);
                }
            } else if (skill == 3) {
                deck.addLast(card);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int card : deck) {
            sb.append(card).append(' ');
        }
        System.out.println(sb.toString().trim());
    }
}
