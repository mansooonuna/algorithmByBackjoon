import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            if ('a' <= input[i] && input[i] <= 'z') {
                sb.append(String.valueOf(input[i]).toUpperCase());
            } else {
                sb.append(String.valueOf(input[i]).toLowerCase());
            }
        }

        System.out.println(sb);
    }
}