import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int m, cakeCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 케이크 개수
        m = Integer.parseInt(st.nextToken()); // 컷팅 횟수

        List<Integer> tenCakes = new ArrayList<>();
        List<Integer> notTenCakes = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());

            if (tmp % 10 == 0) tenCakes.add(tmp);
            else notTenCakes.add(tmp);
        }

        tenCakes.sort((o1, o2) -> o1 - o2);

        for (Integer tenCake : tenCakes) {
            if (tenCake == 10) cakeCnt++;
            else cutCake(tenCake);
        }

        if (m > 0) {
            for (Integer notTenCake : notTenCakes) {
                cutCake(notTenCake);
            }
        }

        System.out.println(cakeCnt);
    }

    static void cutCake(int cake) {
        if (m <= 0 || cake < 10) return;
        else {
            cakeCnt++;
            m--;

            int remain = cake - 10;

            if (remain > 10) cutCake(remain);
            else if (remain == 10) {
                cakeCnt++;
                return;
            }

        }
    }
}