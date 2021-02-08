import javax.swing.*;

        public class gui {

            public static void main(String[] args) {

        JFrame window1 = new JFrame();
        JPanel panel = new JPanel();
        window1.setSize(300, 300);
        window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window1.setVisible(true);
        window1.add(panel);

        panel.setLayout(null);

        JLabel heading = new JLabel("How to connect to Server");
        heading.setBounds(40, 20, 500, 80);
        heading.setFont(heading.getFont().deriveFont(32.0f));
        heading.setLocation(530, 30);
        panel.add(heading);

        JLabel enterIP = new JLabel("Please enter your IP address:");
        enterIP.setBounds(80, 220, 400, 25);
        enterIP.setFont(heading.getFont().deriveFont(24.0f));
        panel.add(enterIP);

        JTextField IP_Input = new JTextField();
        IP_Input.setBounds(500, 220, 280, 25);
        panel.add(IP_Input);

        JButton registerBtn = new JButton("Register");
        registerBtn.setBounds(670, 280, 110, 40);
        registerBtn.setFont(heading.getFont().deriveFont(14.0f));
        panel.add(registerBtn);



    }
}
