import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //예제 출력대로 구하기 위해 stringBuilder 생성
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            // T번 입력을 받아 st 사용하여 " " 기준 분리하여 변수 받아옴
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            // 두 수의 곱을 최대 공약수로 나누면 최소공배수
            sb.append((A * B) / gcd(A, B) + "\n");
        }

        System.out.println(sb);

    }

    /* 최대공약수 구하는 법 (Greatest Common Divisor)
       참고 : 유클리드 호제법
       a와 b의 최대공약수를 (a, b)라고 할 때, (a, b)의 최대공약수는 (b, r)의 최대공약수와 같다.
       여기서 r은 a에 b를 나눈 나머지를 의미한다.
     */
    public static int gcd(int a, int b) {
        while (b != 0) {
            // 나머지를 구하고
            int r = a % b;

            // (a,b) = (b,r)
            a = b;
            b = r;
        }
        return a;
    }
}