import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int answer = Integer.MAX_VALUE;
        boolean[][] check;
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0});
        
        for (int[] i : info) {
            int now = queue.size();
            check = new boolean[n][m];

            for (int j = 0; j < now; j++) {
                int[] poll = queue.poll();
                int nowA = poll[0];
                int nowB = poll[1];
                int nextA = nowA + i[0];
                int nextB = nowB + i[1];
                if (nextA < n && !check[nextA][nowB]) {
                    queue.add(new int[]{nextA, nowB});
                    check[nextA][nowB] = true;
                }
                if (nextB < m && !check[nowA][nextB]) {
                    queue.add(new int[]{nowA, nextB});
                    check[nowA][nextB] = true;
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            answer = Math.min(poll[0], answer);
        }
        
        if (answer == Integer.MAX_VALUE) return -1;
        else return answer;
    }
}