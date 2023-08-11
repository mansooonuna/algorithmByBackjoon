import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 자료 구조
 * 정렬
 * 이분 탐색
 * 해시를 사용한 집합과 맵
 */
public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        int[] have = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            have[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(have);

        M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st2.nextToken());

            if (binarySearch(have, num)) sb.append("1 ");
            else sb.append("0 ");
        }
        System.out.println(sb);
    }

    private static boolean binarySearch(int[] arr, int num) {
        int leftIdx = 0;
        int rightIdx = N - 1;

        while (leftIdx <= rightIdx) {
            int midIdx = (leftIdx + rightIdx) / 2;
            int mid = arr[midIdx];

            // 인자값 대소비교를 통해 비교해야하는 범위 줄여가는 과정
            if (num < mid) rightIdx = midIdx - 1;
            else if (num > mid) leftIdx = midIdx + 1;
                // num == mid -> 찾았다!
            else return true;
        }
        return false;
    }
}