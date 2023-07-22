import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<Integer, String> poketmonsInt = new HashMap<>();
        Map<String, Integer> poketmonsStr = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            poketmonsInt.put(i+1, name);
            poketmonsStr.put(name, i+1);
        }
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if (isNum(input)) {
                sb.append(poketmonsInt.get(Integer.parseInt(input))).append("\n");
            } else {
                sb.append(poketmonsStr.get(input)).append("\n");
            }
        }
        System.out.println(sb);
    }

    static boolean isNum(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}