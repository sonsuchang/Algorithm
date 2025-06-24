class Solution {
    private boolean isDigit(Character c) {
        if ((int) c >= 48 && (int) c <= 57) {
            return true;
        }
        return false;
    }
    
    public boolean solution(String s) {
        int length = s.length();
        if (!(length == 4 || length == 6)) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (!isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}