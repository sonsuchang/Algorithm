import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            String binary = Long.toBinaryString(numbers[i]);
            
            int length = binary.length();
            int treeLen = 1;
            while (treeLen < length) {
                treeLen = treeLen * 2 + 1;
            }
            
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < treeLen - length; j++) {
                sb.append("0");
            }
            sb.append(binary);
            
            if (isValidBinaryTree(sb.toString())) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        
        return answer;
    }

    private boolean isValidBinaryTree(String binary) {
        return check(binary, 0, binary.length() - 1);
    }

    private boolean check(String binary, int left, int right) {
        if (left > right) return true;

        int mid = (left + right) / 2;
        char root = binary.charAt(mid);

        if (root == '0') {
            for (int i = left; i <= right; i++) {
                if (i == mid) continue;
                if (binary.charAt(i) == '1') return false;
            }
        }

        return check(binary, left, mid - 1) && check(binary, mid + 1, right);
    }
}
