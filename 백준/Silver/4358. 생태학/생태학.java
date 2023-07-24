import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        TreeMap<String, Integer> map = new TreeMap<>();
        int totalTrees = 0;

        String input;
        while ((input = br.readLine()) != null && input.length() != 0) {
            if (map.containsKey(input)) map.put(input, map.get(input) + 1);
            else map.put(input, 1);
            totalTrees++;
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            String treeName = list.get(i);
            double treeIdx = map.get(treeName);
            double ratio = treeIdx * 100 / totalTrees;

            sb.append(treeName).append(" ").append(String.format("%.4f", ratio)).append("\n");
        }
        System.out.println(sb);
    }
}