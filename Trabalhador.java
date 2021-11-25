import java.io.ObjectOutputStream;
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

            Socket socket = new Socket("localhost", porta);

            ObjectOutputStream gravador = new ObjectOutputStream(socket.getOutputStream());

            System.out.println("Enviando");

            gravador.writeObject(c); // gera uma sequência de bytes

            System.out.println("Enviado!");
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
