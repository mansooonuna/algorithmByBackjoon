import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int max = 0;
        int[] trees = new int[N];
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, trees[i]);
        }

        long res = Integer.MIN_VALUE;
        for (int cutLength = 1; cutLength <= max; cutLength++) {
            long sum = 0;
            for (int j = 0; j < N; j++) {
                int cut = 0;
                if (trees[j] >= cutLength) {
                    if (trees[j] % cutLength == 0) cut = trees[j] / cutLength - 1;
                    else cut = trees[j] / cutLength;

                    int cost = W * cutLength * (trees[j] / cutLength) - cut * C;
                    if (cost > 0) sum += cost;
                }
            }
            res = Math.max(res, sum);
        }
        System.out.println(res);
    }

}
/*
K * L * W - (C * 자른 횟수)


비용 1 / 판매 10
trees {26, 103, 59}

cutLength = 6
26 -> 6 * 4 * 10 - 4 * 1 = 236
103 -> 6 * 17 * 10 - 17 * 1 = 1003
59 -> 6 * 9 * 10 - 9 * 1 = 531
 */