import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N];
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(score);

        int noCount = (int) Math.round(N * 0.15);
        double sum = 0;
        for (int i = noCount; i < N - noCount ; i++) {
            sum += score[i];
        }
        int average = (int) Math.round(sum / (N - 2 * noCount));
        System.out.println(average);
    }
}