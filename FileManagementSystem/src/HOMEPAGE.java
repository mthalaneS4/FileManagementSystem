import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HOMEPAGE extends JFrame {
    // Create a menu bar
    JMenuBar menuBar = new JMenuBar();
    JMenu filemenu = new JMenu("Home");
    // Create menu items
    JMenuItem addNewPatientItem = new JMenuItem("New Patient");
    JMenuItem editPatientItem = new JMenuItem("Edit Patient");
    JMenuItem Signout = new JMenuItem("Sign out");

    public HOMEPAGE() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height - 50;
        setSize(width, height);

        // Add menu items to the patient menu
        filemenu.add(addNewPatientItem);
        filemenu.add(editPatientItem);
        filemenu.add(Signout);

        menuBar.add(filemenu);

        // Set the JMenuBar for the frame
        setJMenuBar(menuBar);

        addNewPatientItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the Add New Patient form
                new NewPatients();
                dispose();

            }
        });

        editPatientItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the Edit Patient form
                new EditHR();
                dispose();
            }
        });
        Signout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Dashboard dashboard = new Dashboard();
                //dispose();
            }
        });

        setVisible(true);
    }
}
