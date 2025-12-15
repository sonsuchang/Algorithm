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
        HashSet<Character> sCheck = new HashSet<>();
        HashSet<Character> tCheck = new HashSet<>();
        int sLength = S.length();
        int tLength = T.length();

        for (int i = 0; i < sLength; i++) sCheck.add(S.charAt(i));
        for (int i = 0; i < tLength; i++) tCheck.add(T.charAt(i));

        return sCheck.size() == tCheck.size();
    }

    public static int findN() {
        int n = 1;
        int sPointer = 0;
        int tPointer = 0;
        int sLength = S.length();
        int tLength = T.length();

        while (sPointer < sLength) {
            if (tPointer == tLength) {
                tPointer = 0;
                n++;
            }
            if (S.charAt(sPointer) == T.charAt(tPointer)) {
                sPointer++;
                tPointer++;
            } else {
                tPointer++;
            }
        }

        return n;
    }
}
