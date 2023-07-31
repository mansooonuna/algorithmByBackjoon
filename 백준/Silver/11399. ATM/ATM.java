import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int totalTime = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] personTime = new int[N];
        for (int i = 0; i < N; i++) personTime[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(personTime);

        for (int i = 0; i < N; i++) {
            int tmp = N - i;
            totalTime += personTime[i] * tmp;
        }

        System.out.println(totalTime);
    }
}