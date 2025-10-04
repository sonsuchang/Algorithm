import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int length = dartResult.length();
        
        Stack<Integer> st = new Stack<>();
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < length; i++) {
            char c = dartResult.charAt(i);
            if ((int) c <= 57 && (int) c >= 48) {
                sb.append(c);
                continue;
            }
            
            if (c == 'S') {
                int num = Integer.parseInt(sb.toString());
                sb = new StringBuilder();
                st.add(num);
            } else if (c == 'D') {
                int num = Integer.parseInt(sb.toString());
                sb = new StringBuilder();
                st.add((int) Math.pow(num, 2));
            } else if (c == 'T') {
                int num = Integer.parseInt(sb.toString());
                sb = new StringBuilder();
                st.add((int) Math.pow(num, 3));
            } else if (c == '*') {
                int prev = st.pop();
                if (!st.isEmpty()) {
                    int pprev = st.pop();
                    st.add(pprev * 2);
                }
                st.add(prev * 2);
            } else {
                int prev = st.pop();
                st.add(prev * -1);
            }
        }
        while (!st.isEmpty()) answer += st.pop();
        return answer;
    }
}