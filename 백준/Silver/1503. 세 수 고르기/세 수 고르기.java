import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int MAX = 1002;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] out = new boolean[MAX]; // 선택할 수 없는 자연수 표시

        if (M != 0) { // 집합의 크기 0일 수 있음
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int tmp = Integer.parseInt(st.nextToken());
                out[tmp] = true;
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int x = 1; x < MAX; x++) {
            if (out[x]) continue;
            for (int y = 1; y < MAX; y++) {
                if (out[y]) continue;
                for (int z = 1; z < MAX; z++) {
                    if (out[z]) continue;
                    answer = Math.min(answer, Math.abs(N - (x * y * z)));
                }
            }
            if (answer == 0) break; // 0은 최소임
        }

        System.out.println(answer);
    }
}
/*
1. x, y, z는 중복이 허용된다.
2. for문의 경계값을 전부 1000으로 설정하면 안된다
   이유는 x,y,z가 될 수 있는 수의 범위는 1000을 넘어설 수 있기 때문
   예를 들어 n이 1000이고 집합 S에 999와 1000을 만들 수 있는 수들이 전부 존재할때
   답은 |1000-1001| 이지만 for문의 경계값을 1000까지만 해놓으면 이상한 값을 도출하게 됨

ex1)
S = 2 4
가능한 수 : 1 3 5 6 7 8 ...
N = 4
 -> 1 3 1 (3)
 답 : 4 - 3 = 1
---
ex2)
S = 1
가능한 수 : 2 3 4 5 6 7 ...
N = 10
 -> 2 2 3 (12)
 답 : 10 - 12 = 2
---
ex3)
S = 1 2
가능한 수 : 3 4 5 6 7 8 ...
N = 10
 -> 3 3 3 (27)
 답 : 27 - 10 = 17

 */