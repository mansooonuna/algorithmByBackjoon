import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 수학
 * 이분 탐색
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long rs = (long) Math.sqrt(N);

        if (rs * rs < N) rs++;

        System.out.println(rs);
    }
}