import java.io.*;
import java.util.HashMap;
import java.util.TreeSet;

public class Main {

    static int N, M;
    static HashMap<Integer, Integer> allProblem = new HashMap<>();

    static class Problem implements Comparable<Problem> {
        int level;
        int num;

        public Problem(int level, int num) {
            this.level = level;
            this.num = num;
        }

        @Override
        public int compareTo(Problem o) {
            if (this.level != o.level) return Integer.compare(this.level, o.level);
            return Integer.compare(this.num, o.num);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        TreeSet<Problem> problems = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            int num = Integer.parseInt(s[0]);
            int level = Integer.parseInt(s[1]);
            problems.add(new Problem(level, num));
            allProblem.put(num, level);
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] s = br.readLine().split(" ");

            if (s[0].equals("add")) {
                int num = Integer.parseInt(s[1]);
                int level = Integer.parseInt(s[2]);

                if (allProblem.containsKey(num)) {
                    problems.remove(new Problem(level, num));
                    allProblem.put(num, level);
                } else {
                    problems.add(new Problem(level, num));
                    allProblem.put(num, level);
                }

            } else if (s[0].equals("recommend")) {
                if (s[1].equals("1")) {
                    sb.append(problems.last().num).append("\n");
                } else {
                    sb.append(problems.first().num).append("\n");
                }
            } else {
                int num = Integer.parseInt(s[1]);
                int level = allProblem.get(num);
                problems.remove(new Problem(level, num));
                allProblem.remove(num);
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}
