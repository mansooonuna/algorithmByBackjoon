import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] output = new int[N];
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) arr[i] = i + 1;

        permutation(arr, output, visited, 0, N, N);
    }

    // 순서를 지키면서 n 개중에서 r 개를 뽑는 경우
    static void permutation(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            print(output, r);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                permutation(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }

    static void print(int[] arr, int r) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) sb.append(arr[i]).append(" ");
        
        System.out.println(sb);
    }
}