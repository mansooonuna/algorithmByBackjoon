import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        TreeSet<Problem> treeSet = new TreeSet<>();
        Map<Integer, TreeSet<Problem>> algoTreeSet = new HashMap<>();
        Map<Integer, Integer> levelMap = new HashMap<>();
        Map<Integer, Integer> algoMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int questionNumber = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            int algorithm = Integer.parseInt(st.nextToken());
            treeSet.add(new Problem(questionNumber, level, algorithm));

            if (algoTreeSet.containsKey(algorithm)) {
                TreeSet<Problem> tmp = algoTreeSet.get(algorithm);
                tmp.add(new Problem(questionNumber, level, algorithm));
                algoTreeSet.replace(algorithm, tmp);
            } else {
                TreeSet<Problem> tmp = new TreeSet<>();
                tmp.add(new Problem(questionNumber, level, algorithm));
                algoTreeSet.put(algorithm, tmp);
            }

            levelMap.put(questionNumber, level);
            algoMap.put(questionNumber, algorithm);
        }

        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            String[] inputs = br.readLine().split(" ");
            String cmd = inputs[0];
            switch (cmd) {
                case "recommend":
                    int G = Integer.parseInt(inputs[1]);
                    int x1 = Integer.parseInt(inputs[2]);
                    if (x1 == 1) sb.append(algoTreeSet.get(G).last().p).append("\n");
                    else sb.append(algoTreeSet.get(G).first().p).append("\n");
                    break;

                case "recommend2":
                    int x = Integer.parseInt(inputs[1]);
                    sb.append(x == 1 ? treeSet.last().p : treeSet.first().p).append("\n");
                    break;

                case "recommend3":
                    int x2 = Integer.parseInt(inputs[1]);
                    int L = Integer.parseInt(inputs[2]);
                    if (x2 == 1) {
                        if (treeSet.ceiling(new Problem(0, L, 0)) == null) sb.append("-1").append("\n");
                        else sb.append(treeSet.ceiling(new Problem(0, L, 0)).p).append("\n");
                    } else {
                        if (treeSet.floor(new Problem(0, L, 0)) == null) sb.append("-1").append("\n");
                        else sb.append(treeSet.floor(new Problem(0, L, 0)).p).append("\n");
                    }
                    break;

                case "add":
                    int p = Integer.parseInt(inputs[1]);
                    int l = Integer.parseInt(inputs[2]);
                    int g = Integer.parseInt(inputs[3]);
                    treeSet.add(new Problem(p, l, g));

                    if (algoTreeSet.containsKey(g)) {
                        TreeSet<Problem> tmp = algoTreeSet.get(g);
                        tmp.add(new Problem(p, l, g));
                        algoTreeSet.replace(g, tmp);
                    } else {
                        TreeSet<Problem> tmp = new TreeSet<>();
                        tmp.add(new Problem(p, l, g));
                        algoTreeSet.put(g, tmp);
                    }
                    levelMap.put(p, l);
                    algoMap.put(p, g);
                    break;

                case "solved":
                    int p2 = Integer.parseInt(inputs[1]);
                    int l2 = levelMap.get(p2);
                    int g2 = algoMap.get(p2);

                    treeSet.remove(new Problem(p2, l2, g2));
                    algoTreeSet.get(g2).remove(new Problem(p2, l2, g2));
                    levelMap.remove(p2);
                    algoMap.remove(p2);
                    break;
            }
        }
        System.out.print(sb);
    }

    static class Problem implements Comparable<Problem> {
        public int p;
        public int l;
        public int g;

        public Problem(int questionNumber, int level, int algo) {
            this.p = questionNumber;
            this.l = level;
            this.g = algo;
        }

        @Override
        public int compareTo(Problem o) {
            if (l - o.l == 0) return p - o.p;
            else return l - o.l;
        }
    }
}