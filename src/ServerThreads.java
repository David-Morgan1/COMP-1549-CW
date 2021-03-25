import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThreads extends Thread{

    private final Socket clientSocket;
    private final ArrayList IDArrayList;
    private final String readID;

    public ServerThreads(Socket clientSocket, ArrayList IDArrayList, String readID) {

        this.clientSocket = clientSocket;
        this.IDArrayList = IDArrayList;
        this.readID = readID;
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

        // Coordinator code
        Object coord = IDArrayList.get(0);
        Object firstcoord = coord;
        PrintWriter FirstCoordOut = new PrintWriter(new BufferedOutputStream(clientSocket.getOutputStream()), true);
        FirstCoordOut.println("The first Coordinator is:" + firstcoord);
        //IDArrayList.remove("Anum");
        while(!coord.equals(firstcoord)) {
            coord = IDArrayList.get(0);
            firstcoord = coord;
            PrintWriter CoordOut = new PrintWriter(new BufferedOutputStream(clientSocket.getOutputStream()), true);
            CoordOut.println("The New Coordinator is:" + firstcoord);
        }
        //End of coordinator code


        //This is the code initialised for the client to be able to print messages which
        //will be printed onto the interface with the "You typed:" and therefore echoing
        //the text string that the client is sending.

        //THIS IS START OF HADIL'S CODE
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String text;
        while( (text = reader.readLine()) !=null) {
            if ("quit".equalsIgnoreCase(text)) {
                IDArrayList.remove(readID);
                break;
            }
            String msg = "You typed: " + text + "\n";
            outputStream.write(msg.getBytes());
        }

        clientSocket.close();

        // this is the end of hadils code


        }
    }



