import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Comparator.reverseOrder;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, reverseOrder());
        long totalTip = 0;
        for (int i = 0; i < N; i++) {
            long tip = arr[i] -i;
            if (tip < 0) tip = 0;

            totalTip += tip;
        }
        System.out.println(totalTip);
    }
}