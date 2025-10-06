import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int j = 0; j < T; j++) {
            int k = Integer.parseInt(br.readLine());

            PriorityQueue<long[]> minHeap = new PriorityQueue<>(Comparator.comparingLong(o -> o[0]));
            PriorityQueue<long[]> maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));

            boolean[] valid = new boolean[k];
            int idx = 0;

            for (int i = 0; i < k; i++) {
                String[] cmd = br.readLine().split(" ");
                char op = cmd[0].charAt(0);
                long num = Long.parseLong(cmd[1]);

                if (op == 'I') {
                    minHeap.offer(new long[]{num, idx});
                    maxHeap.offer(new long[]{num, idx});
                    valid[idx] = true;
                    idx++;
                } else if (op == 'D') {
                    if (num == 1) {
                        while (!maxHeap.isEmpty() && !valid[(int) maxHeap.peek()[1]]) {
                            maxHeap.poll();
                        }
                        if (!maxHeap.isEmpty()) {
                            valid[(int) maxHeap.poll()[1]] = false;
                        }
                    } else {
                        while (!minHeap.isEmpty() && !valid[(int) minHeap.peek()[1]]) {
                            minHeap.poll();
                        }
                        if (!minHeap.isEmpty()) {
                            valid[(int) minHeap.poll()[1]] = false;
                        }
                    }
                }
            }

            while (!maxHeap.isEmpty() && !valid[(int) maxHeap.peek()[1]]) maxHeap.poll();
            while (!minHeap.isEmpty() && !valid[(int) minHeap.peek()[1]]) minHeap.poll();

            if (maxHeap.isEmpty() || minHeap.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(maxHeap.peek()[0]).append(" ").append(minHeap.peek()[0]).append("\n");
            }
        }

        System.out.print(sb);
    }
}
