import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 축제 기간
        int M = Integer.parseInt(st.nextToken()); // 채워야 하는 선호도의 합
        int K = Integer.parseInt(st.nextToken()); // 맥주 종류의 수

        List<Beer> beerList = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            beerList.add(new Beer(a, b));
        }

        // 도수가 낮고 선호도 높은 순으로 정렬
        beerList.sort(new Comparator<Beer>() {
            @Override
            public int compare(Beer o1, Beer o2) {
                if (o1.level == o2.level) return o2.like - o1.like;
                return o1.level - o2.level;
            }
        });

        PriorityQueue<Integer> likes = new PriorityQueue<>(); // 선호도 저장
        int totalLikes = 0; // 현재 선호도의 합
        int ans = -1;
        for (Beer beer : beerList) {
            likes.add(beer.like);
            totalLikes += beer.like;

            // 맥주는 하루에 한 병만 받을 수 있음
            if (likes.size() > N) totalLikes -= likes.poll();

            // 조건 충족
            if (likes.size() == N && totalLikes >= M) {
                ans = beer.level;
                break;
            }
        }
        System.out.println(ans);
    }
}

class Beer {
    int like, level;

    public Beer(int like, int level) {
        this.like = like;
        this.level = level;
    }
}

/*
정해진 기간 동안, 목표 선호도에 도달해야함
+ 낮은 도수, 높은 선호도 맥주 선택
 */