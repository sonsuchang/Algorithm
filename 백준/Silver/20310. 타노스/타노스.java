import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int zeroCount = 0;
        int oneCount = 0;

        for (char c : s.toCharArray()) {
            if (c == '0') zeroCount++;
            else oneCount++;
        }

        int zeroToRemove = zeroCount / 2;
        int oneToRemove = oneCount / 2;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '1' && oneToRemove > 0) {
                oneToRemove--;
            } else {
                sb.append(c);
            }
        }

        StringBuilder result = new StringBuilder();
        zeroToRemove = zeroCount / 2;
        
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);

            if (c == '0' && zeroToRemove > 0) {
                zeroToRemove--;
            } else {
                result.append(c);
            }
        }

        System.out.println(result.reverse());
    }
}
