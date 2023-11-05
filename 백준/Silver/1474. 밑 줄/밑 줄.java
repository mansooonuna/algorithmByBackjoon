import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<String> arr = new ArrayList<>();
        int totalLength = 0;
        for (int i = 0; i < n; i++) {
            arr.add(br.readLine());
            totalLength += arr.get(i).length();
        }

        int blank = m - totalLength; // 필요한 _의 개수

        if (blank > 0) {
            int c = blank / (n - 1); // 각 단어 사이에 공통으로 들어갈 _의 개수
            int k = blank % (n - 1); // 공통 밑줄 제외, 추가로 필요한 _의 개수

            String addUnderBar = ""; // 공통 밑줄
            while (c > 0) {
                addUnderBar += '_';
                c--;
            }

            for (int i = 0; i < n - 1; i++) {
                if (k > 0) { // 추가 밑줄 먼저
                    // 다음 단어의 첫 글자가 소문자인 경우 -> 밑줄이 소문자보다 우선이라서 소문자로 시작하는 단어 앞쪽에 밑줄 추가
                    if (arr.get(i + 1).charAt(0) <= 'z' && arr.get(i + 1).charAt(0) >= 'a') {
                        arr.set(i, arr.get(i) + '_');
                        k--;
                    }
                    // 추가로 분배해야하는 '_'가 남은 단어의 개수보다 많거나 같은 경우 -> 뒤쪽부터 밑줄 추가
                    else if (k >= n - 1 - i) {
                        arr.set(i, arr.get(i) + '_');
                        k--;
                    }
                }
                arr.set(i, arr.get(i) + addUnderBar);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String str : arr) {
            sb.append(str);
        }
        System.out.println(sb);
    }

}