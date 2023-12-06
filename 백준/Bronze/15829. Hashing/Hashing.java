import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static final int M = 1234567891;
    static final int r = 31;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String input = br.readLine();

        long answer = 0;
        long r_pow = 1;

        for (int i = 0; i < L; i++) {
            int alphabet = input.charAt(i) - 'a' + 1;
            answer = (answer + (alphabet * r_pow) % M) % M;
            r_pow = (r_pow * r) % M;
        }

        System.out.println(answer);
    }
}