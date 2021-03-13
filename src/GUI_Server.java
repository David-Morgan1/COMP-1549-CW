import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class GUI_Server extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI_Server frame = new GUI_Server();
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
    public GUI_Server() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 696, 463);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(173, 255, 47));
        panel.setBounds(10, 0, 672, 416);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Chat Server");
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
        titleLabel.setBounds(214, 10, 222, 33);
        panel.add(titleLabel);

        JPanel serverPanel = new JPanel();
        serverPanel.setBackground(Color.BLACK);
        serverPanel.setBounds(10, 53, 652, 308);
        panel.add(serverPanel);

        JButton btnStop = new JButton("STOP");
        btnStop.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnStop.setBounds(548, 371, 114, 35);
        panel.add(btnStop);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.GREEN);
        panel_1.setBounds(10, 373, 528, 33);
        panel.add(panel_1);
    }
}