import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class CalculadorA{



    public static void main(String[] args) {

        int porta = 1000;
        

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

            


            //ENVIA OBJETO

            Socket s = new Socket("localhost", porta);

            ObjectOutputStream gravador = new ObjectOutputStream(s.getOutputStream());

            System.out.println("Enviando");

            gravador.writeObject(c); // gera uma sequência de bytes

            System.out.println("Enviado!");
            s.close();


        } 
        catch (Exception e) {
            e.printStackTrace();
        }


    }






}