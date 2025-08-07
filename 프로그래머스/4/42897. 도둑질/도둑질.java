/*
Solution.
1. 인접한 집은 접근이 제한되므로 이전까지의 maxDp vs 이전전 + 현재 값 비교
2. 첫번째 집과 마지막 집은 인접이므로 첫번째 집을 들렸을 때 vs 안들렸을 때 분기 나누기
*/

import java.io.*;
import java.util.*;

class Solution {
    
    static int N;
    static int[] dpZero, dpOne;
    
    public int solution(int[] money) {
        
        N = money.length;
        
        dpZero = new int[N + 1];
        dpOne = new int[N];
        
        dpZero[0] = 0;
        dpZero[1] = 0;
        
        for(int i = 1; i < N; i++){
            dpZero[i + 1] = Math.max(dpZero[i], dpZero[i - 1] + money[i]);
        }
        
        dpOne[0] = 0;
        dpOne[1] = money[0];
        
        for (int i = 1; i < N - 1; i++) {
            dpOne[i + 1] = Math.max(dpOne[i], dpOne[i - 1] + money[i]);
        }
        
        return Math.max(dpZero[N], dpOne[N - 1]);
    }
}