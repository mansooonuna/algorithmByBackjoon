import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String input = br.readLine();

        long ans = 0;
        long r_pow = 1;
        for (int i = 0; i < L; i++) {
            int alphabet = input.charAt(i) - 'a' + 1;
            ans += alphabet * r_pow;
            r_pow *= 31;
        }

        System.out.println(ans);
    }
}