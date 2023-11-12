import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int totalHeight = 0;
        int one = 0;
        int two = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());
            totalHeight += height;
            one += height % 2;
            two += height / 2;
        }

        if (totalHeight % 3 == 0 && one <= two) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

/*
1. 물뿌리개는 동시에 사용해야한다
2. +1 / +2

가능한 경우?
+1 2 3 4 5 6 ...
+2 4 6 8 10 12 ...
   6 9 12 15 18 ... => 나무의 합이 3의 배수

각 높이를 1과 2의 합의 개수로 표현한다면
1 - 1
2 - 2
3 - 2 1
4 - 2 2
5 - 2 2 1
6 - 2 2 2
...

=> 입력받은 높이를 1과 2로 변환해서 1-2를 짝지어 삭제
   모두 삭제 되었으면 YES 아니면 NO

1 - 
2 - 
3 - 
4 - 2 
5 - 2 2 
=> 2의 개수가 더 많을 경우, 2는 1로 나뉨 => 가능

 */