import java.util.*;

class Solution {
    
    Map<String, String> dict = new HashMap<>();
    
    public int solution(String s) {
        dict.put("zero", "0");
        dict.put("one", "1");
        dict.put("two", "2");
        dict.put("three", "3");
        dict.put("four", "4");
        dict.put("five", "5");
        dict.put("six", "6");
        dict.put("seven", "7");
        dict.put("eight", "8");
        dict.put("nine", "9");
        
        int length = s.length();
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c - '0' >= 0 && c - '0' <= 9) {
                answer += c;
                continue;
            }
            sb.append(c);
            if (dict.keySet().contains(sb.toString())) {
                answer += dict.get(sb.toString());
                sb = new StringBuilder();
            }
        }
        
        return Integer.parseInt(answer);
    }
}