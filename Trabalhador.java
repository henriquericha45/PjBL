import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Semaphore;


public class Trabalhador extends Thread {

    Calculo c;
    int porta;
    Semaphore mutex;
    Semaphore barreira;
    double[][] matrixC;

    public Trabalhador(Calculo c, int porta, Semaphore mutex, Semaphore barreira, double[][] matrixC){

        this.c = c;
        this.porta = porta;
        this.mutex = mutex;
        this.barreira = barreira;
        this.matrixC = matrixC;

    }


    public void run() {
        
        try {

            //ENVIA OBJETO

            Socket socket = new Socket("localhost", porta);

            ObjectOutputStream gravador = new ObjectOutputStream(socket.getOutputStream());

            System.out.println("Enviando");

            gravador.writeObject(c); // gera uma sequência de bytes

            System.out.println("Enviado!");
            socket.close();


            //RECEBE OBJETO
            
            ServerSocket server = new ServerSocket(porta+20); // porta de entrada
            System.out.println("Aguardando uma conexão ...");

            Socket s = server.accept(); // recebe o pacote
            // a partir disso, ele abre o pacote e monta o objeto

            ObjectInputStream leitor = new ObjectInputStream(s.getInputStream()); 

            System.out.println("Aguardando um objeto ...");

            double[][] r = (double[][]) leitor.readObject(); // lê o objeto

            mutex.acquire();

            for(int i=0; i<c.m(); i++){
                for(int j=0; j<c.n(); j++){
                    if(r[i][j] != 0){
                        matrixC[i][j] = r[i][j];
                    }
                }
            }

            mutex.release();
            barreira.release();



            s.close();
            server.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
