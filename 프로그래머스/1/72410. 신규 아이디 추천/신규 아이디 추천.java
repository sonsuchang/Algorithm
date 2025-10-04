import java.util.*;

class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        String pos = "-_.";
        StringBuilder sb = new StringBuilder();
        int length = new_id.length();
        for (int i = 0; i < length; i++) {
            char c = new_id.charAt(i);
            int range = (int) c;
            if (c == '-' || c == '_' || c == '.' || (range <= 122 && range >= 97) ||
                (range <= 57 && range >= 48)) {
                sb.append(c);
            }
        }
        new_id = sb.toString();
        sb = new StringBuilder();
        length = new_id.length();
        for (int i = 0; i < length; i++) {
            char c = new_id.charAt(i);
            if (sb.length() == 0 && c == '.') continue;
            if (sb.length() == 0) {
                sb.append(c);
                continue;
            }
            if (sb.charAt(sb.length() - 1) == '.' && c == '.') continue;
            sb.append(c);
        }
        while (sb.length() > 1 &&
            sb.charAt(sb.length() - 1) == '.') sb.deleteCharAt(sb.length() - 1);
        while (sb.length() > 15) sb.deleteCharAt(sb.length() - 1);
        while (sb.length() > 1 &&
            sb.charAt(sb.length() - 1) == '.') sb.deleteCharAt(sb.length() - 1);
        if (sb.length() == 0) sb.append('a');
        while (sb.length() < 3) sb.append(sb.charAt(sb.length() - 1));
        return sb.toString();
    }
}