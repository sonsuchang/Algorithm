import java.util.*;

class Solution {
    public int solution(String s) {
        Map<String, String> map = new HashMap<>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");

        StringBuilder answer = new StringBuilder();
        int idx = 0;

        while (idx < s.length()) {
            char c = s.charAt(idx);

            // 숫자인 경우 그대로 추가
            if (Character.isDigit(c)) {
                answer.append(c);
                idx++;
                continue;
            }

            // 문자인 경우, 최대 길이 5까지 잘라서 단어 탐색
            for (int len = 3; len <= 5 && idx + len <= s.length(); len++) {
                String part = s.substring(idx, idx + len);
                if (map.containsKey(part)) {
                    answer.append(map.get(part));
                    idx += len;
                    break;
                }
            }
        }

        return Integer.parseInt(answer.toString());
    }
}
