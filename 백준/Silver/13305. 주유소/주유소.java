import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] distances = new int[N - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            distances[i] = Integer.parseInt(st.nextToken());
        }

        int[] prices = new int[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            prices[i] = Integer.parseInt(st2.nextToken());
        }

        int rsPrice = 0;
        int minPrice = prices[0];
        for (int i = 0; i < N - 1; i++) {
            if (prices[i] < minPrice) minPrice = prices[i];
            rsPrice += minPrice * distances[i];
        }
        System.out.println(rsPrice);
    }
}