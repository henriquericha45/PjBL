import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

        Scanner t = new Scanner (System.in);

        int m = 4;
        int n = 2;
        int x = 2;

        int a[][] = new int[m][x];

        int b[][] = new int[x][n];

        int c[][] = new int[m][n];

        //Le a matriz A
        for(int i=0; i<m; i++){
            for(int j=0; j<x; j++){
                System.out.print("Insira a posicao " + (i+1) + " " + (j+1) + " da matriz A: ");
                a[i][j] = t.nextInt();
            }
        }

        //Le a matriz B
        System.out.println();
        for(int i=0; i<x; i++){
            for(int j=0; j<n; j++){
                System.out.print("Insira a posicao " + (i+1) + " " + (j+1) + " da matriz B: ");
                b[i][j] = t.nextInt();
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

        //C = A * C
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