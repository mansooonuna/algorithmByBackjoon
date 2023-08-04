import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sensor = new int[N];
        for (int i = 0; i < N; i++) {
            sensor[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sensor);

        int[] minus = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            minus[i] = sensor[i + 1] - sensor[i];
        }
        Arrays.sort(minus);

        int minSum = 0;
        for (int i = 0; i < N - K; i++) {
            minSum += minus[i];
        }
        System.out.println(minSum);
    }
}