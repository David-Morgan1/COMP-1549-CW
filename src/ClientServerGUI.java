import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ClientServerGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientServerGUI frame = new ClientServerGUI();
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
	public ClientServerGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 861, 521);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 149, 827, 277);
		contentPane.add(panel);
		
		JLabel IPLabel = new JLabel("IP Address");
		IPLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		IPLabel.setBounds(34, 118, 83, 25);
		contentPane.add(IPLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Client ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(296, 118, 71, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel PortLabel = new JLabel("Port Number");
		PortLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		PortLabel.setBounds(473, 118, 106, 13);
		contentPane.add(PortLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 436, 709, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(116, 118, 157, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.setBounds(693, 114, 106, 25);
		contentPane.add(btnLogin);
		
		textField_2 = new JTextField();
		textField_2.setBounds(359, 118, 96, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(565, 118, 96, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnSend = new JButton("SEND");
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSend.setBounds(739, 436, 98, 38);
		contentPane.add(btnSend);
		
		JLabel TitleLabel = new JLabel("Client Chat");
		TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		TitleLabel.setBounds(227, 35, 367, 38);
		contentPane.add(TitleLabel);
	}
}
