import java.io.*;
import java.util.*;

public class Main {

    public static int r, c;
    public static ArrayList<StringBuilder> map = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        for (int i = 0; i < c; i++) map.add(new StringBuilder());

        for (int i = 0; i < r; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                map.get(j).append(temp[j]);
            }
        }

        int count = 0;

        while (map.get(0).length() > -1) {
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < c; i++) {
                map.get(i).deleteCharAt(0);
                set.add(map.get(i).toString());
            }
            if (set.size() % c == 0) count++;
            else break;
        }
        System.out.println(count);
    }
}
