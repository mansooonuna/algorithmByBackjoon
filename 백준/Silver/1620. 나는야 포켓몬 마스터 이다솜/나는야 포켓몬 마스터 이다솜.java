import java.util.*;
import java.io.*;

/**
 * 나는야 포켓몬 마스터 이다솜
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());        // 포켓몬의 개수
        int M = Integer.parseInt(st.nextToken());        // 내가 맞춰야 하는 문제의 개수

        Map<Integer, String> poketmonsInt = new HashMap<>();
        Map<String, Integer> poketmonsStr = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            poketmonsInt.put(i, name);
            poketmonsStr.put(name, i);
        }

        for (int i = 0; i < M; i++) {
            String question = br.readLine();

            if (isNum(question)) {
                bw.write(poketmonsInt.get(Integer.parseInt(question)) + "\n");
            } else {
                bw.write(poketmonsStr.get(question) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static boolean isNum(String str) {
        for (int i = 0; i < str.length(); i++) {
            if ( !Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}