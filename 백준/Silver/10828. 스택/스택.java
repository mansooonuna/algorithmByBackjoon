import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            String command = sc.nextLine();
            switch (command) {
                case "pop" :
                    if (stack.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(stack.pop() + "\n");
                    }
                    break;
                case "size" :
                    bw.write(stack.size() +"\n");
                    break;
                case "empty" :
                    if (stack.isEmpty()) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case "top" :
                    if (stack.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(stack.peek()+"\n");
                    }
                    break;
                default :
                    String[] array = command.split(" ");
                    int pushValue = Integer.parseInt(array[1]);
                    stack.push(pushValue);
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
