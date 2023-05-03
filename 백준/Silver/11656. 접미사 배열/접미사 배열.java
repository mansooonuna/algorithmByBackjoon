import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String inputStr = br.readLine();
        ArrayList<String> stringList = new ArrayList<>();
        for (int i = 0; i < inputStr.length(); i++) {
            stringList.add(inputStr.substring(i));
        }
        Collections.sort(stringList);

        for (String s : stringList) {
            bw.write(s + "\n");
        }

        bw.flush();
        bw.close();
        br.close();


    }

}