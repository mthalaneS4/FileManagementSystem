import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ViewData extends JFrame {
    private JLabel head = new JLabel("Presciption");
    private JLabel doc_Name = new JLabel("Doctor's Name: ");
    private JLabel Patient_id = new JLabel("Patient Id: ");
    private JLabel Medicine = new JLabel("Medicine: ");
    private JLabel Diagnosis = new JLabel("Diagnosis: ");
    private JLabel Dosage = new JLabel("Dosage: ");
    private JLabel pills = new JLabel("Amount of Dosage: ");
    private JTextField Docter_name = new JTextField();
    private JTextField Patient_ID =new JTextField();
    private JTextField Medisic = new JTextField();
    private JTextField DIAGNOSIS = new JTextField();
    private JButton addprescription = new JButton("prescribe");
    private JButton Home = new JButton("Home");

    public ViewData() {
        setTitle("New Patients"); // Set frame title
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height - 50;
        setSize(width, height);
        setVisible(true);

        head.setFont(new Font("Arial", Font.BOLD, 25));
        head.setBounds(500, 10, 300, 25);
        //doctors name
        doc_Name.setFont(new Font("Arial", Font.BOLD, 16));
        doc_Name.setBounds(400, 80, 300, 25);
        Docter_name.setBounds(550, 80, 150, 25);
        //patient id
        Patient_id.setFont(new Font("Arial", Font.BOLD, 16));
        Patient_id.setBounds(400, 130, 300, 25);
        Patient_ID.setBounds(550, 130, 150, 25);
//medicine
        Medicine.setFont(new Font("Arial", Font.BOLD, 16));
        Medicine.setBounds(400, 180, 300, 25);
        Medisic.setBounds(550, 180, 150, 25);
        //diagnosis
        Diagnosis.setFont(new Font("Arial", Font.BOLD, 16));
        Diagnosis.setBounds(400, 230, 300, 25);
        DIAGNOSIS.setBounds(550, 230, 150, 25);
        //dosage
        Dosage.setFont(new Font("Arial", Font.BOLD, 16));
        Dosage.setBounds(400, 280, 300, 25);
        String[] option1 = {"ones a day","twice a day","3 times a day"};
         JComboBox<String> times = new JComboBox(option1);
        String[] option2 = {"1","2","3","4","5"};
         JComboBox<String> quantity = new JComboBox(option2);
        times.setBounds(550, 280, 150, 25);
        //pilss
        pills.setFont(new Font("Arial", Font.BOLD, 16));
        pills.setBounds(400, 330, 300, 25);
        quantity.setBounds(550, 330, 150, 25);
//nutton
        addprescription.setBounds(550, 380, 150, 25);
        Home.setBounds(750, 380, 150, 25);

        add(head);
        add(doc_Name);
        add(Docter_name);
        add(Patient_id);
        add(Patient_ID);
        add(Medicine);
        add(Medisic);
        add(Diagnosis);
        add(DIAGNOSIS);
        add(Dosage);
        add(times);
        add(quantity);
        add(addprescription);
        add(Home);
        add(pills);

        Home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               HomepgDoc homepgDoc = new HomepgDoc();
            }
        });
    }
}