import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            arr[i] = input;
            sum += input;
        }
        Arrays.sort(arr);

        // 산술평균
        int avg = (int) Math.round((double) sum / N);

        // 중앙값
        int mid = arr[N / 2];

        // 최빈값
        int[] count = new int[8001]; // 수의 범위: -4000부터 4000까지
        int maxCount = 0;
        int mode = 0;
        boolean isSecond = false;
        for (int i : arr) {
            count[i + 4000]++;
            if (count[i + 4000] > maxCount) {
                maxCount = count[i + 4000];
                mode = i;
                isSecond = false;
            } else if (count[i + 4000] == maxCount && !isSecond) {
                mode = i;
                isSecond = true;
            }
        }

        // 범위
        int range = arr[N - 1] - arr[0];

        System.out.println(avg);
        System.out.println(mid);
        System.out.println(mode);
        System.out.println(range);
    }
}