import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomepgDoc extends JFrame {
    // Create a menu bar
    JMenuBar menuBar = new JMenuBar();
    JMenu filemenu = new JMenu("Home");
    // Create menu items
    JMenuItem edit_and_appointment = new JMenuItem("Edit and appointments");
    JMenuItem prescribe = new JMenuItem("Prescribe");
    JMenuItem Signout = new JMenuItem("Sign Out");

    public HomepgDoc() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height - 50;
        setSize(width, height);

        // Add menu items to the patient menu
        filemenu.add(edit_and_appointment);
        filemenu.add(prescribe);
        filemenu.add(Signout);

        menuBar.add(filemenu);

        // Set the JMenuBar for the frame
        setJMenuBar(menuBar);

        edit_and_appointment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the ViewData form
               EditHR editHR = new EditHR();
                dispose();

            }
        });

       prescribe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the Edit Patient form
                new ViewData();

            }
        });
        Signout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dashboard dashboard = new Dashboard();
               // dispose();
            }
        });

        setVisible(true);
    }
}
