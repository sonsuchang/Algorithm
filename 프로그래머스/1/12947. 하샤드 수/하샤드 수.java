import java.util.*;

class Solution {
    public boolean solution(int x) {
        String s = String.valueOf(x);
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            temp += (s.charAt(i) - '0');
        }
        if (x % temp == 0) {
            return true;
        }
        return false;
    }
}