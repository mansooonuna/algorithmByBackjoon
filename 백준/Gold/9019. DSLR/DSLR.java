import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            bfs(A, B);
        }

        System.out.println(sb);
    }

    private static void bfs(int x, int y) {
        boolean[] visited = new boolean[10000];
        String[] cmd = new String[10000];
        Arrays.fill(cmd, "");

        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == y) {
                sb.append(cmd[cur]).append("\n");
                return;
            }

            int D_rs = D(cur);
            int S_rs = S(cur);
            int L_rs = L(cur);
            int R_rs = R(cur);

            if (!visited[D_rs]) {
                queue.add(D_rs);
                visited[D_rs] = true;
                cmd[D_rs] = cmd[cur] + "D";
            }

            if (!visited[S_rs]) {
                queue.add(S_rs);
                visited[S_rs] = true;
                cmd[S_rs] = cmd[cur] + "S";
            }

            if (!visited[L_rs]) {
                queue.add(L_rs);
                visited[L_rs] = true;
                cmd[L_rs] = cmd[cur] + "L";
            }

            if (!visited[R_rs]) {
                queue.add(R_rs);
                visited[R_rs] = true;
                cmd[R_rs] = cmd[cur] + "R";
            }

        }
    }

    private static int D(int x) {
        int ans = x * 2;
        if (ans > 9999) ans %= 10000;
        return ans;
    }

    private static int S(int x) {
        if (x == 0) return 9999;
        return x - 1;
    }

    private static int L(int x) {
        String str = Integer.toString(x);
        while (str.length() < 4) {
            str = "0" + str;
        }

        str = str.substring(1) + str.charAt(0);
        return Integer.parseInt(str);
    }

    private static int R(int x) {
        String str = Integer.toString(x);
        while (str.length() < 4) {
            str = "0" + str;
        }

        str = str.charAt(3) + str.substring(0, 3);
        return Integer.parseInt(str);
    }
}

/*
D : n * 2
S : n - 1
L : 1234 -> 2341
R : 1234 -> 4123

1234 -> L 2341 -> L 3412
1234 -> R 4123 -> R 3412

1000 -> L 0001

1 -> D 2 -> D 4 -> D 8 -> D 16
 */