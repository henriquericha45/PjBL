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

}