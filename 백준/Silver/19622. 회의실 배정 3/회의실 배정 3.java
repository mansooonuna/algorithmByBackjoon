import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 회의 수

        int[] meetingPeople = new int[N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            meetingPeople[i] = Integer.parseInt(input[2]);
        }

        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                dp[i] = meetingPeople[i];
            } else if (i == 1) {
                dp[i] = Math.max(meetingPeople[i], dp[i - 1]);
            } else {
                dp[i] = Math.max(dp[i - 2] + meetingPeople[i], dp[i - 1]);
            }
        }

        System.out.println(dp[N - 1]);
    }
}

/*
dp[i] = i시간에 가능한 최대 인원 수
dp = 80 80 150 180 190 230

임의의 회의 K(1≤ K ≤ N)는 회의 K − 1과 회의 K + 1과는 회의 시간이 겹치고
다른 회의들과는 회의 시간이 겹치지 않는다!!!!
 */