import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[] alpha = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int length = alpha.length;
        int[] map = new int[length];

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        HashMap<Character, Integer> sMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            if (!sMap.containsKey(target)) sMap.put(s.charAt(i), i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (sMap.containsKey(alpha[i])) sb.append(sMap.get(alpha[i]) + " ");
            else sb.append(-1 + " ");
        }
        System.out.println(sb.toString());
    }
}
