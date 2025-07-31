import java.io.*;
import java.util.*;

class segmentTree {
    int n;
    Pair[] tree;

    public segmentTree(int[] arr) {
        this.n = arr.length;
        tree = new Pair[4 * n];
        build(arr, 0, n - 1, 0);
    }

    private void build(int[] arr, int start, int end, int idx) {
        if (start == end) {
            tree[idx] = new Pair(arr[start], start);
        } else {
            int mid = (start + end) / 2;
            build(arr, start, mid, 2 * idx + 1);
            build(arr, mid + 1, end, 2 * idx + 2);
            tree[idx] = minPair(tree[2 * idx + 1], tree[2 * idx + 2]);
        }
    }

    public void update(int pos, int value) {
        updateUtil(0, n - 1, pos, value, 0);
    }

    private void updateUtil(int start, int end, int pos, int value, int idx) {
        if (start == end) {
            tree[idx] = new Pair(value, pos);
        } else {
            int mid = (start + end) / 2;
            if (pos <= mid) {
                updateUtil(start, mid, pos, value, 2 * idx + 1);
            } else {
                updateUtil(mid + 1, end, pos, value, 2 * idx + 2);
            }
            tree[idx] = minPair(tree[2 * idx + 1], tree[2 * idx + 2]);
        }
    }

    public int query(int l, int r) {
        return queryUtil(0, n - 1, l, r, 0).index + 1; // 인덱스를 1-based로 출력
    }

    private Pair queryUtil(int start, int end, int l, int r, int idx) {
        if (r < start || end < l) return new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
        if (l <= start && end <= r) return tree[idx];
        int mid = (start + end) / 2;
        Pair left = queryUtil(start, mid, l, r, 2 * idx + 1);
        Pair right = queryUtil(mid + 1, end, l, r, 2 * idx + 2);
        return minPair(left, right);
    }

    private Pair minPair(Pair a, Pair b) {
        if (a.value != b.value) return a.value < b.value ? a : b;
        return a.index < b.index ? a : b;
    }

    static class Pair {
        int value;
        int index;
        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(temp[i]);
        }

        segmentTree st = new segmentTree(A);

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] cmd = br.readLine().split(" ");
            int type = Integer.parseInt(cmd[0]);
            if (type == 1) {
                int idx = Integer.parseInt(cmd[1]) - 1;
                int value = Integer.parseInt(cmd[2]);
                st.update(idx, value);
            } else {
                int l = Integer.parseInt(cmd[1]) - 1;
                int r = Integer.parseInt(cmd[2]) - 1;
                sb.append(st.query(l, r)).append('\n');
            }
        }

        System.out.print(sb);
    }
}
