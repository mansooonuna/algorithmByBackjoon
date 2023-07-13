import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            String[] cmd = br.readLine().split(" ");
            switch (cmd[0]) {
                case "push":
                    stack.push(cmd[1]);
                    break;
                case "pop":
                    if (stack.isEmpty()) bw.write("-1" + "\n");
                    else bw.write(stack.pop() + "\n");
                    break;
                case "size":
                    bw.write(stack.size() + "\n");
                    break;
                case "empty":
                    if (stack.isEmpty()) bw.write("1" + "\n");
                    else bw.write("0" + "\n");
                    break;
                default:
                    if (stack.isEmpty()) bw.write("-1" + "\n");
                    else bw.write(stack.peek() + "\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}