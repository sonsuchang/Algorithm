import java.util.*;

class Solution {
    public ArrayList<Integer> solution(long n) {
        ArrayList<Integer> answer = new ArrayList<>();
        String strN = String.valueOf(n);
        for (int i = strN.length() - 1; i > -1; i--) {
            String temp = String.valueOf(strN.charAt(i));
            answer.add(Integer.valueOf(temp));
        }
        return answer;
    }
}