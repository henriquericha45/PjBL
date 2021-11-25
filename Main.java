import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class Main {

    public static double getRandomNumber(){
        int max = 20;
        int min = 1;

        double x = (Math.random() * ((max - min) + 1)) + min;
        return x;
    }

	public static void main(String[] args) {

        Scanner t = new Scanner (System.in);
        Random r = new Random();

        int m = 4;
        int n = 4;
        int x = 4;

        double a[][] = new double[m][x];

        double b[][] = new double[x][n];

        double c[][] = new double[m][n];

        //Le a matriz A
        for(int i=0; i<m; i++){
            for(int j=0; j<x; j++){
                a[i][j] = t.nextDouble();
            }
        }

        //Le a matriz B
        for(int i=0; i<x; i++){
            for(int j=0; j<n; j++){
                b[i][j] = t.nextDouble();
            }
        }

        //Printa matriz A
        System.out.print("\nMatriz A: ");
        for(int i=0; i<m; i++){
            System.out.println();
            for(int j=0; j<x; j++){
                System.out.print(a[i][j] + " ");
            }
        }

        System.out.println();
        
        //Printa matriz B
        System.out.print("\nMatriz B: ");
        for(int i=0; i<x; i++){
            System.out.println();
            for(int j=0; j<n; j++){
                System.out.print(b[i][j] + " ");
            }
        }

        System.out.println();

        //C = A * B
        for (int i=0; i<m; i++) {
            for (int j=0; j<x; j++) {
                c[i][j] = 0;
                for (int k=0; k<n; k++) {
                    c[i][j] = c[i][j] + a[i][k] * b[k][j];
                }   
            }
        }

        //Printa matriz C
        System.out.print("\nMatriz C: ");
        for(int i=0; i<m; i++){
            System.out.println();
            for(int j=0; j<n; j++){
                System.out.print(c[i][j] + " ");
            }
        }


        t.close();
    }
}