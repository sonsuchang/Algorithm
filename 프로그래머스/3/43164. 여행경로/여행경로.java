import java.util.*;

class Solution {
    static List<String> answer;
    static boolean[] visited;
    static List<String[]> ticketsList;

    public String[] solution(String[][] tickets) {
    
        int n = tickets.length;
        visited = new boolean[n];
        ticketsList = new ArrayList<>(Arrays.asList(tickets));
        
        ticketsList.sort((a, b) -> a[1].compareTo(b[1]));
        
        answer = new ArrayList<>();
        List<String> path = new ArrayList<>();
        path.add("ICN");
        
        dfs("ICN", path, 0);
        return answer.toArray(new String[0]);
    }
    
    static boolean dfs(String cur, List<String> path, int used) {
        if (used == ticketsList.size()) {
            answer = new ArrayList<>(path);
            return true;
        }
        
        for (int i = 0; i < ticketsList.size(); i++) {
            String[] ticket = ticketsList.get(i);
            if (!visited[i] && ticket[0].equals(cur)) {
                visited[i] = true;
                path.add(ticket[1]);
                
                if (dfs(ticket[1], path, used + 1)) return true;
                
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
        return false;
    }
}