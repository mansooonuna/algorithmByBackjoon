import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            int n = sc.nextInt();

            System.out.println(hotel(h, n));
        }

    }

    public static int hotel(int h, int n) {
        int result = ((n-1) / h) + 1;
        int remain = 0;
        if (n % h == 0) {
            remain = h * 100;
        } else {
            remain = (n % h) * 100;
        }

        return result + remain;
    }
}