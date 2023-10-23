import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutUs extends JFrame {
    JLabel titleLabel = new JLabel("About Us");
    JLabel locationLabel = new JLabel();
    JLabel phoneNumberLabel = new JLabel();
    JLabel emailLabel = new JLabel();
    JLabel locationLabelinfo = new JLabel("39 lillay ngoye st");
    JLabel phoneNumberLabelinfo = new JLabel("0625393078");
    JLabel emailLabelinfo = new JLabel("saggy.richfield@ca.za");
    JButton Dashb = new JButton("Dashboard");
    public AboutUs(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height - 50;
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);

        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(150, 10, 100, 30);
        //location
        locationLabel.setBounds(20, 50, 100, 50);
        locationLabel.setIcon(new ImageIcon("C:\\Users\\Slindokuhle Mthalane\\OneDrive\\Desktop\\projectSFMCS\\icons\\location.png"));
        //phone
        phoneNumberLabel.setBounds(20, 150, 100, 50);
        phoneNumberLabel.setIcon(new ImageIcon("C:\\Users\\Slindokuhle Mthalane\\OneDrive\\Desktop\\projectSFMCS\\icons\\telephone-call.png"));
        //email
        emailLabel.setBounds(20, 250, 100, 50);
        emailLabel.setIcon(new ImageIcon("C:\\Users\\Slindokuhle Mthalane\\OneDrive\\Desktop\\projectSFMCS\\icons\\email.png"));
//add infor to the label
        locationLabelinfo.setBounds(150, 60, 200, 20);
        locationLabelinfo.setFont(new Font("Arial",Font.BOLD,18));
        //
        phoneNumberLabelinfo.setBounds(150, 160, 100, 20);
        phoneNumberLabelinfo.setFont(new Font("Arial",Font.BOLD,18));
        //
        emailLabelinfo.setBounds(150, 260, 300, 20);
        emailLabelinfo.setFont(new Font("Arial",Font.BOLD,18));
        Dashb.setBounds(170, 350, 100, 25);

        Dashb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dashboard dashboard = new Dashboard();
            }
        });
        add(titleLabel);
        add(locationLabel);
        add(phoneNumberLabel);
        add(emailLabel);
        add(locationLabelinfo);
        add(phoneNumberLabelinfo);
        add(emailLabelinfo);
        add(Dashb);
    }
}