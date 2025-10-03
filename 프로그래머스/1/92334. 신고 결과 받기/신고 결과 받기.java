import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String[] id_list, String[] report, int k) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> cnt = new HashMap<>();
        HashMap<String, HashSet<String>> map = new HashMap<>();
        
        for (String s : id_list) {
            cnt.put(s, 0);
            map.put(s, new HashSet<>());
        }
        
        for (String temp : report) {
            String[] s = temp.split(" ");
            if (map.get(s[0]).contains(s[1])) continue;
            cnt.put(s[1], cnt.get(s[1]) + 1);
            map.get(s[0]).add(s[1]);
        }
        
        for (String s : id_list) {
            int temp = 0;
            for (String target : map.get(s)) {
                if (cnt.get(target) >= k) temp++;
            }
            answer.add(temp);
        }
        return answer;
    }
}