import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int length = survey.length;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);
        
        for (int i = 0; i < length; i++) {
            if (choices[i] == 0) continue;
            if (choices[i] < 4) {
                char temp = survey[i].charAt(0);
                int point = Math.abs(choices[i] - 4);
                map.put(temp, map.get(temp) + point);
            } else {
                char temp = survey[i].charAt(1);
                int point = choices[i] - 4;
                map.put(temp, map.get(temp) + point);
            }
        }
        
        if (map.get('R') > map.get('T') || map.get('R') == map.get('T')) answer += "R";
        else answer += "T";
        if (map.get('C') > map.get('F') || map.get('C') == map.get('F')) answer += "C";
        else answer += "F";
        if (map.get('J') > map.get('M') || map.get('J') == map.get('M')) answer += "J";
        else answer += "M";
        if (map.get('A') > map.get('N') || map.get('A') == map.get('N')) answer += "A";
        else answer += "N";
        
        return answer;
    }
}