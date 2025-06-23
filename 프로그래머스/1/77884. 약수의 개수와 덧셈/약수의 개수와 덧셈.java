import java.lang.Math;

class Solution {
    
    private int countPrime(int num) {
        int count = 0;
        long range = (int) Math.sqrt(num);
        for (long i = 1; i <= range; i++) {
            if (num % i == 0) {
                if (num / i == i) {
                    count += 1;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }
    
    public int solution(int left, int right) {
        int answer = 0;
        for (;left <= right; left++) {
            if (countPrime(left) % 2 == 0) {
                answer += left;
            } else {
                answer -= left;
            }
        }
        return answer;
    }
}