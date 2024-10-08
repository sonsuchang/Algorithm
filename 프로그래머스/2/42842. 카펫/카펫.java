import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> solution(int brown, int yellow) {
        ArrayList<Integer> answer = new ArrayList<>();
        int by_sum = brown + yellow;
        for (int i = by_sum; i > 0; i--){
            if (by_sum % i == 0){
                int j = by_sum / i;
                if (i * 2 + (j - 2) * 2 == brown){
                    answer.add(i);
                    answer.add(j);
                    break;
                }
            }
        }
        return answer;
    }
}