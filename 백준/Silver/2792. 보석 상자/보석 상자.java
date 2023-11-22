import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 아이들 수
        int M = Integer.parseInt(st.nextToken()); // 색상 수

        PriorityQueue<Integer> gems = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            gems.add(Integer.parseInt(br.readLine()));
        }

        int left = 1;
        int right = Collections.max(gems); // 최대 질투심

        while (left <= right) {
            int mid = (left + right) / 2; // 한 학생에게 줄 보석의 개수
            int student = 0; // mid 개의 보석을 가진 학생은 몇 명?

            for (int gem : gems) {
                student += gem / mid;

                if (gem % mid != 0) student++; // 한 학생은 같은 색상의 보석만 같도록 해야 함
            }

            if (student > N) left = mid + 1;
            else right = mid - 1;
        }

        System.out.println(left);
    }
}