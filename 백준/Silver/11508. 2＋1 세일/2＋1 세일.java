import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Integer[] milkPrice = new Integer[N];
        for (int i = 0; i < N; i++) milkPrice[i] = Integer.parseInt(br.readLine());
        Arrays.sort(milkPrice, Collections.reverseOrder());

        int minPrice = 0;
        for (int i = 1; i <= N; i++) if (i % 3 != 0) minPrice += milkPrice[i - 1];
        
        System.out.println(minPrice);
    }
}