import java.util.*;

class Solution {
    public int solution(String dartResult) {
        
        int length = dartResult.length();
        
        List<Integer> numList = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < length; i++) {
            char c = dartResult.charAt(i);
            if (c - '0' >= 0 && c - '0' <= 9) {
                sb.append(c);
            } else if (c == 'S') {
                String temp = sb.toString();
                numList.add(Integer.parseInt(temp));
                sb = new StringBuilder();
            } else if (c == 'D') {
                String temp = sb.toString();
                numList.add((int) Math.pow(Integer.parseInt(temp), 2));
                sb = new StringBuilder();
            } else if (c == 'T') {
                String temp = sb.toString();
                numList.add((int) Math.pow(Integer.parseInt(temp), 3));
                sb = new StringBuilder();
            } else if (c == '*') {
                int temp = numList.size() - 1;
                int cnt = 0;
                while (cnt < 2 && temp >= 0) {
                    numList.set(temp, numList.get(temp) * 2);
                    temp--;
                    cnt++;
                }
            } else {
                int temp = numList.size() - 1;
                numList.set(temp, numList.get(temp) * -1);
            }
        }
        
        int answer = 0;
        
        for (int i = 0; i < numList.size(); i++) {
            answer += numList.get(i);
        }
        
        return answer;
    }
}