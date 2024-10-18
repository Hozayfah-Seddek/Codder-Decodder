import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class CodderDecodder extends JFrame implements ActionListener, ChangeListener {
    JButton b, b2;
    JTextField t, t2;
    JLabel l;
    JSlider s;

    CodderDecodder() {
        this.setSize(800, 800);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Codder-DeCodder");
        this.setIconImage(new ImageIcon("icon.png").getImage());
        this.setResizable(false);

        l = new JLabel("Enter the text to be coded or decoded");
        this.add(l);
        l.setBounds(100, 100, 500, 50);

        t = new JTextField();
        this.add(t);
        t.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        t.setBounds(100, 150, 500, 50);

        b = new JButton("Code");
        this.add(b);
        b.addActionListener(this);
        b.setFocusable(false);
        b.setBounds(250, 250, 100, 50);
        b.setBackground(Color.lightGray);

        b2 = new JButton("Decode");
        this.add(b2);
        b2.addActionListener(this);
        b2.setFocusable(false);
        b2.setBounds(360, 250, 100, 50);
        b2.setBackground(Color.lightGray);
        
        s = new JSlider(1, 26, 1);
        s.setPaintTrack(true);
        s.setMajorTickSpacing(1);
        s.setPaintLabels(true);
        s.addChangeListener(this);
        this.add(s);
        s.setBounds(100, 325, 500, 50);

        t2 = new JTextField();
        t2.setBackground(Color.gray);
        t2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        t2.setForeground(Color.white);
        t2.setEditable(false);
        this.add(t2);
        t2.setBounds(100, 400, 500, 50);
    }

    public void stateChanged(ChangeEvent e) {
        s.setValue(s.getValue());
    }

    public void actionPerformed(ActionEvent e) {
        String u = t.getText();
        int v = s.getValue();
        String resultText = "";

        if (e.getSource() == b) {
            for (int i = 0; i < u.length(); i++) {
                char c = u.charAt(i);
                resultText += (char) (c + v);
            }
        } else if (e.getSource() == b2) {
            for (int i = 0; i < u.length(); i++) {
                char c = u.charAt(i);
                resultText += (char) (c - v);
            }
        }
        t2.setText(resultText);
    }
}