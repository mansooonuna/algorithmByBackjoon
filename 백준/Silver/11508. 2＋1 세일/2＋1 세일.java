import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Integer[] prices = new Integer[N];
        for (int i = 0; i < N; i++) {
            prices[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(prices, Collections.reverseOrder());

        int sum = 0;

        for (int i = 1; i <= N; i++) {
            if (i % 3 != 0) { 
                sum += prices[i - 1];
            }
        }

        System.out.println(sum);
    }
}