import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int N;
        Random random = new Random();
        boolean invalidN = false;
        System.out.println("In a nano duration, Nx16 and 16xN matrices would be created, please enter N \n Note N must be greater than zero");
        Scanner scanner = new Scanner(System.in);

        do {
            N = scanner.nextInt();
            if (N > 0) invalidN = false;
            else {
                System.out.println("N is invalid please enter valid N");
                invalidN = true;
            }
        } while (invalidN);

        System.out.println("yey you did N is " + N);

        char[][] A = new char[N][16];
        char[][] B = new char[16][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 16; j++) {
                A[i][j] = (char) random.nextInt(255);
            }
        }

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < N; j++) {
                B[i][j] = (char) random.nextInt(255);
            }
        }

    }
}
