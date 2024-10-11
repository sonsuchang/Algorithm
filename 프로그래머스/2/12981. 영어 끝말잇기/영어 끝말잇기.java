import java.util.ArrayList;


class Solution {
    public ArrayList<Integer> solution(int n, String[] words) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        ArrayList<String> used_word = new ArrayList<String>();
        
        int len_words = words.length;
        
        for (int i = 0; i < len_words; i++){
            if (i == 0 && words[i].length() != 1){
                used_word.add(words[i]);
                continue;
            }
            int len_check_spell = words[i - 1].length() - 1;
            char check_spell = words[i - 1].charAt(len_check_spell);
            if (used_word.contains(words[i]) || words[i].charAt(0) != check_spell || words[i].length() == 1){
                if ((i + 1) % n == 0){
                    answer.add(n);
                    answer.add((i + 1) / n);
                }
                else{
                    answer.add((i + 1) % n);
                    answer.add((i + 1) / n + 1);
                }
                return answer;
            }
            else
                used_word.add(words[i]);
        }
        if (answer.isEmpty()){
            answer.add(0);
            answer.add(0);
        }
        return answer;
    }
}