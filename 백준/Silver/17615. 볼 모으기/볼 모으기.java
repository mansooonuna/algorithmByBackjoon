import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String balls = br.readLine();
        int red = 0;
        int blue = 0;
        for (int i = 0; i < N; i++) {
            if (balls.charAt(i) == 'R') red++;
            else blue++;
        }
        int rs = N;

        //1. 빨간 공 모두 왼쪽
        int continuous = 0;
        for (int i = 0; i < N; i++) {
            if (balls.charAt(i) == 'R') continuous++;
            else break;
        }
        rs = Math.min(rs, red - continuous);

        //2. 빨간 공 모두 오른쪽
        continuous = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (balls.charAt(i) == 'R') continuous++;
            else break;
        }
        rs = Math.min(rs, red - continuous);

        //3. 파란 공 모두 왼쪽
        continuous = 0;
        for (int i = 0; i < N; i++) {
            if (balls.charAt(i) == 'B') continuous++;
            else break;
        }
        rs = Math.min(rs, blue - continuous);

        //4. 파란 공 모두 오른쪽
        continuous = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (balls.charAt(i) == 'B') continuous++;
            else break;
        }
        rs = Math.min(rs, blue - continuous);

        System.out.println(rs);
    }
}
/*
1. 빨간 공 모두 왼쪽
2. 빨간 공 모두 오른쪽
3. 파란 공 모두 왼쪽
4. 파란 공 모두 오른쪽
중에 최소 이동 가능 횟수 출력

 1번 공부터 N번 공까지 연속되는 빨간/파랑색의 공 갯수 우선 구하고
 이것을 총 빨간/파랑 공에서 빼주면 움직여야 하는 공의 갯수임
 */