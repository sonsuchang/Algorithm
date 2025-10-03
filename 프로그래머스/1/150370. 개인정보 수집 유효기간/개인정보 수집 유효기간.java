import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        Map<String, Integer> term = new HashMap<>();
        
        int todayValue = toDays(today);
        
        for (String t : terms) {
            String[] s = t.split(" ");
            term.put(s[0], Integer.parseInt(s[1]));
        }
        
        for (int i = 0; i < privacies.length; i++) {
            String[] p = privacies[i].split(" ");
            String date = p[0];
            String type = p[1];
            
            int expireDate = toDays(date) + term.get(type) * 28 - 1;
            
            if (todayValue > expireDate) {
                answer.add(i + 1);
            }
        }
        return answer;
    }
    
    private int toDays(String date) {
        String[] s = date.split("\\.");
        int year = Integer.parseInt(s[0]);
        int month = Integer.parseInt(s[1]);
        int day = Integer.parseInt(s[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }
}