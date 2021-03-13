import java.io.*;
import java.net.Socket;
import java.util.Date;

public class ServerThreads extends Thread{

    private final Socket clientSocket;

    public ServerThreads(Socket clientSocket) {

        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            handleClientSocket();
        } catch (IOException e) {
            e.printStackTrace();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
    private void handleClientSocket() throws IOException, InterruptedException {
        InputStream inputStream = clientSocket.getInputStream();
        OutputStream outputStream = clientSocket.getOutputStream();

        //This is the code initialised for the client to be able to print messages which
        //will be printed onto the interface with the "You typed:" and therefore echoing
        //the text string that the client is sending.
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String text;
        while( (text = reader.readLine()) !=null) {
            if ("quit".equalsIgnoreCase(text)) {
                break;
            }
            String msg = "You typed: " + text + "\n";
            outputStream.write(msg.getBytes());
        }

        clientSocket.close();


        }
    }



