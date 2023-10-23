import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame {
    private JToolBar toolBar = new JToolBar();

    // Create buttons for the toolbar
    private JLabel head = new JLabel("Mobile Health View System");
    private JLabel message = new JLabel();
    private JButton Signin = new JButton("Sign In");
    private JButton Aboutus = new JButton("About Us");

    public Dashboard() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height - 50;
        setSize(width, height);
        setLocationRelativeTo(null);

        Signin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                UserAccounts userAccounts = new UserAccounts();
                dispose();
            }
        });

        Aboutus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            AboutUs aboutUs = new AboutUs();
            dispose();
            }
        });

        // Add buttons to the JToolBar
        toolBar.add(head);
        toolBar.addSeparator();
        toolBar.addSeparator();
        toolBar.addSeparator();
        toolBar.add(Signin);
        toolBar.addSeparator();
        toolBar.addSeparator();
        toolBar.add(Aboutus);

        // Create a JPanel for the background with a background image
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load your background image
                ImageIcon backgroundImage = new ImageIcon("C:\\Users\\Slindokuhle Mthalane\\OneDrive\\Desktop\\projectSFMCS\\icons\\resize.jpg");
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);

                // Add a label with the text "Health" on top of the image
                Font labelFont = new Font("Arial", Font.BOLD, 80);
                g.setFont(labelFont);
                g.setColor(Color.BLACK); // Set the text color
                String label = "Health Care Simplified" ;
                int labelX = 180; // X-coordinate for the label
                int labelY = 200; // Y-coordinate for the label
                g.drawString(label, labelX, labelY);
            }
        };

        // Set the layout for the background panel
        backgroundPanel.setLayout(new BorderLayout());

        // Create a JPanel to hold the JToolBar
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(toolBar, BorderLayout.NORTH);

        // Add the panel with the JToolBar to the backgroundPanel
        backgroundPanel.add(panel, BorderLayout.NORTH);

        // Add the backgroundPanel to the frame
        add(backgroundPanel);
        setVisible(true);
    }
    public static void main(String[] args) {
        Dashboard tool = new Dashboard();
    }
}
