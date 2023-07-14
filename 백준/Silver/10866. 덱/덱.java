import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Deque<String> dequeue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push_front":
                    dequeue.addFirst(st.nextToken());
                    break;
                case "push_back":
                    dequeue.addLast(st.nextToken());
                    break;
                case "pop_front":
                    if (dequeue.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(dequeue.pollFirst()).append("\n");
                    break;
                case "pop_back":
                    if (dequeue.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(dequeue.pollLast()).append("\n");
                    break;
                case "size":
                    sb.append(dequeue.size()).append("\n");
                    break;
                case "empty":
                    if (dequeue.isEmpty()) sb.append("1").append("\n");
                    else sb.append("0").append("\n");
                    break;
                case "front":
                    if (dequeue.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(dequeue.peekFirst()).append("\n");
                    break;
                case "back":
                    if (dequeue.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(dequeue.peekLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}