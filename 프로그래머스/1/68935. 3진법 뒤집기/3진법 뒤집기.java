import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int i = 1;
        while (i < n) {
            i *= 3;
        }
        if (i != n) {
            i /= 3;
        }
        ArrayList<Integer> convert = new ArrayList<>();
        while (i > 0) {
            convert.add(n / i);
            n = n % i;
            i /= 3;
        }
        i = 1;
        for (int j : convert) {
            answer += (j * i);
            i *= 3;
        }
        return answer;
    }
}