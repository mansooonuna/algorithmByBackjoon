import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        if (N % 2 == 0) {
            sb.append("1 2 ".repeat(Math.max(0, N / 2)));
        } else {
            for (int i = 0; i < (N / 2) + 1; i++) {
                if (i == (N / 2)) sb.append("3");
                else sb.append("1 2 ");
            }
        }

        System.out.println(sb);
    }
}

/**
 * 짝수일때, 1 2 1 2 ...
 * 홀수일때, 1 2 1 2 ... 3
 */