class Solution {
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int g = 0;
        if (n < m) {
            g = gcd(n, m);
        } else {
            g = gcd(m, n);
        }
        answer[0] = g;
        answer[1] = n * m / g;
        return answer;
    }
}