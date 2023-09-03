import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            arr.add(input.charAt(i) - '0');
        }
        arr.sort((o1, o2) -> o2 - o1);

        StringBuilder sb = new StringBuilder();
        for (Integer integer : arr) {
            sb.append(integer);
        }
        System.out.println(sb);
    }
}