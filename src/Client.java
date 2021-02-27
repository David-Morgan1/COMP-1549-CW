import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            //code to connect the client's socket with the server socket
            System.out.println("Client has joined");
            Socket clientSocket = new Socket("localhost", 7000);

            //read message from the server
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            // system.in is used to read data from the keyboard
            //System.out.println("Start the chat: ");
            //String str = userInput.readLine();
            //PrintWriter out  = new PrintWriter(clientSocket.getOutputStream(), true);
            //out.println(str);

            // read the message the server has sent and display on the screen
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // will read the message from the socket's input stream
            System.out.println(in.readLine());

            // the client is expected to input its id
            // it then gets sent to the server that reads it
            // and stores it in the array list
            Scanner input = new Scanner(System.in);
            String ID = input.next();
            PrintWriter IDout = new PrintWriter(clientSocket.getOutputStream(), true);
            IDout.println(ID);
            System.out.println(ID);

            // Read Client input for Port Number
            BufferedReader PortIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println(PortIn.readLine());
            Scanner PortInput = new Scanner(System.in);
            String Port = PortInput.next();
            PrintWriter PortOut = new PrintWriter(clientSocket.getOutputStream(), true);
            PortOut.println(Port);
            System.out.println(Port);

            // Read Client input for IP address
            BufferedReader IPIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println(IPIn.readLine());
            Scanner IPInput = new Scanner(System.in);
            String IP = IPInput.next();
            PrintWriter IPOut = new PrintWriter(clientSocket.getOutputStream(), true);
            IPOut.println(IP);
            System.out.println(IP);

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}