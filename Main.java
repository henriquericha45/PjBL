import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

        Scanner t = new Scanner (System.in);

        int m = 2;
        int n = 2;
        int x = 2;

        int a[][] = {{2,4}, {2,3}};

        int b[][] = {{3,1}, {7,5}};

        int c[][] = new int[m][x];

        for (int i= 0; i < 2; i++){
			System.out.println();
		for (int j= 0; j <2; j++){
			System.out.print ("Digite o elemento "+i+ " " +j+" da matriz a: ");
				a[i][j] = t.nextInt();
		}
	}

        for (int i= 0; i <2; i++){
                System.out.println();
            for (int j= 0; j <2; j++){
                System.out.print ("Digite o elemento "+i+ " " +j+ " da matriz b: ");
                    b[i][j] = t.nextInt();		
            }
        }
        for (int i=0; i < a[i][i]; i++){
                System.out.println();
            for (int j= 0; j < b[j][j]; j++){
                
                for (x= 0; x < a[j][j]; x++){
                    c[i][j] += a[i][x] * b[x][j];
                        System.out.print(c[i][j]);
                        System.out.print(" ");


                }
            }
        }
    }
}