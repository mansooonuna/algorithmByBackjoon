import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] balloons = new int[N];
        int maxHeight = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            balloons[i] = Integer.parseInt(st.nextToken());
            maxHeight = Math.max(maxHeight, balloons[i]);
        }

        int[] arrows = new int[maxHeight + 1]; // idx에 떠있는 화살의 수
        int neededArrow = 0;
        for (int balloon : balloons) {
            // 해당 위치에 이미 화살이 있다
            if (arrows[balloon] > 0) {
                arrows[balloon]--; // 현재 위치 화살 없애고
                arrows[balloon - 1]++; // 현재 위치 -1 에 화살 추가함
            }
            else {
                arrows[balloon - 1]++; // 풍선이 터졌으니 현재 위치 -1 에 화살 추가
                neededArrow++; // 새로운 활을 던짐
            }
        }

        System.out.println(neededArrow);
    }
}

/*
예를들어, arrows[idx] = idx위치에 떠있는 화살의 수 라고 할때...
문제의 예제 1번 입력의 경우

2 1 5 4 3

첫번째 풍선이 2번 위치에 있으므로, 2번위치에 화살을 던져 풍선을 터트린다.
풍선을 터트린 화살은 높이가 1 낮아져 1번 위치에 남아있게 되고,
arrows배열은 arrows[1] = 1 로 변하게 된다.

두번째 풍선이 1번 위치에 있으므로 1번위치에 화살을 던져야하는데, 이미 1번위치에는 화살이 존재한다.
따라서, 추가적인 화살을 던지지않고, 두번째 풍선을 터트린후
arrows[1] = 0, arrows[0] = 1로 변하게 된다.

세번재 풍선이 5번 위치에 있는데, arrows[5] = 0 이므로, 화살을 던지지않으면 풍선을 터트릴 수 없다.
따라서, 추가적으로 화살을 던진후 arrows[4] = 1로 업데이트 해준다.

위 과정을 반복
 */