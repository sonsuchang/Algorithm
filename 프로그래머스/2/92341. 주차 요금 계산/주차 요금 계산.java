import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] fees, String[] records) {
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int appendTime = fees[2];
        int appendFee = fees[3];
        
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, String> info = new HashMap<>();
        
        for (String temp : records) {
            String[] s = temp.split(" ");
            if (s[2].length() == 2) info.put(s[1], s[0]);
            else {
                String[] inTime = info.get(s[1]).split(":");
                String[] outTime = s[0].split(":");
                int time = (Integer.parseInt(outTime[0]) * 60 + Integer.parseInt(outTime[1])) - (Integer.parseInt(inTime[0]) * 60 + Integer.parseInt(inTime[1]));
                if (map.keySet().contains(s[1])) map.put(s[1], map.get(s[1]) + time);
                else map.put(s[1], time);
                info.remove(s[1]);
            }
        }
        
        int lastTime = 23 * 60 + 59;
        for (String s : info.keySet()) {
            String[] inTime = info.get(s).split(":");
            int time = lastTime - (Integer.parseInt(inTime[0]) * 60 + Integer.parseInt(inTime[1]));
            if (map.keySet().contains(s)) map.put(s, map.get(s) + time);
            else map.put(s, time);
        }
        
        ArrayList<String> s = new ArrayList<>(map.keySet());
        Collections.sort(s);
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (String key : s) {
            int time = map.get(key) - defaultTime;
            int fee = defaultFee;
            if (time > 0) fee += Math.ceil((double) time / (double) appendTime) * appendFee;
            answer.add(fee);
        }
        
        
        return answer;
    }
}