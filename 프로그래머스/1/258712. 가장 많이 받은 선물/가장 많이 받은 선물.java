import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        Map<String, Integer> nameToIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nameToIndex.put(friends[i], i);
        }

        int[][] giftMap = new int[n][n];
        int[] given = new int[n];
        int[] received = new int[n];

        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            int giver = nameToIndex.get(parts[0]);
            int receiver = nameToIndex.get(parts[1]);
            giftMap[giver][receiver]++;
            given[giver]++;
            received[receiver]++;
        }

        int[] giftIndex = new int[n];
        for (int i = 0; i < n; i++) {
            giftIndex[i] = given[i] - received[i];
        }

        int[] nextMonthGifts = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                if (giftMap[i][j] > giftMap[j][i]) {
                    nextMonthGifts[i]++;
                } else if (giftMap[i][j] == giftMap[j][i]) {
                    if (giftIndex[i] > giftIndex[j]) {
                        nextMonthGifts[i]++;
                    }
                }
            }
        }

        int maxGift = 0;
        for (int cnt : nextMonthGifts) {
            maxGift = Math.max(maxGift, cnt);
        }

        return maxGift;
    }
}
