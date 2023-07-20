import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        while(N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            list.add(new int[]{x - r, x + r}); // 시작점, 끝점 저장
        }

        // list 오름차순으로 정렬 (순서대로 비교하기 위함)
        list.sort((c1, c2) -> {
            if(c1[0] != c2[0]) return c1[0] - c2[0];
            return c1[1] - c2[1];
        });

        // prev = 이전 값을 담을 배열
        // 이전 원의 끝 위치 prev[1]와 현재 원의 시작 위치 ints[0]을 비교
        boolean isValid = true;
        int[] prev = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        for (int[] ints : list) {
            if(prev[1] >= ints[0] && prev[1] <= ints[1]) {
                isValid = false;
                break;
            }
            prev = ints;
        }
        System.out.println(isValid ? "YES" : "NO");
    }
}