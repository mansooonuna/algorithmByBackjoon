import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 강의의 수
        int M = Integer.parseInt(st.nextToken()); // 블루레이 갯수

        st = new StringTokenizer(br.readLine());

        int start = 0, end = 0;

        int[] lesson = new int[N];
        for (int i = 0; i < N; i++) {
            lesson[i] = Integer.parseInt(st.nextToken());
            end += lesson[i];
            if (lesson[i] > start) {
                start = lesson[i];
            }
        }

        int result = end;
        while (start <= end) {
            int mid = (start + end) / 2; // 현재 블루레이 최대 길이

            int count = 1; // 블루레이 갯수
            int sum = 0; // 현재까지 녹화된 강의 길이 합

            // 강의를 추가할지, 새로운 블루레이를 만들지
            for (int i = 0; i < N; i++) {
                if (sum + lesson[i] > mid) { // 새로운 블루레이 필요
                    sum = 0;
                    count++;
                }
                sum += lesson[i];
            }

            if (count <= M) {
                result = Math.min(result, mid);
                end = mid - 1; // 탐색 범위 감소 - 최대 범위 줄임
            } else {
                start = mid + 1; // 블루레이 갯수 많으니까 최소 범위 늘림
            }
        }
        System.out.println(result);
    }
}

/*
9 8 = 17
7 6 = 13
5 4 3 2 1 = 15
 */