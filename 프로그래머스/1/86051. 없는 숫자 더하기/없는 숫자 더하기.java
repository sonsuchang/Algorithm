import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        int i = 0;
        int idx = 0;
        while (idx < numbers.length) {
            if (numbers[idx] == i) {
                i++;
                idx++;
            }
            else {
                answer += i;
                i++;
            }
        }
        while (i < 10) {
            answer += i;
            i++;
        }
        return answer;
    }
}