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

        //Output: Nx16 16xN = NxN

        do {
            N = scanner.nextInt();
            if (N > 0) invalidN = false;
            else {
                System.out.println("N is invalid please enter valid N");
                invalidN = true;
            }
        } while (invalidN);

        System.out.println("Entered N is " + N);

        int[][] A = new int[N][16];
        int[][] B = new int[16][N];

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("A.txt"));
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 16; j++) {
                    A[i][j] = random.nextInt(255);
                    bw.write(A[i][j]);
                }
                bw.write("\n");
            }
            bw.flush();

        } catch (IOException ex) {
            System.out.println("A problem on writing A to text file, " + ex.toString());
        }


        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("B.txt"));
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < N; j++) {
                    B[i][j] = random.nextInt(255);
                    bw.write(B[i][j]);
                }
                bw.write("\n");
            }
            bw.flush();

        } catch (IOException ex) {
            System.out.println("A problem on writing B to text file, " + ex.toString());
        }

        int[][] C = serialMultiMatrix(A, B);
        printMatrix(C, "C");


        String stringforPrint = "";

  /*      for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C[0].length; j++) {
                stringforPrint += String.valueOf(C[i][j]) + " ";
            }
            stringforPrint += "\n";
        }

        System.out.println("The matrix(C) has " + C.length + "x" + C[0].length);
        System.out.println(stringforPrint);
        */

    }


    public static int[][] serialMultiMatrix(int[][] matrix1, int[][] matrix2) {
        if (matrix1[0].length != matrix2.length) throw new IllegalArgumentException();
        int[][] C = new int[matrix1.length][matrix2[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix1[0].length; k++) {
                    C[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return C;
    }

    public static void printMatrix(int[][] matrix, String filename) {
        try {
            Random random = new Random();
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename + ".txt"));
            int matrixRow = matrix.length;
            int matrixcolumn = matrix[0].length;

            for (int i = 0; i < matrixRow; i++) {
                for (int j = 0; j < matrixcolumn; j++) {
                    bw.write(matrix[i][j]);
                }
                bw.write("\n");
            }
            bw.flush();

        } catch (IOException ex) {
            System.out.println("A problem on writing " + filename + " to text file, " + ex.toString());
        }
    }


}
