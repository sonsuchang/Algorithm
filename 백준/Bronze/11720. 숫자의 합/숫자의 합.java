import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] nList = br.readLine().toCharArray();
        
        int sum = 0;
        
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(String.valueOf(nList[i]));
        }

        System.out.println(sum);
    }
}
