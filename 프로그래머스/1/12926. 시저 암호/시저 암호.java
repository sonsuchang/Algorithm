class Solution {
    public String solution(String s, int n) {
        String answer = "";
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                answer += " ";
            } else {
                int target = (int) c;
                if (target <= 90) {
                    target += n;
                    if (target > 90) {
                        target -= 26;
                    }
                } else {
                    target += n;
                    if (target > 122) {
                        target -= 26;
                    }
                }
                answer += String.valueOf((char) target);
            }
        }
        return answer;
    }
}