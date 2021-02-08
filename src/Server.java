import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            // code to connect the server socket with the client socket
            System.out.print("Waiting for client...");
            ServerSocket ss = new ServerSocket(7000);
            Socket soc = ss.accept();
            System.out.println("Connection Established");

            //read the string which the client has sent
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
                // soc.getInputStream() reads data from the sockets input stream
            String str = in.readLine();

            // send the same message back to the client
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
            out.println("Server says: " + str);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
