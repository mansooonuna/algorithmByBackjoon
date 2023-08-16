import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 정렬
 * 이분 탐색
 */

public class Main {
    static int dot;
    static int line;
    static long[] dotList;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        dot = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        dotList = new long[dot];
        for (int i = 0; i < dot; i++) {
            dotList[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(dotList);

        for (int i = 0; i < line; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st3.nextToken());
            int end = Integer.parseInt(st3.nextToken());
            sb.append(binarySearch(start, end)).append("\n");
        }
        System.out.println(sb);
    }

    private static int binarySearch(int start, int end) {
        // start를 포함한 오른쪽 부분 인덱스
        int left = 0;
        int right = dotList.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (dotList[mid] > end) right = mid - 1;
            else left = mid + 1;

        }

        // end를 포함한 왼쪽 부분의 인덱스
        int endIdx = right + 1;
        left = 0;
        right = dotList.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (dotList[mid] < start) left = mid + 1;
            else right = mid - 1;

        }
        int startIdx = left;
        
        // endIdx - startIdx = 점으로 주어진 좌표상에서 선분 사이에 있는 점의 갯수
        return endIdx - startIdx;
    }
}