import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] stk = new int[N];
        int count = 1;

        for (int i = 0; i < stk.length; i++) {
            stk[i] = Integer.parseInt(br.readLine());
        }

        int max = stk[stk.length - 1];

        for (int i = stk.length - 2; i >= 0 ; i--) {
            if ( max < stk[i]) {
                count++;
                max = stk[i];
            }
        }

        System.out.println(count);

    }
}