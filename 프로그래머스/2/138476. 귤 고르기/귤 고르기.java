import java.util.Arrays;

class Solution {
    public int solution(int k, int[] tangerine) {
        Arrays.sort(tangerine);
        int len_tangerine = tangerine.length - 1;
        int[] cnt_array = new int[tangerine[len_tangerine] + 1];
        for (int i : tangerine){
            cnt_array[i] += 1;
        }
        Arrays.sort(cnt_array);
        int answer = 0;
        int idx = tangerine[len_tangerine];
        for (;idx >= 0; idx--){
            if (k - cnt_array[idx] > 0){
                k -= cnt_array[idx];
                answer += 1;
            }
            else{
                answer += 1;
                break;
            }
        }
        return answer;
    }
}