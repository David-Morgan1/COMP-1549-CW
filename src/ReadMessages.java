import java.io.*;
import java.net.*;

public class ReadMessages extends Thread{
    /**
     * This thread is responsible for reading server's input and printing it
     * to the console.
     * It runs in an infinite loop until the client disconnects from the server.
     *
     * @author www.codejava.net
     */

        private BufferedReader reader;
        private Socket clientSocket;
        private String readID;

        public ReadMessages(Socket clientSocket, String readID) {
            this.clientSocket = clientSocket;
            this.readID = readID;

            try {
                InputStream input = clientSocket.getInputStream();
                reader = new BufferedReader(new InputStreamReader(input));
            } catch (IOException ex) {
                System.out.println("Error getting input stream: " + ex.getMessage());
                ex.printStackTrace();
            }
        }

        public void run() {
            while (true) {
                try {
                    String response = reader.readLine();
                    System.out.println("\n" + response);

                    // prints the username after displaying the server's message
                    if (readID != null) {
                        System.out.print("[" + readID + "]: ");
                    }
                } catch (IOException ex) {
                    System.out.println("Error reading from server: " + ex.getMessage());
                    ex.printStackTrace();
                    break;
                }
            }
        }
    }

