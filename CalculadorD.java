import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class CalculadorD{



    public static void main(String[] args) {

        int porta = 4000;
        

        try {

            //RECEBE OBJETO

            ServerSocket server = new ServerSocket(porta); // porta de entrada
            System.out.println("Aguardando uma conexão ...");

            Socket socket = server.accept(); // recebe o pacote
            // a partir disso, ele abre o pacote e monta o objeto

            ObjectInputStream leitor = new ObjectInputStream(socket.getInputStream()); 

            System.out.println("Aguardando um objeto ...");

            Calculo c = (Calculo) leitor.readObject(); // lê o objeto
            c.imprime();

            socket.close();
            server.close();
            
            //CALCULA

            int m = c.m();
            int n = c.n();
            int x = c.k();

            double[][] matrixA = c.matrixA();
            double[][] matrixB = c.matrixB();
            double[][] matrixC = new double[m][n];

            System.out.println("m: " + m);
            System.out.println("n: " + n);
            System.out.println("x: " + x);
            System.out.println("inicio: " + c.inicio);
            System.out.println("fim: " + c.fim);

            //C = A * B

            int contador = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    
                    //matrixC[i][j] = 0;

                    for (int k = 0; k < x; k++) {
                        if(contador >= c.inicio && contador <= c.fim){

                            matrixC[i][j] = matrixA[i][k] * matrixB[k][j];

                        }
                        
                        
                    }
                    contador++;

                }

            }

                        //Printa matriz C
            System.out.print("\nMatriz C: ");
            for(int i=0; i<c.m(); i++){
                System.out.println();
                for(int j=0; j<c.n(); j++){
                    System.out.print(matrixC[i][j] + " ");
                }
            }

            //Resposta r = new Resposta(matrixC);
      
            //ENVIA OBJETO

            Socket s = new Socket("localhost", porta+20);

            ObjectOutputStream gravador = new ObjectOutputStream(s.getOutputStream());

            System.out.println("Enviando");

            gravador.writeObject(matrixC); // gera uma sequência de bytes

            System.out.println("Enviado!");
            s.close();


        } 
        catch (Exception e) {
            e.printStackTrace();
        }


    }






}