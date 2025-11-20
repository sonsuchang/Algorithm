import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static int[][] A;
    static int[][] map;
    static LinkedList<Integer>[][] trees;

    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        map = new int[N][N];
        trees = new LinkedList[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                trees[i][j] = new LinkedList<>();
                map[i][j] = 5;
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            trees[x][y].add(z);
        }

        for (int i = 0; i < K; i++) {
            springSummer();
            fall();
            winter();
        }

        System.out.println(countTrees());
    }

    static void springSummer() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (trees[i][j].isEmpty()) continue;

                int dead = 0;
                ListIterator<Integer> it = trees[i][j].listIterator();

                while (it.hasNext()) {
                    int age = it.next();
                    if (map[i][j] >= age) {
                        map[i][j] -= age;
                        it.set(age + 1);
                    } else {    // 죽음
                        dead += age / 2;
                        it.remove();
                    }
                }
                map[i][j] += dead;
            }
        }
    }

    static void fall() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int age : trees[i][j]) {
                    if (age % 5 == 0) {
                        for (int d = 0; d < 8; d++) {
                            int nx = i + dx[d];
                            int ny = j + dy[d];
                            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                            trees[nx][ny].addFirst(1);
                        }
                    }
                }
            }
        }
    }

    static void winter() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] += A[i][j];
            }
        }
    }

    static int countTrees() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cnt += trees[i][j].size();
            }
        }
        return cnt;
    }
}
