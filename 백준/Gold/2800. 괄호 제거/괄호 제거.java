import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<int[]> indexes;
    static boolean[] check;
    static Set<String> answerList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Integer> stack = new Stack<>();
        indexes = new ArrayList<>();
        List<Character> charArr = new ArrayList<>();

        // 괄호 인덱스 짝짓기
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            charArr.add(c);
            if (c == '(') stack.push(i);
            else if (c == ')') {
                indexes.add(new int[]{stack.pop(), i});
            }
        }
        check = new boolean[input.length()];
        answerList = new HashSet<>();

        // 인덱스 배열 조합해서 제거
        comb(0, input.toCharArray());

        // 사전 순 출력
        List<String> sortedList = new ArrayList<>(answerList);
        Collections.sort(sortedList);
        StringBuilder ans = new StringBuilder();
        for (String answer : sortedList) {
            ans.append(answer).append("\n");
        }
        System.out.println(ans);
    }

    static void comb(int depth, char[] str) {
        if (depth == indexes.size()) {
            boolean f = false;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length; i++) {
                if (!check[i]) {
                    sb.append(str[i]);
                } else f = true;
            }
            if (f) {
                answerList.add(sb.toString());
            }
            return;
        }

        comb(depth + 1, str);

        int[] bracket = indexes.get(depth);
        check[bracket[0]] = true;
        check[bracket[1]] = true;
        comb(depth + 1, str);
        check[bracket[0]] = false;
        check[bracket[1]] = false;
    }
}