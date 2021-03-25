import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Server {
    private static String StringUtils;

    public static void main(String[] args) {
        //TODO auto generated method sub
        try {
            // code to connect the server socket with the client socket
            ServerSocket serverSocket = new ServerSocket(7000);

            //create an array list
            ArrayList IDArrayList = new ArrayList();

            while (true) {
                //This will be displayed on the Server until the connection is established
                System.out.print("Waiting for client...");
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
                while(IDArrayList.contains(readID)) {
                    IDout.println("ID has already been used. enter another one: ");
                    clientSocket.getInputStream();
                    readID = ID.readLine();
                }

                System.out.println(readID);
                IDArrayList.add(readID);
                System.out.println(IDArrayList);

                // Asking User for Port Number input
                PrintWriter PortOut = new PrintWriter(new BufferedOutputStream(clientSocket.getOutputStream()), true);
                PortOut.println("Enter Port Number:");
                BufferedReader Port = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                clientSocket.getInputStream();
                // PORT NUMBER IS STORED IN 'readPort' variable
                String readPort = Port.readLine();

                while(!readPort.equals("7000")){
                    PortOut.println("Wrong Port Number inputted. Try Again: ");
                    clientSocket.getInputStream();
                    readPort = Port.readLine();
                }
                System.out.println(readPort);

                // Asking User for IP address input
                PrintWriter IPOut = new PrintWriter(new BufferedOutputStream(clientSocket.getOutputStream()), true);
                IPOut.println("Enter IP address:");
                BufferedReader IPaddress = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                clientSocket.getInputStream();
                //IP address IS STORED IN 'readIP' variable
                String readIP = IPaddress.readLine();
                System.out.println(readIP);


                //Print a line Statement which infers on which client just connected.
                //This is displayed on the Server
                System.out.println("Connection Established from " + IDArrayList);


                ServerThreads threads = new ServerThreads(clientSocket, IDArrayList, readID);
                threads.start();

                WriteMessages writemsgs = new WriteMessages(clientSocket, readID, IDArrayList);
                writemsgs.start();

                ReadMessages readmsgs = new ReadMessages(clientSocket, readID);
                readmsgs.start();




            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


}
