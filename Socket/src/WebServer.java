import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        while (true){
            Socket s = ss.accept();
            byte[] buffer = new byte[1024];
            int tam = s.getInputStream().read(buffer);
            String req = new String(buffer, 0, tam);
            String[] linhas = req.split("\n");
            String[] primeira = linhas[0].split(" ");
            System.out.println("COMANDO = "+ primeira[0]);
            System.out.println("DOCUMENTO = "+ primeira[1]);
            System.out.println(req);
            System.out.println("\n----------------------\n\n");
            s.getOutputStream().write(("HTTP/1.1 200 OK\nContent-Type: text/html charset=UTF-8\n\n" + "<html><body><h3>Olá</h3></body></html>").getBytes());
            s.close();
        }
    }
}
