import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = convertWord(br.readLine());
        }

        Arrays.sort(words);

        int answer = 0;
        HashMap<String, Integer> counts = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = words[i];
            if (counts.containsKey(word)) {
                int count = counts.get(word);
                answer += count;
                counts.put(word, count + 1);
            } else {
                counts.put(word, 1);
            }
        }

        System.out.println(answer);
    }

    private static String convertWord(String word) {
        int[] alpha = new int[26];
        Arrays.fill(alpha, -1);
        char[] result = new char[word.length()];

        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (alpha[word.charAt(i) - 'a'] == -1) {
                alpha[word.charAt(i) - 'a'] = count++;
            }
            result[i] = (char) (alpha[word.charAt(i) - 'a'] + 'a');
        }

        return new String(result);
    }
}