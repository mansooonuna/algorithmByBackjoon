import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        dequeue dq = new dequeue();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "pop_front":
                    bw.write(dq.pop_front() + "\n");
                    break;
                case "pop_back":
                    bw.write(dq.pop_back() + "\n");
                    break;
                case "size":
                    bw.write(dq.size() + "\n");
                    break;
                case "empty":
                    bw.write(dq.empty() + "\n");
                    break;
                case "front":
                    bw.write(dq.front() + "\n");
                    break;
                case "back":
                    bw.write(dq.back() + "\n");
                    break;
                case "push_front":
                    dq.push_front(Integer.parseInt(st.nextToken()));
                    break;
                default:
                    dq.push_back(Integer.parseInt(st.nextToken()));
                    break;

            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

}

class dequeue {
    LinkedList<Integer> dequeue = new LinkedList<>();

    void push_front(int x) {
        this.dequeue.addFirst(x);
    }

    void push_back(int x) {
        this.dequeue.addLast(x);
    }

    int pop_front() {
        if (!this.dequeue.isEmpty()) {
            int first = this.dequeue.get(0);
            this.dequeue.remove(0);
            return first;
        }
        return -1;
    }

    int pop_back() {
        if (!this.dequeue.isEmpty()) {
            int last = this.dequeue.get(dequeue.size() - 1);
            this.dequeue.remove(dequeue.size() - 1);
            return last;
        }
        return -1;
    }

    int size() {
        return this.dequeue.size();
    }

    int empty() {
        if (this.dequeue.isEmpty()) {
            return 1;
        }
        return 0;
    }

    int front() {
        if (!this.dequeue.isEmpty()) {
            return this.dequeue.get(0);
        } else {
            return -1;
        }
    }

    int back() {
        if (!this.dequeue.isEmpty()) {
            return this.dequeue.get(this.dequeue.size() - 1);
        } else {
            return -1;
        }
    }
}