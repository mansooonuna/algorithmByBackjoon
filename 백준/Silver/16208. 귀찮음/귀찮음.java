import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        int length = 0;
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            length += a[i];
        }

        Arrays.sort(a);

        int cost = 0;
        for (int i = n - 1; i >= 0; i--) {
            length -= a[i];
            cost += a[i] * length;
        }

        System.out.println(cost);
    }
}

/*
3 5 4 2
2 3 4 5
14

-> (5) / 9 => 45
-> (4) / 5 => 20
-> (3) / (2) => 6
 */