import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N이 홀수일때 SK 승
        int N = Integer.parseInt(br.readLine());

        if (N % 2 == 1) System.out.println("SK");
        else System.out.println("CY");
    }
}