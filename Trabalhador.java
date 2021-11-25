import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Trabalhador extends Thread {

    Calculo c;
    int porta;

    public Trabalhador(Calculo c, int porta){

        this.c = c;
        this.porta = porta;

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
            
            ServerSocket server = new ServerSocket(1500); // porta de entrada
            System.out.println("Aguardando uma conexão ...");

            Socket s = server.accept(); // recebe o pacote
            // a partir disso, ele abre o pacote e monta o objeto

            ObjectInputStream leitor = new ObjectInputStream(s.getInputStream()); 

            System.out.println("Aguardando um objeto ...");

            Resposta r = (Resposta) leitor.readObject(); // lê o objeto
            

            s.close();
            server.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
