import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            //code to connect the client's socket with the server socket
            System.out.println("Client Started");
            Socket soc = new Socket("localhost", 7000);

            ArrayList<String> IDArrayList = new ArrayList<String>();
            Scanner input = new Scanner(System.in);
            System.out.print("Enter UserID:");
            String UserID = input.next();
            while (IDArrayList.contains(UserID)) {
                System.out.print("ID has already been used. Enter another:");
                UserID = input.next();
            }
            IDArrayList.add(UserID);
            System.out.println(IDArrayList);

            //write and send a message to the server
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            // system.in is used to read data from the keyboard
            System.out.println("Enter a string: ");
            String str = userInput.readLine();
            PrintWriter out  = new PrintWriter(soc.getOutputStream(), true);
            out.println(str);

            // read the message the server has sent and display on the screen
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            // will read the message from the socket's input stream
            System.out.println(in.readLine());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}