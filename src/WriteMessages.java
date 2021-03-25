import java.io.*;
import java.net.*;
import java.util.ArrayList;

/**
 * This thread is responsible for reading user's input and send it
 * to the server.
 * It runs in an infinite loop until the user types 'quit' to quit.
 *
 * @author www.codejava.net
 */
public class WriteMessages extends Thread{

        private PrintWriter writer;
        private Socket clientSocket;
        private String readID;
        private ArrayList IDArrayList;

        public WriteMessages(Socket clientSocket, String readID, ArrayList IDArrayList) {
            this.clientSocket = clientSocket;
            this.readID = readID;
            this.IDArrayList = IDArrayList;

            try {
                OutputStream output = clientSocket.getOutputStream();
                writer = new PrintWriter(output, true);
            } catch (IOException ex) {
                System.out.println("Error getting output stream: " + ex.getMessage());
                ex.printStackTrace();
            }
        }

        public void run() {

            Console console = System.console();

            String userName = readID;
            //client.setUserName(userName); NOT SURE ABOUT THIS
            writer.println(userName);

            String text;

            do {
                text = console.readLine("[" + userName + "]: ");
                writer.println(text);

            } while (!text.equals("quit"));

            try {
                IDArrayList.remove(readID);
                clientSocket.close();
            } catch (IOException ex) {

                System.out.println("Error writing to server: " + ex.getMessage());
            }
        }
    }

