import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 0; // 최댓값 초기화
        int maxIndex = 0; // 최댓값의 인덱스 초기화

        for (int i = 1; i <= 9; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num > max) {
                max = num;
                maxIndex = i;
            }
        }

        System.out.println(max); // 최댓값 출력
        System.out.println(maxIndex); // 최댓값의 인덱스 출력
    }
}