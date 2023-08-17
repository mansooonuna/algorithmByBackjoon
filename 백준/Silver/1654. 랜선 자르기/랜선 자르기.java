import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // 랜선을 입력받아 정렬
        List<Integer> lan = new ArrayList<>();
        for (int i = 0; i < K; i++) lan.add(Integer.parseInt(br.readLine()));

        Collections.sort(lan);

        // 랜선의 시작점과 끝점
        long start = 1;
        long finish = lan.get(K - 1);

        // 끝점이 시작점보다 작을동안 반복
        while (start <= finish) {
            // 중간값 계산
            long mid = (start + finish) / 2;
            // N과 같아지면 멈출 count 
            long count = 0;

            // 랜선 길이 꺼내서 중간값으로 나눈 몫을 count에 저장
            for (Integer lanLength : lan) {
                count += lanLength / mid;
            }

            // count 값이 원하는 값보다 크거나 같으면 -> mid 길이로 만든 랜선이 N개 이상이됨
            // 탐색 범위를 큰 쪽으로 좁혀야해서 +1
            if ( count >= N) start = mid + 1;

            // count가 N보다 작으면 -> mid 길이로 만든 랜선 N개 못만듬
            // 탐색 범위를 작은 쪽으로 좁혀야해서 -1
            else finish = mid - 1;
        }
        // 끝점과 시작점이 만났을 때
        // 랜선을 나눌 수 있는 최댓값이 필요하므로 끝점 출력
        System.out.println(finish);
    }
}