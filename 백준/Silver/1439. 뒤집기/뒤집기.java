import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int flips = 0;
        for (int i = 1; i < input.length(); i++) {
            char prev = input.charAt(i - 1);
            char next = input.charAt(i);
            if (prev != next) {
                flips++;
            }
        }

        if (flips % 2 == 0) flips /= 2;
        else flips = (flips / 2) + 1;

        System.out.println(flips);
    }
}

/**
 * 0 덩어리 / 1 덩어리 중 더 적게 들어있는 덩어리 개수?
 * <p>
 * 111 0 11 0 1
 * flips = 4 (짝) -> flips / 2
 * <p>
 * 111 0 11 0
 * flips = 3 (홀) -> (flips / 2) + 1
 */