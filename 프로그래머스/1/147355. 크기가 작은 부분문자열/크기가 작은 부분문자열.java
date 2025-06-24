class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int tLength = t.length();
        int pLength = p.length();
        long ip = Long.parseLong(p);
        for (int i = 0; i <= (tLength - pLength); i++) {
            if (Long.parseLong(t.substring(i, i + pLength)) <= ip) {
                answer++;
            }
        }
        return answer;
    }
}