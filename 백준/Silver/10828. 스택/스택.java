import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        MyStack stk = new MyStack();

        for (int i = 0; i < N; i++) {
            String cmd = br.readLine();

            switch (cmd) {
                case "pop":
                    bw.write(stk.pop() + "\n");
                    break;
                case "size":
                    bw.write(stk.size()+ "\n");
                    break;
                case "empty":
                    bw.write(stk.empty()+ "\n");
                    break;
                case "top":
                    bw.write(stk.top()+ "\n");
                    break;
                default:
                    String[] arr = cmd.split(" ");
                    stk.push(Integer.parseInt(arr[1]));
                    break;
            }
        }

        bw.flush();
        bw.close();
        br.close();


    }

}

class MyStack {
    ArrayList<Integer> MyStack = new ArrayList<>();

    void push(int x) {
        this.MyStack.add(x);
    }

    int pop() {
        if (!this.MyStack.isEmpty()) {
            int p = this.MyStack.get(this.MyStack.size() - 1);
            this.MyStack.remove(this.MyStack.size() - 1);
            return p;
        } else return -1;
    }

    int size() {
        return this.MyStack.size();
    }

    int empty() {
        if (this.MyStack.isEmpty()) return 1;
        else return 0;
    }

    int top() {
        if (this.MyStack.isEmpty()) return -1;
        else return this.MyStack.get(this.MyStack.size() - 1);
    }
}