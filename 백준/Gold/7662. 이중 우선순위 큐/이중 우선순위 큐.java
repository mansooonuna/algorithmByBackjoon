import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                String[] inputs = br.readLine().split(" ");
                String cmd = inputs[0];
                switch (cmd) {
                    case "I":
                        int num = Integer.parseInt(inputs[1]);
                        map.put(num, map.getOrDefault(num, 0) + 1);
                        break;
                    case "D":
                        int cmdNum2 = Integer.parseInt(inputs[1]);
                        if (map.size() == 0) {
                            break;
                        } else {
                            int key = cmdNum2 == 1 ? map.lastKey() : map.firstKey();
                            int cnt = map.get(key);

                            if (cnt == 1) map.remove(key);
                            else map.put(key, cnt - 1);
                        }
                }
            }
            if (map.size() == 0) sb.append("EMPTY").append("\n");
            else sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
        }
        System.out.println(sb);
    }
}