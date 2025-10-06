import java.util.*;

class Solution {
    public int solution(int n, int k) {
        String converted = Integer.toString(n, k);
        String[] parts = converted.split("0+");
        int count = 0;

        for (String p : parts) {
            if (p.isEmpty()) continue;
            long num = Long.parseLong(p);
            if (isPrime(num)) count++;
        }

        return count;
    }

    private boolean isPrime(long num) {
        if (num < 2) return false;
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
