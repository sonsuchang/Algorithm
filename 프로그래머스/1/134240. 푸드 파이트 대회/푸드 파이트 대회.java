class Solution {
    public String solution(int[] food) {
        String left = "";
        int length = food.length;
        for (int i = 1; i < length; i++) {
            StringBuilder temp = new StringBuilder();
            int range = food[i] / 2;
            for (int j = 0; j < range; j++) {
                temp.append(i);
            }
            left += temp.toString();
        }
        String right = new StringBuilder(left).reverse().toString();
        return left + "0" + right;
    }
}