class Solution {
    public long solution(int[] a, int[] b) {
        long answer = 0;
        int length = a.length;
        for (int i = 0; i < length; i++) {
            answer += (a[i] * b[i]);
        }
        return answer;
    }
}