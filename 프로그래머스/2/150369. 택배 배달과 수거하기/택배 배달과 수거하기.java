import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        
        long answer = 0;
        int dsum = 0;
        int didx = 0;
        int pidx = 0;
        int psum = 0;
        
        for (int i = 0; i < n; i++) {
            if (deliveries[i] > 0) {
                dsum += deliveries[i];
                didx = i;
            }
            if (pickups[i] > 0) {
                psum += pickups[i];
                pidx = i;
            }
        }
        while (dsum > 0 && psum > 0) {
            if (pidx == -1 || didx == -1) break;
            if (didx >= pidx) {
                answer += ((didx + 1) * 2);
            } else {
                answer += ((pidx + 1) * 2);
            }
            int now = cap;
            while (now > 0) {
                deliveries[didx] -= 1;
                now -= 1;
                if (deliveries[didx] == 0) {
                    for (int i = didx; i > -1; i--) {
                        if (deliveries[i] > 0) {
                            didx = i;
                            break;
                        }
                    }
                }
            }
            now = cap;
            while (now > 0) {
                pickups[pidx] -= 1;
                now -= 1;
                if (pickups[pidx] == 0) {
                    for (int i = pidx; i > -1; i--) {
                        if (pickups[i] > 0) {
                            pidx = i;
                            break;
                        }
                    }
                }
            }
            dsum -= cap;
            psum -= cap;
        }
        
        while (dsum > 0 && deliveries[didx] > 0) {
            answer += ((didx + 1) * 2);
            int now = cap;
            while (now > 0) {
                deliveries[didx] -= 1;
                now -= 1;
                if (deliveries[didx] == 0) {
                    for (int i = didx; i > -1; i--) {
                        if (deliveries[i] > 0) {
                            didx = i;
                            break;
                        }
                    }
                }
            }
            dsum -= cap;
        }
        
        while (psum > 0 && pickups[pidx] > 0) {
            answer += ((pidx + 1) * 2);
            int now = cap;
            while (now > 0) {
                pickups[pidx] -= 1;
                now -= 1;
                if (pickups[pidx] == 0) {
                    for (int i = pidx; i > -1; i--) {
                        if (pickups[i] > 0) {
                            pidx = i;
                            break;
                        }
                    }
                }
            }
            psum -= cap;
        }
        
        // System.out.println(dsum);
        // System.out.println(psum);
        // System.out.println(didx);
        // System.out.println(pidx);
        // System.out.println(Arrays.toString(deliveries));
        // System.out.println(Arrays.toString(pickups));
        return answer;
    }
}