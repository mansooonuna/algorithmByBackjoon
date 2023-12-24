import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 이동하려고 하는 채널
        int M = Integer.parseInt(br.readLine()); // 고장난 버튼의 개수

        int min = Math.abs(N - 100); // 100번에서 움직이므로 최솟값 초기화

        int[] error = new int[M];
        if (M != 0) { // 고장난 버튼이 있는 경우
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                error[i] = Integer.parseInt(st.nextToken());
            }
        }

        // 고장난 버튼을 체크하는 배열을 선언
        boolean[] brokenButtons = new boolean[10];
        for (int i = 0; i < M; i++) {
            brokenButtons[error[i]] = true;
        }

        // 번호를 입력하는 방법에 따른 최소 이동 횟수 탐색
        for (int i = 0; i <= 1000000; i++) {
            int curChannel = i;
            int length = possible(curChannel, brokenButtons); // c 채널이 가능한지 검사

            if (length > 0) { // 가능한 채널이라면
                int press = Math.abs(curChannel - N); // 이동하려는 채널과의 차이를 구함
                min = Math.min(min, length + press); // 최소 이동 횟수를 업데이트
            }
        }

        System.out.println(min);
    }

    // 주어진 채널이 선택 가능한지 판단하고, 가능하면 버튼을 눌러야하는 횟수를 반환함
    public static int possible(int channel, boolean[] brokenButtons) {
        if (channel == 0) { // 0번 채널이 선택 가능한지?
            return brokenButtons[0] ? 0 : 1;
        }
        int pressCnt = 0;
        while (channel > 0) {
            if (brokenButtons[channel % 10]) { // 고장난 버튼이 포함되어 있다면
                return 0; // 선택 불가능
            }
            pressCnt += 1; // 버튼 누르는 횟수 추가
            channel /= 10; // 다음 자릿수 검사
        }
        return pressCnt; // 눌러야하는 횟수 반환
    }
}

/*
5457
3
6 7 8

100번 -> 5457번
1. 차이를 구함 : 5457 - 100 = 5357
2. 5455 (4번)
3. + + (2번)
 */