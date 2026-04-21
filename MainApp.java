import javax.swing.*;
import java.awt.event.*;

public class MainApp {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Pressure Vessel Analyzer");
        frame.setSize(450, 450);
        frame.setLayout(null);

        // Labels
        JLabel l1 = new JLabel("Pressure (MPa):");
        l1.setBounds(30, 30, 150, 25);
        frame.add(l1);

        JLabel l2 = new JLabel("Diameter (mm):");
        l2.setBounds(30, 70, 150, 25);
        frame.add(l2);

        JLabel l3 = new JLabel("Material:");
        l3.setBounds(30, 110, 150, 25);
        frame.add(l3);

        JLabel l4 = new JLabel("Safety Factor:");
        l4.setBounds(30, 150, 150, 25);
        frame.add(l4);

        // Input fields
        JTextField t1 = new JTextField();
        t1.setBounds(200, 30, 150, 25);
        frame.add(t1);

        JTextField t2 = new JTextField();
        t2.setBounds(200, 70, 150, 25);
        frame.add(t2);

        JTextField t4 = new JTextField();
        t4.setBounds(200, 150, 150, 25);
        frame.add(t4);

        // Material dropdown
        String materials[] = {"Steel", "Aluminum", "Titanium"};
        JComboBox<String> box = new JComboBox<>(materials);
        box.setBounds(200, 110, 150, 25);
        frame.add(box);

        // Result area
        JTextArea result = new JTextArea();
        result.setBounds(30, 240, 360, 120);
        frame.add(result);

        // Button
        JButton btn = new JButton("Calculate");
        btn.setBounds(150, 190, 120, 30);
        frame.add(btn);

        // Button action
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    double P = Double.parseDouble(t1.getText());
                    double D = Double.parseDouble(t2.getText());
                    double SF = Double.parseDouble(t4.getText());

                    // Material properties
                    double sigma = 0;
                    String mat = (String) box.getSelectedItem();

                    if (mat.equals("Steel")) sigma = 250;
                    else if (mat.equals("Aluminum")) sigma = 150;
                    else sigma = 300;

                    // Validation
                    if (P <= 0 || D <= 0 || SF <= 0) {
                        result.setText("Error: Enter valid positive values.");
                        return;
                    }

                    double sigma_allow = sigma / SF;

                    // Thin vessel
                    double t_thin = (P * D) / (2 * sigma_allow);

                    String output = "";

                    if (t_thin < D / 20) {

                        output += "Type: THIN PRESSURE VESSEL\n";
                        output += "Thickness: " + String.format("%.2f", t_thin) + " mm\n";

                        if (sigma_allow > P)
                            output += "Status: SAFE\n";
                        else
                            output += "Status: UNSAFE\n";

                        output += "Explanation: t < D/20 → Thin vessel assumption valid.";

                    } else {

                        double ri = D / 2;
                        double ro = ri * Math.sqrt((sigma_allow + P) / (sigma_allow - P));
                        double t_thick = ro - ri;

                        output += "Type: THICK PRESSURE VESSEL\n";
                        output += "Thickness: " + String.format("%.2f", t_thick) + " mm\n";

                        if (sigma_allow > P)
                            output += "Status: SAFE\n";
                        else
                            output += "Status: UNSAFE\n";

                        output += "Explanation: t ≥ D/20 → Lame’s equation used.";
                    }

                    result.setText(output);

                } catch (Exception ex) {
                    result.setText("Error: Invalid input format.");
                }
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
