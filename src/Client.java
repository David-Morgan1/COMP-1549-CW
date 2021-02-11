import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            // Making the ArrayList
            ArrayList<String> IDArrayList = new ArrayList<String>();
            //code to connect the client's socket with the server socket
            System.out.println("Client Started");
            Socket soc = new Socket("localhost", 7000);

            //write and send a message to the server
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            // system.in is used to read data from the keyboard
            Scanner input = new Scanner(System.in);
            System.out.print("Enter your ID:");
            // This reads what was inputted by the user in the line above
            String UserID = input.next();
            // Adds the ID to the ArrayList
            IDArrayList.add(UserID);
            // output check that the UserID has been appended to list.
            System.out.println("UserID Array list is:" + IDArrayList);
            // checking to see User input has been acknowledged
            System.out.println("Your ID is:" + UserID);
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
