import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s= br.readLine();

        for (char c = 'a' ; c <= 'z'; c++){
            sb.append(s.indexOf(c) + " ");
        }
        System.out.println(sb);
        br.close();

    }
}