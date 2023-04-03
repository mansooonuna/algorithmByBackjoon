import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                char s = str.charAt(j);

                if (s == '(') {
                    stack.push(s);
                } else {
                    try {
                        stack.pop();
                    } catch (Exception e) {
                        stack.push('f');
                        break;
                    }
                }
            }
            if (stack.isEmpty()) {
                bw.write("YES" + "\n");
            } else {
                bw.write("NO" + "\n");
            }


        }

        bw.flush();
        bw.close();
        br.close();


    }
}