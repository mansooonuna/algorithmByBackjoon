import java.io.*;
import java.util.*;

/**
 * 손님의 등수는 바뀔 수 있다.
 * 그 때의 최댓값을 구해야한다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> tips = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            tips.add(Integer.parseInt(br.readLine()));
        }

        // 최댓값 구하기 위해 내림차순 정렬
        tips.sort(Collections.reverseOrder());

        long totalTip = 0;
        for (int i = 0; i < N; i++) {
            int realTip = tips.get(i) - i;
            if (realTip > 0) {
                totalTip += realTip;
            }
        }

        System.out.println(totalTip);

    }
}