class Solution {
    public String solution(String s) {
        String answer = "";
        int length = s.length();
        int idx = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                answer += " ";
                idx = 0;
            } else {
                if (idx % 2 == 0) {
                    answer += String.valueOf(Character.toUpperCase(c));
                } else {
                    answer += String.valueOf(Character.toLowerCase(c));
                }
                idx++;
            }
        }
        return answer;
    }
}