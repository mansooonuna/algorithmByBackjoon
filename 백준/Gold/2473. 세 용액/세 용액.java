import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] solutions = new long[N];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            solutions[i] = Long.parseLong(input[i]);
        }

        Arrays.sort(solutions);

        long minDiff = Long.MAX_VALUE;
        long[] result = new long[3];

        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                long sum = solutions[i] + solutions[left] + solutions[right];
                long absSum = Math.abs(sum);

                if (absSum < minDiff) {
                    minDiff = absSum;
                    result[0] = solutions[i];
                    result[1] = solutions[left];
                    result[2] = solutions[right];
                }

                if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        Arrays.sort(result);
        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }
}