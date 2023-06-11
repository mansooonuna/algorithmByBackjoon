import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int min = arr[0];
        for (int i : arr) {
            if (min >= i) min = i;
        }
        bw.write(min + " ");

        int max = arr[0];
        for (int i : arr) {
            if (max <= i) max = i;
        }
        bw.write(max + " ");

        bw.flush();
        bw.close();


    }
}