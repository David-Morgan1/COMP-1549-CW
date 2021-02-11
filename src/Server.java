package coursework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;


public class Server {
    public static void main(String[] args) {
        //TODO auto generated method sub
        try {
            // code to connect the server socket with the client socket
            ServerSocket serverSocket = new ServerSocket(7000);

            while(true) {
                System.out.print("Waiting for client...");

                Socket clientSocket = serverSocket.accept();

                //Print a line Statement which infers on which client just connected
                System.out.println("Connection Established from " + clientSocket);

                //Refactored time into a new method.
                //Everytime a connection is established from a client
                //a new thread is made.
                //Within the new thread, the "HandleClientSocket" method
                //is there to call the connection of the "clientSocket"
                //hhihihi
                //hellloooo test


                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            handleClientSocket(clientSocket);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();


                //read the string which the client has sent
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                // clientSocket.getInputStream() reads data from the sockets input stream
                String str = in.readLine();


                // send the same message back to the client
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println("Server says: " + str);


            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    private static void handleClientSocket(Socket clientSocket) throws IOException, InterruptedException {
        OutputStream outputStream = clientSocket.getOutputStream();
        for(int i=0; i< 10; i++) {
            outputStream.write(("Time now is " + new Date() + "\n").getBytes());
            Thread.sleep(1000);
        }
        clientSocket.close();
    }
}
