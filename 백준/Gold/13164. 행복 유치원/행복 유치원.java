import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] children = new int[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) children[i] = Integer.parseInt(st2.nextToken());

        int totalPrice = 0;
        List<Integer> list = new ArrayList<>(N - 1);
        for (int i = 1; i < N; i++) {
            int price = children[i] - children[i - 1];
            list.add(price);
            totalPrice += price;
        }
        Collections.sort(list);

        for (int i = 0; i <= K - 2; i++) {
            totalPrice -= list.get(list.size() - 1 - i);
        }
        System.out.println(totalPrice);
    }
}