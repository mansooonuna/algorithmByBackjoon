import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] questions = br.readLine().toCharArray();

        int B = 1;
        int R = 1;
        char c = 'a';
        for (int i = 0; i < N; i++) {
            if (questions[i] != c) {
                if (questions[i] == 'B') B++;
                else R++;
            }
            c = questions[i];
        }
        System.out.println(Math.min(B, R));
    }
}