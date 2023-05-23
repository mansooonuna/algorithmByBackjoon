import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();

        for (int i = 1; i <= 9; i++) {
            System.out.printf("%d * %d = %d", num, i, num * i);
            System.out.println();
        }
    }
}