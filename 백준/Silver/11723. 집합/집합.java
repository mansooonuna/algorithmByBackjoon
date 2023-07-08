import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<String> S = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String cmd = br.readLine();
            String[] arr = cmd.split(" ");
            switch (arr[0]) {
                case "add":
                    if (S.contains(arr[1])) break;
                    else S.add(arr[1]);
                    break;
                case "remove":
                    if (!S.contains(arr[1])) break;
                    else S.remove(arr[1]);
                    break;
                case "check":
                    if (S.contains(arr[1])) bw.write(1 + "\n");
                    else bw.write(0 + "\n");
                    break;
                case "toggle":
                    if (S.contains(arr[1])) S.remove(arr[1]);
                    else S.add(arr[1]);
                    break;
                case "all":
                    S = new ArrayList<>();
                    for (int j = 1; j <= 20 ; j++) {
                        S.add(String.valueOf(j));
                    }
                    break;
                default:
                    S = new ArrayList<>();
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}