import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            String s1 = Integer.toBinaryString(arr1[i]);
            String s2 = Integer.toBinaryString(arr2[i]);
            
            StringBuilder sb1 = new StringBuilder();  
            for (int j = 0; j < n - s1.length(); j++) sb1.append("0");
            
            StringBuilder sb2 = new StringBuilder();  
            for (int j = 0; j < n - s2.length(); j++) sb2.append("0");
            
            sb1.append(s1);
            sb2.append(s2);
            
            String result = "";
            String temp1 = sb1.toString();
            String temp2 = sb2.toString();
            
            for (int j = 0; j < n; j++) {
                if (temp1.charAt(j) == '1' || temp2.charAt(j) == '1') result += "#";
                else result += " ";
            }
            
            answer[i] = result;
        }
        
        return answer;
    }
}