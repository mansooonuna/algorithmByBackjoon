import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<String>[] answer = new ArrayList[11];

        for (int i = 0; i <= 10; i++) {
            answer[i] = new ArrayList<>();
        }

        answer[1].add("1");

        answer[2].add("1+1");
        answer[2].add("2");

        answer[3].add("1+1+1");
        answer[3].add("1+2");
        answer[3].add("2+1");
        answer[3].add("3");

        // 4부터 10까지 각 숫자를 1, 2, 3의 합으로 표현하는 방법
        for (int i = 4; i <= 10; i++) {
            for (int j = 1; j <= 3; j++) {
                // i - j를 1, 2, 3의 합으로 표현하는 방법의 앞에 j를 더해서 i를 만드는 방법을 탐색
                for (String s : answer[i - j]) {
                    answer[i].add(j + "+" + s);
                }
            }
        }

        if (answer[n].size() >= k) {
            sb.append(answer[n].get(k - 1)).append("\n");
        } else {
            sb.append(-1).append("\n");
        }

        System.out.println(sb);
    }
}

/*
1
1

2
1+1
2

3
1+1+1
1+2
2+1
3

4
1+1+1+1
1+1+2
1+2+1
1+3
2+1+1
2+2
3+1
 */