import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 사람의 수
        int T = Integer.parseInt(br.readLine());

        // 각 사람이 돈을 인출하는데 걸리는 시간을 담을 배열
        int[] times = new int[T];
        // 시간의 합을 구할 변수
        int sum = 0;
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {
            times[i] = Integer.parseInt(st.nextToken()); // 3 1 4 3 2
        }
        // 배열 오름차순 정렬
        Arrays.sort(times); // 1 2 3 3 4

        // 먼저 누적된 합 + 다음 원소
        for (int i = 0; i < times.length; i++) {
            result += sum + times[i];
            sum += times[i];
        }

        System.out.println(result);

    }
}