import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.*;

public class Doctor extends JFrame {
    JFrame frame2 = new JFrame("Doctors");
    JLabel Doctors = new JLabel("Doctors Login");
    JLabel username = new JLabel("Username:");
    JTextField txtName = new JTextField();
    JLabel password = new JLabel("Password: ");
    JPasswordField txtPass = new JPasswordField();
    private Connection con;
    private PreparedStatement pst;
    JButton Login = new JButton("Login");

    public Doctor() {
        // Set frame layout to null
        frame2.setLayout(null);
        // Set bounds for components
        Doctors.setBounds(500, 100, 400, 40);
        Doctors.setFont(new Font(null, Font.PLAIN, 25));
        Doctors.setIcon(new ImageIcon("C:\\Users\\Slindokuhle Mthalane\\OneDrive\\Desktop\\projectSFMCS\\icons\\medical-team.png"));
        username.setBounds(450, 200, 150, 25);
        username.setFont(new Font(null, Font.PLAIN, 25));
        txtName.setBounds(600, 200, 150, 25);
        password.setBounds(450, 250, 150, 25);
        password.setFont(new Font(null, Font.PLAIN, 25));
        txtPass.setBounds(600, 250, 150, 25);
        Login.setBounds(600, 300, 100, 50);

        // Adding components to the frame
        frame2.add(Doctors);
        frame2.add(username);
        frame2.add(txtName);
        frame2.add(password);
        frame2.add(txtPass);
        frame2.add(Login);

        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height - 50;
        frame2.setSize(width, height);
        frame2.setVisible(true);

        // Database connection setup
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/FMS", "postgres", "Tiny@2000");
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }

        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText();
                String pass = new String(txtPass.getPassword());

                if (name.isEmpty() || pass.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Both Username and Password are required.");
                } else {
                    try {
                        pst = con.prepareStatement("SELECT * FROM doctors WHERE username = ? AND password = ?");
                        pst.setString(1, name);
                        pst.setString(2, pass);

                        ResultSet rs = pst.executeQuery();
                        if (rs.next()) {
                            frame2.dispose();
                            HomepgDoc homepage = new HomepgDoc();
                            homepage.setVisible(true);
                            setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(null, "Incorrect User");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
    }

}
