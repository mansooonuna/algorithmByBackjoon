import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken()); // 시장에서 사온 파
        int C = Integer.parseInt(st.nextToken()); // 주문 받은 파닭

        int[] lick = new int[S];
        long totalLick = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < S; i++) {
            lick[i] = Integer.parseInt(br.readLine());
            totalLick += lick[i];
            max = Math.max(max, lick[i]);
        }

        long left = 1;
        long right = max;

        long maxLength = 0;
        while (left <= right) {
            long mid = (left + right) / 2;

            int chicken = 0; // 현재 파로 만들 수 있는 파닭 개수 담을 변수

            for (int i = 0; i < S; i++) {
                chicken += lick[i] / mid;
            }

            if (chicken >= C) {
                maxLength = mid;
                left = mid + 1;
            } else right = mid - 1;
        }

        System.out.println(totalLick - (C * maxLength));
    }
}