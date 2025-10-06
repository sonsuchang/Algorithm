import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i < 5; i++) {
            if (check(places[i])) answer[i] = 1;
            else answer[i] = 0;
        }
        return answer;
    }
    
    public boolean check(String[] place) {
        ArrayList<int[]> map = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (place[i].charAt(j) == 'P') map.add(new int[] {i, j});
            }
        }
        
        for (int i = 0; i < map.size(); i++) {
            int[] now = map.get(i);
            for (int j = i + 1; j < map.size(); j++) {
                int[] next = map.get(j);
                int dist = Math.abs(now[0] - next[0]) + Math.abs(now[1] - next[1]);
                if (dist == 1) return false;
                if (dist > 2) continue;
                if (now[0] == next[0]) {
                    if (place[now[0]].charAt(next[1] - 1) == 'O') return false;
                } else if (now[1] == next[1]) {
                    if (place[next[0] - 1].charAt(now[1]) == 'O') return false;
                } else {
                    if (place[now[0]].charAt(next[1]) == 'O' ||
                       place[next[0]].charAt(now[1]) == 'O') return false;
                }
            }
        }

        return true;
    }
}