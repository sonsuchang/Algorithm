import java.util.*;

class Solution {
    public int[] solution(String s) {
        int length = s.length();
        int[] answer = new int[length];
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (map.keySet().contains(c)) {
                answer[i] = i - map.get(c);
                map.replace(c, i);
            } else {
                map.put(c, i);
                answer[i] = -1;
            }
        }
        return answer;
    }
}