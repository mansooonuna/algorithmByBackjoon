import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] costs = new int[N+1][3];
        int[][] dp = new int[1001][3];

        for (int i = 1; i < N+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int costOfRed = Integer.parseInt(st.nextToken());
            int costOfGreen = Integer.parseInt(st.nextToken());
            int costOfBlue = Integer.parseInt(st.nextToken());

            costs[i][0] = costOfRed;
            costs[i][1] = costOfGreen;
            costs[i][2] = costOfBlue;

            // dp[i][0] = Min(dp[i-1][1], dp[i-1][2]) + costs[i][0]
            // dp[i][1] = Min(dp[i-1][0], dp[i-1][2]) + costs[i][1]
            // dp[i][2] = Min(dp[i-1][0], dp[i-1][1]) + costs[i][2]

            if (i == 1) {
                dp[i][0] = costs[i][0];
                dp[i][1] = costs[i][1];
                dp[i][2] = costs[i][2];
                continue;
            }

            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + costs[i][2];
        }
        System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));



        /*
         3번만 돌리면됨 = N =4의 0, 1 ,2;

        26 40 83    [0,0][0,1][0,2]   [1,0] = min [0,1] [0,2]
        49 60 57    [1,0][1,1][1,2]
        13 89 99    [2,0][2,1][2,2]
                    [3,0][3,1][3,2]         ====================================저장한 상태에서 위로 계속 n=0이 될떄까지
                    [4,0][4,1][4,2]
                    [n,0][n,1][n,2]     ]
        fori T=1

        dp[T-1][0]    dp[T-1][1]   dp[T-1][2]
            26          40        44

        fori T=3

      1   dp[T-1][0]    dp[T-1][1]   dp[T-1][2]
            26          40              44
      2   dp[T-1][0]    dp[T-1][1]   dp[T-1][2]
            49          60              57
      3   dp[T-1][0]    dp[T-1][1]   dp[T-1][2]
            13          89              99
        if(T>3)

        for T j-2


        dp[n][0] = min (  [n-1, 1] + [ n+1 , 1 ]    [n-1, 2]+ [n+1, 1]           [n-1, 1]+[n+1, 2]     [n-1, 2]+[n+1, 2]    )
        dp[n][1] = min (  [n-1, 0] + [ n+1 , 2 ]    [n-1, 0]+ [n+1, 0]           [n-1, 2]+[n+1, 0]     [n-1, 2]+[n+1, 2]    )
        dp[n][2] = min (  [n-1, 1] + [ n+1 , 1 ]    [n-1, 0]+ [n+1, 0]           [n-1, 1]+[n+1, 0]     [n-1, 2]+[n+1, 1]    )

        sum += min( dp[n][0]  , dp[n][1] , dp[n,2] )



         [1,0] = (         [0 1]+[2 1]              [0 2]+[2 1]                  [0 1]+[2 2]          [0 2]+[2 2] )
         [n,0] = min (  [n-1, 1] + [ n+1 , 1 ]    [n-1, 2]+ [n+1, 1]           [n-1, 1]+[n+1, 2]     [n-1, 2]+[n+1, 2]             ) =안겹치고 작은 값?

         [1,1] =  (         [0 0]+[2 2]              [0 0]+[2 0]                  [0 2]+[2 0]          [0 2]+[2 2] )
         [n,1] = min (  [n-1, 0] + [ n+1 , 2 ]    [n-1, 0]+ [n+1, 0]           [n-1, 2]+[n+1, 0]     [n-1, 2]+[n+1, 2]             ) =안겹치고 작은 값?

         [1,2] =  (         [0 1]+[2 1]              [0 0]+[2 0]                  [0 1]+[2 0]          [0 2]+[2 1] )
         [n,2] = min (  [n-1, 1] + [ n+1 , 1 ]    [n-1, 0]+ [n+1, 0]           [n-1, 1]+[n+1, 0]     [n-1, 2]+[n+1, 1]             ) =안겹치고 작은 값?


         min 중에 (min)


         */
    }
}

/*
* [0, 39, 76, 108, 168, 148, 192, 190, 258, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, +901 more]*/