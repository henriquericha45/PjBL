import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class CalculadorA{



    public static void main(String[] args) {

        int porta = 1000;
        

        try {
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
            // encerra


        } 
        catch (Exception e) {
            e.printStackTrace();
        }


    }






}