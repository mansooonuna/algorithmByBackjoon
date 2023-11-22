import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        int zeroCnt = 0;
        int oneCnt = 0;

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input == 1) oneCnt++;
            else if (input == 0) zeroCnt++;
            else if (input > 1) plus.add(input);
            else minus.add(input);
        }

        int result = 0;
        // 양수 두 개씩 묶어서 계산 먼저
        while (plus.size() >= 2) {
            result += plus.poll() * plus.poll();
        }

        if (!plus.isEmpty()) result += plus.poll();

        // 음수 두 개씩 묶어서 계산
        while (minus.size() >= 2) {
            result += minus.poll() * minus.poll();
        }

        if (zeroCnt > 0 && !minus.isEmpty()) {
            while (zeroCnt != 0) {
                minus.poll();
                zeroCnt--;
            }
        }

        if (!minus.isEmpty() && zeroCnt == 0) result += minus.poll();

        // 나머지 1
        result += oneCnt;
        
        System.out.println(result);
    }
}

/*
반례 답 : 8 / 출력 : 7
7
3
2
1
1
0
0
-3
 */