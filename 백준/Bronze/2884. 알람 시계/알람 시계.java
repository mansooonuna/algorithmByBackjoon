import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int timeMinute = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken()) - 45;
        if (timeMinute % 60 < 0) {
            timeMinute += 24 * 60;
        }
        System.out.println(timeMinute / 60 + " " + timeMinute % 60);
    }
}