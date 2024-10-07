class Solution {
    public int solution(int n) {
        int[] continue_array = new int[10001];
        for (int i = 1; i < 10001; i++){
            continue_array[i] += 1;
            int temp = i;
            for (int j = i + 1; j < 10001; j++){
                temp += j;
                if (temp > 10000)
                    break;
                continue_array[temp] += 1;
            }
        }
        return continue_array[n];
    }
}