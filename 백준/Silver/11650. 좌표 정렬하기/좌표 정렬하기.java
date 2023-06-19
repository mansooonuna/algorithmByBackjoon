import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] nums = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            nums[i][0] = num;
            nums[i][1] = num2;
        }

        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1]; // x좌표가 같을 경우 y좌표로 정렬
                } else {
                    return o1[0] - o2[0]; // x좌표로 정렬
                }
            }
        });

        for (int i = 0; i < N; i++) {
            bw.write(nums[i][0] + " " + nums[i][1] + "\n");
        }
        bw.flush();
        bw.close();
    }
}