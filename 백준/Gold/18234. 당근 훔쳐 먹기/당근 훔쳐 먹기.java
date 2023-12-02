import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 당근 종류
        int T = Integer.parseInt(st.nextToken()); // 재배 일수

        List<Carrot> carrotList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            carrotList.add(new Carrot(a, b));
        }

        carrotList.sort(Comparator.comparingLong(o -> o.growth));

        long rs = 0;
        long feedDay = T - N; // 최대한 늦게 기다렸다가 수확하려고 최소 성장 일수 구하기
        for (Carrot carrot : carrotList) {
            rs += carrot.taste + (carrot.growth * feedDay);
            feedDay++;
        }

        System.out.println(rs);
    }
}

class Carrot {
    long taste, growth;

    public Carrot(long taste, long growth) {
        this.taste = taste;
        this.growth = growth;
    }
}
/*
3개 5일
1 3
3 7
2 9

1일 - 1 3 2 => 안먹음
2일 - 4 10 11 => 안먹어
3일 - (7) 17 20 => 7
4일 - 1 (24) 29 => 24
5일 - 4 3 (38) => 38

1. 영양제로 자랄 수 있는 크기가 큰 것을 늦게 먹어야 함
2. 당근을 먹지 않을 수도 있다

3. 성장률 기준 오름차순 정렬 - 최대한 늦게 수확
 */