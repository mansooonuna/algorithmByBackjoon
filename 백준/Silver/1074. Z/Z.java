import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int size = 1;
    static int N, row, col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        size = (int) Math.pow(2, N);

        // 위치 체크 용도
        int count = 0;
        int x = 0;
        int y = 0;

        while (size > 0) {
            size /= 2;
            
            // 1사분면
            if (row < x + size && col < y + size) { 
                count += 0;
            }
            
            // 2사분면
            else if (row < x + size) {            
                count += size * size;
                y += size;
            }
            
            // 3사분면
            else if (col < y + size) {            
                count += size * size * 2;
                x += size;
            }
            
            // 4사분면
            else {                                
                count += size * size * 3;
                x += size;
                y += size;
            }

            // size가 1이 되면 종료
            if (size == 1) {
                System.out.println(count);
                break;
            }
        }

    }

}
/*
N = 2
(3, 1) ?

 0   1   4  5
 2   3   6  7
 8   9  12 13
10 (11) 14 15

1. 1,2,3,4 사분면 중 어느 범위에 속해있는지 체크
2. 해당 사분면에서 재귀 탐색으로 카운트

0 16 32 48 // 0, 2^3 *2, *3
0 4 8 12 // 0, 2^2 *2, *3
 */