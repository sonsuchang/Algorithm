import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int[] dir = new int[6];
        int[] len = new int[6];

        int maxWidth = 0, maxHeight = 0;
        int maxWidthIdx = -1, maxHeightIdx = -1;

        for (int i = 0; i < 6; i++) {
            dir[i] = sc.nextInt();
            len[i] = sc.nextInt();

            if (dir[i] == 1 || dir[i] == 2) {
                if (len[i] > maxWidth) {
                    maxWidth = len[i];
                    maxWidthIdx = i;
                }
            }

            if (dir[i] == 3 || dir[i] == 4) {
                if (len[i] > maxHeight) {
                    maxHeight = len[i];
                    maxHeightIdx = i;
                }
            }
        }

        int smallWidth = Math.abs(len[(maxWidthIdx + 5) % 6] - len[(maxWidthIdx + 1) % 6]);
        int smallHeight = Math.abs(len[(maxHeightIdx + 5) % 6] - len[(maxHeightIdx + 1) % 6]);

        int area = (maxWidth * maxHeight) - (smallWidth * smallHeight);

        System.out.println(area * K);
    }
}
