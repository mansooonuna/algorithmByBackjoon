import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        while (T-- > 0) {
            Map<String, Integer> HB = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                String type = input[1];

                HB.put(type, HB.getOrDefault(type, 0) + 1);
            }

            int ans = 1;
            for (Map.Entry<String, Integer> entry : HB.entrySet()) {
                ans *= entry.getValue() + 1;
            }
            ans -= 1;
            answer.append(ans).append("\n");
        }
        System.out.println(answer);
    }
}

/*
headgear 2
eyewear 1

2 + 1 + 2 * 1 = 5
 */