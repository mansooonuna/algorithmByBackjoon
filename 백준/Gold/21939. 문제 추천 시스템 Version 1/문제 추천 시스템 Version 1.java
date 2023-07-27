import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TreeSet<Problem> questions = new TreeSet<>((o1, o2) -> {
            if (o1.l == o2.l) {
                return o2.p - o1.p;
            }
            return o2.l - o1.l;
        });
        Map<Integer, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int questionNumber = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            questions.add(new Problem(questionNumber, level));
            map.put(questionNumber,level);
        }

        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            String[] inputs = br.readLine().split(" ");
            String cmd = inputs[0];
            switch (cmd) {
                case "recommend":
                    int x = Integer.parseInt(inputs[1]);
                    if (x == 1) {
                        sb.append(questions.first().p).append("\n");
                    } else if (x == -1) {
                        sb.append(questions.last().p).append("\n");
                    }
                    break;
                case "add":
                    int p = Integer.parseInt(inputs[1]);
                    int l = Integer.parseInt(inputs[2]);
                    questions.add(new Problem(p, l));
                    map.put(p,l);
                    break;
                case "solved":
                    int p2 = Integer.parseInt(inputs[1]);
                    questions.remove(new Problem(p2, map.get(p2)));
                    break;
            }
        }
        System.out.print(sb);
    }

    static class Problem {
        public int p;
        public int l;

        public Problem(int questionNumber, int level) {
            this.p = questionNumber;
            this.l = level;
        }
    }
}