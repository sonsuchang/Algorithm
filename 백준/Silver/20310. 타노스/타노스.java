import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String s;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();

        int zeroCount = 0;
        int oneCount = 0;
        int length = s.length();

        for(int i = 0; i < length; i++) {
            if (s.charAt(i) == '0') {
                zeroCount++;
            } else {
                oneCount++;
            }
        }

        zeroCount /= 2;
        oneCount /= 2;

        char[] newString = new char[zeroCount + oneCount];

        for (int i = 0; i < zeroCount; i++) {
            newString[i] = '0';
        }

        for (int i = zeroCount; i < zeroCount + oneCount; i++) {
            newString[i] = '1';
        }

        String answer = "";

        for (char c : newString) {
            answer += String.valueOf(c);
        }

        System.out.println(answer);
    }
}
