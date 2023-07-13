import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> inputStk = new Stack<>();
        int start = 0;
        while (N-- > 0) {
            int value = Integer.parseInt(br.readLine());
            if (value > start) {
                for (int i = start + 1; i <= value; i++) {
                    inputStk.push(i);
                    sb.append("+" + "\n");
                }
                start = value;
            } else if (inputStk.peek() != value) {
                System.out.println("NO");
                return;
            }
            inputStk.pop();
            sb.append("-" + "\n");
        }
        System.out.println(sb);
    }
}