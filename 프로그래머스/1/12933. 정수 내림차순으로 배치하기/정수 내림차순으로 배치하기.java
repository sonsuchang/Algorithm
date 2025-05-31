import java.util.*;

class Solution {
    public long solution(long n) {
        String[] strList = String.valueOf(n).split("");
        Arrays.sort(strList, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String str : strList) {
            sb.append(str);
        }
        return Long.parseLong(sb.toString());
    }
}