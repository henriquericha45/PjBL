import java.io.Serializable;

public class Calculo implements Serializable{

    double[][] matrixA;
    double[][] matrixB;

    int inicio;
    int fim;


    public Calculo(double[][] matrixA, double[][] matrixB, int inicio, int fim) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.inicio = inicio;
        this.fim = fim;
    }

    public void imprime(){
        System.out.println(inicio+" "+fim);

    }

    public int m(){
        return matrixA.length;
    }

    public int n(){
        return matrixB[0].length;
    }

    public int k(){
        return matrixB.length;
    }

    public double[][] matrixA(){
        return matrixA;
    }

    public double[][] matrixB(){
        return matrixB;
    }

    public int inicio(){
        return inicio;
    }

    public int fim(){
        return fim;
    }

}