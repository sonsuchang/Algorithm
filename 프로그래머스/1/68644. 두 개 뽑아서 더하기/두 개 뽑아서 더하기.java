import java.util.*;
import java.util.stream.*;

class Solution {
    public List<Integer> solution(int[] numbers) {
        Set<Integer> answer = new HashSet<>();
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                answer.add(numbers[i] + numbers[j]);
            }
        }
        return answer.stream().sorted().collect(Collectors.toList());
    }
}