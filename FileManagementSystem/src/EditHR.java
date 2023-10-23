import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditHR {
    private JTextField idField;
    private JLabel nameLabel;
    private JLabel nameResultLabel;
    private JTextArea medHistoryTextArea;
    private JButton searchButton;
    private JButton saveButton;
    private JButton Home;

    public EditHR() {
        JFrame frame = new JFrame("Database Search and Update App");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height - 50;
        frame.setSize(width, height);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel idLabel = new JLabel("Enter ID:");
        idField = new JTextField(10);
        searchButton = new JButton("Search");
        saveButton = new JButton("Save to med_history");
        nameLabel = new JLabel("Name:");
        Home = new JButton("Home");
        nameResultLabel = new JLabel("");
        medHistoryTextArea = new JTextArea(10, 30);

        panel.add(idLabel);
        panel.add(idField);
        panel.add(searchButton);
        panel.add(saveButton);
        panel.add(Home);
        panel.add(nameLabel);
        panel.add(nameResultLabel);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(medHistoryTextArea), BorderLayout.CENTER);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchAndDisplayData();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveTextToDatabase();
            }
        });
        Home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HOMEPAGE userAccounts = new HOMEPAGE();
            }
        });

        frame.setVisible(true);
    }

    private void searchAndDisplayData() {
        String id = idField.getText().trim();

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter an ID to search.");
            return;
        }

        try {
            String url = "jdbc:postgresql://localhost:5432/FMS";
            String username = "postgres";
            String password = "Tiny@2000";

            Connection conn = DriverManager.getConnection(url, username, password);

            String sql = "SELECT name, med_history FROM testreg WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String medHistory = resultSet.getString("med_history");
                nameResultLabel.setText(name);
                medHistoryTextArea.setText(medHistory); // Display medical history in the JTextArea
            } else {
                nameResultLabel.setText("No record found for ID: " + id);
                medHistoryTextArea.setText(""); // Clear the JTextArea
            }

            resultSet.close();
            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database connection error.");
        }
    }

    private void saveTextToDatabase() {
        String id = idField.getText().trim();
        String newMedHistory = medHistoryTextArea.getText();

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter an ID to save to med_history.");
            return;
        }

        try {
            String url = "jdbc:postgresql://localhost:5432/FMS";
            String username = "postgres";
            String password = "Tiny@2000";

            Connection conn = DriverManager.getConnection(url, username, password);

            String updateSql = "UPDATE testreg SET med_history = ? WHERE id = ?";
            PreparedStatement updateStatement = conn.prepareStatement(updateSql);
            updateStatement.setString(1, newMedHistory);
            updateStatement.setString(2, id);

            int updatedRows = updateStatement.executeUpdate();
            if (updatedRows > 0) {
                JOptionPane.showMessageDialog(null, "Med_history updated successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "No record found for ID: " + id);
            }

            updateStatement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database connection error.");
        }
    }
}