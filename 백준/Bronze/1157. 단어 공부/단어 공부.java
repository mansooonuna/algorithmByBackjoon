import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().toUpperCase(); // MISSISSIPI

        int[] arr = new int[26];
        for (int i = 0; i < input.length(); i++) {
            arr[input.charAt(i) - 'A']++;
        }

        int max = 0;
        char ans = '?';
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                ans = (char) (i + 'A');
            } else if (arr[i] == max) {
                ans = '?';
            }
        }

        System.out.println(ans);

    }
}