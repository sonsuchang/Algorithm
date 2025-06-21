class Solution {
    public String solution(String s) {
        String answer = "";
        int length = s.length();
        if (length % 2 == 0) {
            int i = length / 2;
            answer += s.substring(i - 1, i + 1);
        }
        else {
            int i = length / 2;
            answer += s.substring(i, i + 1);
        }
        return answer;
    }
}