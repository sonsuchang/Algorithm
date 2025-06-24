import java.util.*;

class Solution {    
    public String solution(String s) {
        ArrayList<Character> smallArr = new ArrayList<>();
        ArrayList<Character> bigArr = new ArrayList<>();
        int length = s.length();
        String answer = "";
        for (int i = 0; i < length; i++) {
            if ((int) s.charAt(i) > 90) {
                smallArr.add(s.charAt(i));
            } else {
                bigArr.add(s.charAt(i));
            }
        }
        smallArr.sort(Comparator.reverseOrder());
        bigArr.sort(Comparator.reverseOrder());
        for (char i : smallArr) {
            answer += i;
        }
        for (char i : bigArr) {
            answer += i;
        }
        return answer;
    }
}