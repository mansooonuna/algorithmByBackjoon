import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = Integer.MAX_VALUE;

        // 입력값을 "-" 기준으로 나눈다.
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        while (st.hasMoreTokens()) {
            int rs = 0;

            // 위에서 구분한 것을 "+" 기준으로 나눈다.
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");

            // 덧셈으로 구분한 것끼리 더하기
            while (st2.hasMoreTokens()) {
                rs += Integer.parseInt(st2.nextToken());
            }

            if (result == Integer.MAX_VALUE) {
                result = rs;
            } else {
                result -= rs;
            }

        }

        System.out.println(result);

    }
}