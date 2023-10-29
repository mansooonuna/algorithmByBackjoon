import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // N일 동안
        int M = Integer.parseInt(st.nextToken()); // M번 통장에서 출금
        int[] money = new int[N];
        int max = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, money[i]);
            sum += money[i];
        }

        int low = max;
        int high = sum;
        while (low < high) {
            int mid = (low + high) / 2;
            int total = 0;
            int withdrawCnt  = 1; // 인출 횟수 초기화

            for (int i : money) {
                if (total + i <= mid) total += i;
                else {
                    withdrawCnt++;
                    total = i; // 새로운 날 첫 번째 인출
                }
            }

            if (withdrawCnt <= M) high = mid; // M번 이하로 인출할 수 있으면 K 감소
            else low = mid + 1; // M번 초과하면 K 증가
        }

        System.out.println(low); // 최소 K
    }
}

/*
5 3
1000
2500
2000
3000
4000

1. 범위 설정: low는 4000 (최소 금액), high는 12500 (모든 금액의 합).
2. 중간값인 mid는 8250.
3. withdrawCnt와 total를 이용하여 각 날의 금액을 계산하면 withdraw_count는 2
   따라서 low를 8250으로 갱신.
4. 계속 반복해서 low와 high가 같아지면 최소 K
 */