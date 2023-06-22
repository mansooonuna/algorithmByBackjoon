import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] ans = new int[M];
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st2.nextToken());
            for (int num1 : nums) {
                if (num == num1) {
                    ans[i] = 1;
                    break;
                }
            }
        }

        for (int num : ans) {
            bw.write(num + " ");
        }

        bw.flush();
        bw.close();
    }
}