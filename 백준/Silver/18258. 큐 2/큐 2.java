import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        queue q = new queue();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "pop":
                    bw.write(q.pop() + "\n");
                    break;
                case "size":
                    bw.write(q.size() + "\n");
                    break;
                case "empty":
                    bw.write(q.empty() + "\n");
                    break;
                case "front":
                    bw.write(q.front() + "\n");
                    break;
                case "back":
                    bw.write(q.back() + "\n");
                    break;
                default:
                    q.push(Integer.parseInt(st.nextToken()));
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

}

class queue {
    LinkedList<Integer> q = new LinkedList<>();

    void push(int x) {
        this.q.add(x);
    }

    int pop() {
        if (!this.q.isEmpty()) {
            int first = this.q.get(0);
            this.q.remove(0);
            return first;
        }
        return -1;
    }

    int size() {
        return this.q.size();
    }

    int empty() {
        if (this.q.isEmpty()) {
            return 1;
        }
        return 0;
    }

    int front() {
        if (!this.q.isEmpty()) {
            return this.q.get(0);
        } else {
            return -1;
        }
    }

    int back() {
        if (!this.q.isEmpty()) {
            return this.q.get(this.q.size()-1);
        } else {
            return -1;
        }
    }
}