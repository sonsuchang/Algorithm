import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[N];
        String[] s = br.readLine().split(" ");

        for (int i = 0; i < N; i++) map[i] = Integer.parseInt(s[i]);

        int start = map[0];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++) {
            while(!stack.isEmpty() && map[stack.peek()] < map[i]) {
                map[stack.pop()] = map[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            map[stack.pop()] = -1;
        }

        for (int i : map) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }
}
