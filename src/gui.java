import javax.sound.sampled.Port;
import javax.swing.*;
import java.awt.*;

public class gui {

            public static void main(String[] args) {

        JFrame window1 = new JFrame();
        JPanel panel = new JPanel();
        window1.setSize(750, 750);
        window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window1.setVisible(true);
        window1.setBackground(Color.blue);
        window1.add(panel);

        panel.setBackground(Color.pink);
        panel.setLayout(null);

        JLabel heading = new JLabel("Chat Application");
        heading.setBounds(40, 20, 500, 80);
        heading.setFont(heading.getFont().deriveFont(32.0f));
        heading.setLocation(600, 45);
        panel.add(heading);

        JLabel enterID = new JLabel("Client ID:");
        enterID.setBounds(1000, 180, 200, 25);
        enterID.setFont(heading.getFont().deriveFont(24.0f));
        panel.add(enterID);

        JTextField ID_Input = new JTextField();
        ID_Input.setBounds(1115, 180, 200, 25);
        panel.add(ID_Input);

        JLabel enterPort = new JLabel("Port Number:");
        enterPort.setBounds(600, 180, 200, 25);
        enterPort.setFont(heading.getFont().deriveFont(24.0f));
        panel.add(enterPort);

        JTextField Port_Input = new JTextField();
        Port_Input.setBounds(760, 180, 200, 25);
        panel.add(Port_Input);

        JLabel enterIP = new JLabel("IP address:");
        enterIP.setBounds(230, 180, 200, 25);
        enterIP.setFont(heading.getFont().deriveFont(24.0f));
        panel.add(enterIP);

        JTextField IP_Input = new JTextField();
        IP_Input.setBounds(370, 180, 200, 25);
        panel.add(IP_Input);

        JButton registerBtn = new JButton("Register");
        registerBtn.setBounds(1350, 180, 110, 30);
        registerBtn.setFont(heading.getFont().deriveFont(14.0f));
        registerBtn.setBackground(Color.lightGray);
        panel.add(registerBtn);



    }
}
