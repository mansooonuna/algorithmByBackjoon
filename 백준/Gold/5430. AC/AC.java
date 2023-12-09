import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            String[] array = s.substring(1, s.length()-1).split(",");
            Deque<Integer> deque = new ArrayDeque<>();
            for (String num : array) {
                if (!num.equals("")) deque.add(Integer.parseInt(num));
            }
            boolean isReversed = false;
            boolean isError = false;
            for (char c : p.toCharArray()) {
                if (c == 'R') {
                    isReversed = !isReversed;
                } else {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (isReversed) deque.removeLast();
                    else deque.removeFirst();
                }
            }
            if (isError) {
                System.out.println("error");
            } else {
                StringBuilder sb = new StringBuilder("[");
                while (!deque.isEmpty()) {
                    sb.append(isReversed ? deque.pollLast() : deque.pollFirst());
                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]");
                System.out.println(sb);
            }
        }
    }
}