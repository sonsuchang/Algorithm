import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int blength = board.length;
        int mlength = moves.length;
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < mlength; i++) {
            int col = moves[i] - 1;
            for (int j = 0; j < blength; j++) {
                if (board[j][col] == 0) continue;
                if (st.size() == 0) st.add(board[j][col]);
                else {
                    if (board[j][col] == st.peek()) {
                        st.pop();
                        answer += 2;
                    } else st.add(board[j][col]);
                }
                board[j][col] = 0;
                break;
            }
        }
        return answer;
    }
}