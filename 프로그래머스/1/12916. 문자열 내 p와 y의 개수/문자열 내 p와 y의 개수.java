class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int p = 0;
        int y = 0;
        for (int i = 0; i < s.length(); i++) {
            char check = s.charAt(i);
            if (check == 'p' || check == 'P')
                p += 1;
            else if (check == 'y' || check == 'Y')
                y += 1;
        }
        if (p != y)
            answer = false;
        return answer;
    }
}