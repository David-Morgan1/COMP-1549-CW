
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.ArrayList;


public class Server {
    public static void main(String[] args) {
        //TODO auto generated method sub
        try {
            // code to connect the server socket with the client socket
            ServerSocket serverSocket = new ServerSocket(7000);

            //create an array list
            ArrayList IDArrayList = new ArrayList();

            while(true) {
                System.out.println("Waiting for client...");
                Socket clientSocket = serverSocket.accept();

                //send the client a message to input their id
                //and read the id, then store it in the array list
                PrintWriter IDout = new PrintWriter(new BufferedOutputStream(clientSocket.getOutputStream()), true);
                IDout.println("Enter your ID: ");

                BufferedReader ID = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                clientSocket.getInputStream();
                String readID = ID.readLine();


                // code to check if the ID is in the array list
                // if it is then the client has to enter another name
                while (IDArrayList.contains(readID)) {
                    IDout.println("ID has already been used. enter another one: ");
                    clientSocket.getInputStream();
                    readID = ID.readLine();
                }

                System.out.println(readID);
                IDArrayList.add(readID);
                System.out.println(IDArrayList);

                //Print a line Statement which infers on which client just connected
                System.out.println("Connection Established from " + clientSocket);

                //Refactored time into a new method.
                //Everytime a connection is established from a client
                //a new thread is made.
                //Within the new thread, the "HandleClientSocket" method
                //is there to call the connection of the "clientSocket"

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


            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    private static void handleClientSocket(Socket clientSocket) throws IOException, InterruptedException {
        OutputStream outputStream = clientSocket.getOutputStream();
        for(int i=0; i< 10; i++) {
            Thread.sleep(1000);
        }
    }
}
