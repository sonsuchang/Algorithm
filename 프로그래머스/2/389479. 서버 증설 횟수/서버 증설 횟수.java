import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] server = new int[24];
        
        for (int i = 0; i < 24; i++) {
            int requiredServers = (players[i]) / m;
            int availableServers = server[i];
            
            if (requiredServers > availableServers) {
                int addServers = requiredServers - availableServers;
                for (int j = i; j < i + k && j < 24; j++) server[j] += addServers;
                answer += addServers;
            }
        }
        
        return answer;
    }
}