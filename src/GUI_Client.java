import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class GUI_Client extends JFrame {

    private JPanel contentPane;
    private JTextField ClientMessageInput;
    private JTextField IPInput;
    private JTextField ClientIDInput;
    private JTextField PortInput;

    /**
     * Launch the application
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI_Client frame = new GUI_Client();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public GUI_Client() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 695, 466);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.activeCaption);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel ChatPanel = new JPanel();
        ChatPanel.setBackground(UIManager.getColor("Button.light"));
        ChatPanel.setBounds(10, 103, 654, 277);
        contentPane.add(ChatPanel);

        JLabel IPLabel = new JLabel("IP Address");
        IPLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        IPLabel.setBounds(34, 68, 83, 25);
        contentPane.add(IPLabel);

        JLabel ClientLabel = new JLabel("Client ID");
        ClientLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        ClientLabel.setBounds(244, 75, 71, 13);
        contentPane.add(ClientLabel);

        JLabel PortLabel = new JLabel("Port Number");
        PortLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        PortLabel.setBounds(393, 75, 106, 13);
        contentPane.add(PortLabel);

        ClientMessageInput = new JTextField();
        ClientMessageInput.setBounds(10, 392, 543, 25);
        contentPane.add(ClientMessageInput);
        ClientMessageInput.setColumns(10);

        IPInput = new JTextField();
        IPInput.setBounds(115, 73, 119, 19);
        contentPane.add(IPInput);
        IPInput.setColumns(10);

        JButton btnLogin = new JButton("LOGIN");
        btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnLogin.addActionListener(new ActionListener() {

            // action listener for the Login Button
            public void actionPerformed(ActionEvent e) {
                String IP = IPInput.getText();
                String ID= ClientIDInput.getText();
                String Port = PortInput.getText();

                System.out.println(IP+ID+Port);



            }
        });
        btnLogin.setBounds(563, 68, 101, 25);
        contentPane.add(btnLogin);

        ClientIDInput = new JTextField();
        ClientIDInput.setBounds(312, 72, 71, 19);
        contentPane.add(ClientIDInput);
        ClientIDInput.setColumns(10);

        PortInput = new JTextField();
        PortInput.setBounds(486, 72, 65, 19);
        contentPane.add(PortInput);
        PortInput.setColumns(10);

        JButton BtnSend = new JButton("SEND");
        BtnSend.setFont(new Font("Tahoma", Font.BOLD, 18));
        BtnSend.addActionListener(new ActionListener() {

            // action listener for the Send Button
            public void actionPerformed(ActionEvent e) {
                String message = ClientMessageInput.getText();
                System.out.println(message);

            }
        });
        BtnSend.setBounds(566, 392, 98, 25);
        contentPane.add(BtnSend);

        JLabel TitleLabel = new JLabel("Client Chat");
        TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        TitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
        TitleLabel.setBounds(175, 10, 281, 38);
        contentPane.add(TitleLabel);

        JButton btnLogout = new JButton("TERMINATE");
        btnLogout.addActionListener(new ActionListener() {
            // Action listener for the Logout Button
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnLogout.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnLogout.setBounds(563, 33, 118, 25);
        contentPane.add(btnLogout);
    }
}