import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ServerThreads extends Thread{

    private final Socket clientSocket;
    private ArrayList<ServerThreads> threadList;
    public PrintWriter output;
    private final ArrayList IDArrayList;
    private final String readID;

    public ServerThreads(Socket clientSocket, ArrayList<ServerThreads> thread, ArrayList IDArrayList, String readID) {

        this.clientSocket = clientSocket;
        this.threadList = thread;
        this.IDArrayList = IDArrayList;
        this.readID =readID;
    }

    @Override
    public void run() {
        try {

            //Reading the input from Client
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            //returning the output to the client : true statement is to flush the buffer otherwise
            //we have to do it manually
            output = new PrintWriter(clientSocket.getOutputStream(), true);

            // Coordinator code
            Object coord = IDArrayList.get(0);
            Object firstcoord = coord;
            PrintWriter FirstCoordOut = new PrintWriter(new BufferedOutputStream(clientSocket.getOutputStream()), true);
            FirstCoordOut.println("The first Coordinator is:" + firstcoord);



            while(true) {
                String outputString = input.readLine();
                //if user types exit command
                if(outputString == null){
                    if (readID.equals(coord)){
                        IDArrayList.remove(readID);
                        printToALlClients(readID + " has left ");
                        printToALlClients("Please update your members list!");
                        Object newcoord = IDArrayList.get(0);
                        PrintWriter CoordOut = new PrintWriter(new BufferedOutputStream(clientSocket.getOutputStream()), true);
                        printToALlClients("The New Coordinator is:" + newcoord);
                        break;
                    }
                  else {
                        IDArrayList.remove(readID);
                        printToALlClients(readID + " has left ");
                        printToALlClients("Please update your members list!");
                        break;
                    }
                }

                else if (outputString.equals("exit") && readID.equals(coord)) {
                    IDArrayList.remove(readID);
                    printToALlClients(readID + " has left ");
                    printToALlClients("Please update your members list!");
                    Object newcoord = IDArrayList.get(0);
                    PrintWriter CoordOut = new PrintWriter(new BufferedOutputStream(clientSocket.getOutputStream()), true);
                    printToALlClients("The New Coordinator is:" + newcoord);
                    break;
                } else if (outputString.equals("exit") ){
                    IDArrayList.remove(readID);
                    printToALlClients(readID + " has left ");
                    printToALlClients("Please update your members list!");
                    break;

                }

                else {
                    String message = ("(" + readID + ")" + " message : ");

                }

                printToALlClients(outputString);
                //output.println("Server says " + outputString);
                System.out.println("Server received " + outputString);

            }


        } catch ( IOException e) {
            e.printStackTrace();
            System.out.println("Error occured " +e.getStackTrace());


        }

    }

    private void printToALlClients(String outputString) {
        for (ServerThreads sT: threadList) {
            sT.output.println(readID + " says : " + outputString);



        }
    }
}





