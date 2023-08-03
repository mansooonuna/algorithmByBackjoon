import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] lossWeight = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lossWeight[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(lossWeight);

        long minLoss = 0;
        if (N % 2 == 0) {
            for (int i = 0; i < N / 2; i++) {
                minLoss = Math.max(lossWeight[i] + lossWeight[N - 1 - i], minLoss);
            }
        } else {
            minLoss = lossWeight[N - 1];
            for (int i = 0; i < (N - 1) / 2; i++) {
                minLoss = Math.max(lossWeight[i] + lossWeight[N - 2 - i], minLoss);
            }
        }

        System.out.println(minLoss);
    }
}