import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st2.nextToken());

            if (binarySearch(A, num)) sb.append("1").append("\n");
            else sb.append("0").append("\n");
        }

        System.out.println(sb);
    }

    private static boolean binarySearch(int[] arr, int num) {
        int leftIdx = 0;
        int rightIdx = N - 1;

        while (leftIdx <= rightIdx) {
            int midIdx = (leftIdx + rightIdx) / 2;
            int mid = arr[midIdx];

            if (num < mid) rightIdx = midIdx - 1;
            else if (num > mid) leftIdx = midIdx + 1;
            else return true;
        }
        return false;
    }
}