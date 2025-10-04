import java.util.*;

class Solution {
    
    class Node implements Comparable<Node> {
        int stage;
        double failRatio;
        public Node (int stage, double failRatio) {
            this.stage = stage;
            this.failRatio = failRatio;
        }
        public int compareTo(Node other) {
            int cmp = Double.compare(other.failRatio, this.failRatio);
            if (cmp == 0) {
                return Integer.compare(this.stage, other.stage);
            }
            return cmp;
        }
    }
    
    public ArrayList<Integer> solution(int N, int[] stages) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Double> map = new HashMap<>();
        int length = stages.length;
        for (int i = 1; i <= N + 1; i++) map.put(i, 0.0);
        Arrays.sort(stages);
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (i + 1 < length && stages[i] == stages[i + 1]) {
                count++;
                continue;
            }
            count++;
            map.put(stages[i], count / (double) (length - i + (count - 1)));
            count = 0;
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for (int i : map.keySet()) pq.offer(new Node(i, map.get(i)));
        
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (now.stage > N) continue;
            answer.add(now.stage);
        }
        
        return answer;
    }
}