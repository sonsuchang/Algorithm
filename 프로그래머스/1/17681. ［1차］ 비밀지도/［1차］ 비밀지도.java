import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];    
        
        for (int i = 0; i < n; i++) {
            String temp1 = Integer.toBinaryString(arr1[i]);
            String temp2 = Integer.toBinaryString(arr2[i]);
            int tlength1 = temp1.length();
            int tlength2 = temp2.length();
            for (int j = 0; j < n - tlength1; j++) {
                temp1 = "0" + temp1;
            }
            for (int j = 0; j < n - tlength2; j++) {
                temp2 = "0" + temp2;
            }
            String temp = "";
            for (int j = 0; j < n; j++) {
                if (temp1.charAt(j) == '1' || temp2.charAt(j) == '1') temp += "#";
                else temp += " ";
            }
            answer[i] = temp;
        }
        return answer;
    }
}