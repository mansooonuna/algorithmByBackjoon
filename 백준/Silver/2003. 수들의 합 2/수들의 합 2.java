import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        int sum = 0;
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        // 누적 합 계산
        for (int i = 1; i <= N; i++) {
            sum += Integer.parseInt(st2.nextToken());
            arr[i] = sum;
        }
        int count = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= N; j++) {
                if (arr[j] - arr[i - 1] == M) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}