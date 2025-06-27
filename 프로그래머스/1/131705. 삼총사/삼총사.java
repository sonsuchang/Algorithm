class Solution {
    public int solution(int[] number) {
        int answer = 0;
        int length = number.length;
        for (int i = 0; i < length - 2; i++) {
            int sum = number[i];
            for (int j = i + 1; j < length - 1; j++) {
                sum += number[j];
                for (int k = j + 1; k < length; k++) {
                    sum += number[k];
                    if (sum == 0) {
                        answer++;
                    }
                    sum -= number[k];
                }
                sum -= number[j];
            }
        }
        return answer;
    }
}