import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
//        Queue<String> queue = new LinkedList<>();
        List<String> list = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String[] cmd = br.readLine().split(" ");
            switch (cmd[0]) {
                case "push":
                    list.add(cmd[1]);
                    break;
                case "pop":
                    if (list.isEmpty()) {
                        bw.write("-1" + "\n");
                    } else {
                        bw.write(list.get(0) + "\n");
                        list.remove(list.get(0));
                    }
                    break;
                case "size":
                    bw.write(list.size() + "\n");
                    break;
                case "empty":
                    if (list.isEmpty()) bw.write("1" + "\n");
                    else bw.write("0" + "\n");
                    break;
                case "front":
                    if (list.isEmpty()) bw.write("-1" + "\n");
                    else bw.write(list.get(0) + "\n");
                    break;
                default:
                    if (list.isEmpty()) bw.write("-1" + "\n");
                    else bw.write(list.get(list.size() - 1) + "\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}