import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int length = arr.length;
        if (length == 1) {
            answer.add(-1);
        }
        else {
            int temp = Arrays.stream(arr).min().getAsInt();
            for (int i = 0; i < length; i++) {
                if (temp != arr[i]) {
                    answer.add(arr[i]);
                }
            }
        }
        return answer;
    }
}