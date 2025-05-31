import java.lang.Math;

class Solution {
    public long solution(long n) {
        long answer = 0;
        for (int i = 1; i <= 50000000; i++) {
            if (Math.pow(i, 2) == n) {
                answer = i + 1;
                break;
            }
        }
        if (answer == 0) {
            return -1;
        }
        return answer * answer;
    }
}