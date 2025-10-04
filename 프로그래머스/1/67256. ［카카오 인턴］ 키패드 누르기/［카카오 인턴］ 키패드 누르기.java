import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        HashMap<Integer, int[]> map = new HashMap<>();
        map.put(1, new int[] {0, 0});
        map.put(2, new int[] {0, 1});
        map.put(3, new int[] {0, 2});
        map.put(4, new int[] {1, 0});
        map.put(5, new int[] {1, 1});
        map.put(6, new int[] {1, 2});
        map.put(7, new int[] {2, 0});
        map.put(8, new int[] {2, 1});
        map.put(9, new int[] {2, 2});
        map.put(0, new int[] {3, 1});
        
        int[] left = new int[] {3, 0};
        int[] right = new int[] {3, 2};
        int length = numbers.length;
        String answer = "";
        
        for (int i = 0; i < length; i++) {
            int now = numbers[i];
            if (now == 1 || now == 4 || now == 7) {
                answer += "L";
                left = map.get(now);
            } else if (now == 3 || now == 6 || now == 9) {
                answer += "R";
                right = map.get(now);
            } else {
                int[] coord = map.get(now);
                int lvalue = Math.abs(left[0] - coord[0]) + Math.abs(left[1] - coord[1]);
                int rvalue = Math.abs(right[0] - coord[0]) + Math.abs(right[1] - coord[1]);
                if (lvalue < rvalue) {
                    left = coord;
                    answer += "L";
                } else if (rvalue < lvalue) {
                    right = coord;
                    answer += "R";
                } else {
                    if (hand.equals("left")) {
                        left = coord;
                        answer += "L";
                    } else {
                        right = coord;
                        answer += "R";
                    }
                }
            }
        }
        
        return answer;
    }
}