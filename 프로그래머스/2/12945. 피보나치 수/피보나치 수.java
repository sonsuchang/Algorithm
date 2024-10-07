class Solution {
    public int solution(int n) {
        int[] new_array = new int[100001];
        new_array[0] = 0;
        new_array[1] = 1;
        for (int i = 2; i < 100001; i++){
            if (i > n)
                break;
            new_array[i] = (new_array[i - 1] + new_array[i - 2]) % 1234567;
        }
        return new_array[n];
    }
}