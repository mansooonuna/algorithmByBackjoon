import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(1);
            return;
        }
        int term = 1; // 한 바퀴당 방의 차이
        int count = 2; // 첫 번째 바퀴 방의 개수 (1을 포함하므로 2로 초기화)

        while (N >= count) {
            count += term * 6; // 다음 바퀴 방의 개수를 더해줌
            term++; // 바퀴당 방의 차이 증가
        }

        System.out.println(term);
    }
}