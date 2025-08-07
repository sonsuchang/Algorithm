/*
Solution.
1. 전체 arr의 길이가 N이라면 arr의 부분집합을 구한다.
    1 - a. (1) (2 ~ N) , (1 ~ 2) (3 ~ N) , ----
    1 - b. 각 부분집합 사이의 연산자에 따라 각 부분집합에서 구해야 하는 값들이 달라진다.
        ex) + 일 경우 앞 뒤 둘다 Max값을 가져오면 되지만 - 일 경우 앞은 Max 뒤는 Min value를 가져야 한다.
2. 1번을 바탕으로 Maxdp와 Mindp를 만들어 각 구간에 대한 값을 계산한다.
3. dp는 2차원 배열로 Maxdp[s][e]와 같이 원하는 구간에 대한 s와 e를 설정하고 계산한다.
*/


import java.io.*;
import java.util.*;

class Solution {
    
    static int N, length;
    static int[] operands;
    static String[] op;
    static int[][] maxDp, minDp;
    
    public int solution(String arr[]) {
        
        length = arr.length;
        N = (length + 1) / 2;
        
        operands = new int[N];
        op = new String[N - 1];
        maxDp = new int[N][N];
        minDp = new int[N][N];
        
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                operands[i / 2] = Integer.parseInt(arr[i]);
                Arrays.fill(maxDp[i / 2], Integer.MIN_VALUE);
                Arrays.fill(minDp[i / 2], Integer.MAX_VALUE);
            } else {
                op[i / 2] = arr[i];
            }
        }
        
        find(0, N - 1);
        
        return maxDp[0][N - 1];
    }
    
    public int find(int start, int end) {
        if(start == end) return operands[start];
        if(maxDp[start][end] != Integer.MIN_VALUE) return maxDp[start][end];

        int max = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            if (op[i].equals("+")) {
                max = Math.max(max, find(start, i) + find(i + 1, end));
            }
            else {
                max = Math.max(max, find(start, i) - findMin(i + 1, end));
            }
        }

        return maxDp[start][end] = max;

    }

    public int findMin(int start, int end) {
        if (start == end) return operands[start];
        if (minDp[start][end] != Integer.MAX_VALUE) return minDp[start][end];

        int min = Integer.MAX_VALUE;
        for(int i = start; i < end; i++) {
            if (op[i].equals("+")) {
                min = Math.min(min, findMin(start, i) + findMin(i + 1, end));
            }
            else {
                min = Math.min(min, findMin(start, i) - find(i + 1, end));
            }
        }

        return minDp[start][end] = min;
    }
}