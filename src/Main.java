import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("A.txt"));
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 16; j++) {
                    A[i][j] = (char) random.nextInt(255);
                    bw.write(A[i][j]);
                }
            }
            bw.flush();

        } catch (IOException ex) {
            System.out.println("A problem on writing to text file, " + ex.toString());
        }
        ;

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("B.txt"));
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < N; j++) {
                    B[i][j] = (char) random.nextInt(255);
                    bw.write(B[i][j]);
                }
            }
            bw.flush();

        } catch (IOException ex) {
            System.out.println("A problem on writing to text file, " + ex.toString());
        }
        ;

    }

}
