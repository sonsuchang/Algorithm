import java.io.*;
import java.util.*;

public class Main {

    static class Point {
        long x, y;
        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static long ccw(Point a, Point b, Point c) {
        return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        Point A = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Point B = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        Point C = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Point D = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

        long ab_c = ccw(A, B, C);
        long ab_d = ccw(A, B, D);
        long cd_a = ccw(C, D, A);
        long cd_b = ccw(C, D, B);

        boolean inter1 = (ab_c > 0 && ab_d < 0) || (ab_c < 0 && ab_d > 0);
        boolean inter2 = (cd_a > 0 && cd_b < 0) || (cd_a < 0 && cd_b > 0);

        System.out.println((inter1 && inter2) ? 1 : 0);
    }
}
