import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /**
         * t(1)=t(0)*t(0)=1
         * t(2)=t(0)*t(1)+t(1)*t(0)=2
         * t(3)=t(0)*t(2)+t(1)*t(1)+t(2)*t(0)=5
         *
         * t(n-1) = t(0)*t(n-2) + t(1)*t(n-3) + ... + t(n-2)*t(n-1)
         * t(n)=t(0)*t(n-1)+t(1)*t(n-2)+...+t(n-1)*t(0)
         */
        int n = Integer.parseInt(br.readLine());
        // int 의 범위를 넘어선 값을 가질 수 있어서 long 형 배열 선언
        // 배열의 크기를 n으로 설정하면 ArrayIndexOutOfBound
        long[] dp = new long[n+1];
        // 0 번째 배열 1로 초기화
        dp[0] = 1;
        // i 는 1부터 n-1까지
        for (int i = 1; i < dp.length; i++) {
            // j 는 0부터 i-1까지  
            for (int j = 0; j < i ; j++) {
                dp[i] += (dp[j] * dp[i - 1 - j]);
            }
        }

        System.out.println(dp[n]);

    }
}