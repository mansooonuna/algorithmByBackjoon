import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                case "push":
                    int X = Integer.parseInt(command[1]);
                    queue.offer(X);
                    break;
                case "pop":
                    if (!queue.isEmpty()) {
                        System.out.println(queue.poll());
                    } else {
                        System.out.println(-1);
                    }
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    System.out.println(queue.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    System.out.println(queue.isEmpty() ? -1 : queue.peek());
                    break;
                case "back":
                    if (!queue.isEmpty()) {
                        int last = 0;
                        for (int num : queue) {
                            last = num;
                        }
                        System.out.println(last);
                    } else {
                        System.out.println(-1);
                    }
                    break;
                default:
                    break;
            }
        }
    }
}