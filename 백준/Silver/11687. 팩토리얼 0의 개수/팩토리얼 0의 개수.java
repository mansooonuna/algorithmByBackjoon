import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        long start = 5;
        long end = 500000000;

        long answer = -1;

        while (start <= end) {
            long mid = (start + end) / 2;

            if (countFive(mid) >= M) {
                end = mid - 1;
                answer = mid;
            } else {
                start = mid + 1;
            }
        }

        if (answer == -1 || countFive(answer) != M) System.out.println(-1);
        else System.out.println(answer);
    }

    // 5의 배수 카운트
    private static long countFive(long num) {
        long count = 0;
        for (long i = 5; num / i >= 1; i *= 5) count += num / i;

        return count;
    }
}

/*
1! = 1
2! = 2 1 = 2
3! = 3 2 1 = 6
4! = 4 3 2 1 = 24
5! = 5 4 3 2 1 = 120 -> 끝의 0이 1개인 가장 작은 N
...
10! = 10 9 8 7 6 5 4 3 2 1 = 3628800 -> 끝의 0이 2개인 가장 작은 N

끝에 0이 오려면 5의 배수여야함
 */