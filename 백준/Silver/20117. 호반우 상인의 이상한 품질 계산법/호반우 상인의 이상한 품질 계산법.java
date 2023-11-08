import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 호반우 개수
        int[] hoBanWoo = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            hoBanWoo[i] = Integer.parseInt(st.nextToken()); // 호반우 품질
        }
        Arrays.sort(hoBanWoo);

        int maxProfit = 0;
        // 가장 큰 수 절반
        for (int i = N - 1; i >= (N + 1) / 2; i--) {
            maxProfit += hoBanWoo[i];
        }

        maxProfit = (N % 2 == 0) ? maxProfit * 2
                : maxProfit * 2 + hoBanWoo[N / 2];
        System.out.println(maxProfit);
    }
}

/*
짝수 : 최대값 * 2
- 2 4 8 9
    2 8 = 16
    4 9 = 18 -> (34)

홀수 : 최대값 * 2 + 중간값
- 1 2 3 4 5
    5 1 -> 10
    4 2 -> 8
    + 3 = (21)
 */