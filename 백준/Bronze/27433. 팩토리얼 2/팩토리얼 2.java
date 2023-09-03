import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(factorial(Integer.parseInt(br.readLine())));
    }

    private static long factorial(int N) {
        if (N <= 1) return 1;
        else return factorial(N - 1) * N;
    }
}