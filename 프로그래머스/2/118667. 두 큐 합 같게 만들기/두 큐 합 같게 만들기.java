import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Long> q1 = new ArrayDeque<>();
        Queue<Long> q2 = new ArrayDeque<>();
        long qSum1 = 0;
        long qSum2 = 0;
        
        for (int i : queue1) {
            q1.offer((long) i);
            qSum1 += (long) i;
        }
        
        for (int i : queue2) {
            q2.offer((long) i);
            qSum2 += (long) i;
        }
        
        int answer = 0;
        long target = (qSum1 + qSum2) / 2;
        int limit = queue1.length * 3;
        
        while (answer < limit) {
            if (qSum1 == target) break;
            
            if (qSum1 > qSum2) {
                long temp = q1.poll();
                q2.offer(temp);
                qSum1 -= temp;
                qSum2 += temp;
            } else {
                long temp = q2.poll();
                q1.offer(temp);
                qSum2 -= temp;
                qSum1 += temp;
            }
            answer++;
        }
        
        if (answer == limit) answer = -1;
        
        return answer;
    }
}