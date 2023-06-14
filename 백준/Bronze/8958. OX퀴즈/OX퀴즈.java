import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        while (num-- > 0) {
            String ans = br.readLine();
            char[] chars = new char[ans.length()];
            for (int j = 0; j < ans.length(); j++) {
                chars[j] = ans.charAt(j);
            }
            int sum = 0;
            int score = 0;
            for (char a : chars) {
                if (a == 'O') {
                    score++;
                    sum += score;
                } else {
                    score = 0;
                }
            }
            bw.write(sum + "\n");
        }

        bw.flush();
        bw.close();
    }
}