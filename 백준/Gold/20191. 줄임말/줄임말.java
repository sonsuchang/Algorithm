import java.io.*;
import java.util.*;

public class Main {

    public static String S, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        if (!check()) System.out.println(-1);
        else System.out.println(findN());
    }

    public static boolean check() {
        HashSet<Character> tCheck = new HashSet<>();
        int sLength = S.length();
        int tLength = T.length();

        for (int i = 0; i < tLength; i++) tCheck.add(T.charAt(i));

        for (int i = 0; i < sLength; i++) {
            if (!tCheck.contains(S.charAt(i))) return false;
        }

        return true;
    }

    public static int findN() {
        int n = 1;
        int pos = 0;

        int[][] next = new int[T.length() + 1][26];
        Arrays.fill(next[T.length()], -1);

        for (int i = T.length() - 1; i >= 0; i--) {
            next[i] = next[i + 1].clone();
            next[i][T.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < S.length(); i++) {
            int c = S.charAt(i) - 'a';

            if (next[pos][c] == -1) {
                n++;
                pos = 0;
            }

            if (next[pos][c] == -1) return -1;

            pos = next[pos][c] + 1;
        }

        return n;
    }
}
