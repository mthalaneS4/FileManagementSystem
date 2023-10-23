import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserAccounts implements ActionListener {
    JFrame frame = new JFrame("UserAccounts");
    JButton ADMIN = new JButton("ADMIN LOGIN");
    JButton DOC = new JButton("DOCTOR'S LOGIN");
    JLabel Acc = new JLabel("USER ACCOUNTS");

    UserAccounts() {
        Acc.setFont(new Font("Arial", Font.BOLD, 25));
        Acc.setBounds(500, 300, 400, 40); // Set the label's position above the buttons
        Acc.setIcon(new ImageIcon("C:\\Users\\Slindokuhle Mthalane\\OneDrive\\Desktop\\projectSFMCS\\icons\\user.png"));
        ADMIN.setBounds(400, 400, 200, 40); // Adjusted the button positions and width
        ADMIN.addActionListener(this);
        ADMIN.setIcon(new ImageIcon("C:\\Users\\Slindokuhle Mthalane\\OneDrive\\Desktop\\projectSFMCS\\icons\\administration.png"));
        DOC.setBounds(650, 400, 200, 40); // Adjusted the button positions and width
        DOC.addActionListener(this);
        DOC.setIcon(new ImageIcon("C:\\Users\\Slindokuhle Mthalane\\OneDrive\\Desktop\\projectSFMCS\\icons\\medical-team.png"));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height - 50;
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.add(Acc);
        frame.add(ADMIN);
        frame.add(DOC);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ADMIN) {
            frame.dispose();
            Admin admin = new Admin();
        } else if (e.getSource() == DOC) {
            frame.dispose();
            Doctor doctor = new Doctor();
        }
    }
}
