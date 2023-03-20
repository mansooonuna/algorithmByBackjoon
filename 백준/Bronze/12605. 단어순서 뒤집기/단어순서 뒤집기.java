import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String[] strings = str.split(" ");

            bw.write("Case #" + (i + 1) + ": ");

            for (int j = strings.length - 1; j >= 0; j--) {
                bw.write(strings[j] + " ");
            }
            bw.write("\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }
}