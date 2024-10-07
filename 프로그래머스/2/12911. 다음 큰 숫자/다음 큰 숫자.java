class Solution {
    public int solution(int n) {
        int answer = 0;
        String s = Integer.toBinaryString(n);
        int len_s = s.length();
        int s_one_cnt = s.length() - s.replace("1", "").length();
        for (int i = n + 1; i < 1000001; i++){
            String s_temp = Integer.toBinaryString(i);
            int s_temp_one_cnt = s_temp.length() - s_temp.replace("1", "").length();
            if (s_one_cnt == s_temp_one_cnt){
                answer = i;
                break;
            }
        }
        return answer;
    }
}