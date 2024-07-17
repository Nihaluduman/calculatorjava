
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class calculator implements ActionListener {
    JFrame jf;
    JLabel disp;
    JButton jb7, jb8, jb9, jb4, jb5, jb6, jb1, jb2, jb3, jb0, jbdot, jbd, jbp, jbe, jbm, jbmi;
    double num1 = 0, num2 = 0, result = 0;
    String operator = "";
    
    public calculator() {
        
        jf = new JFrame("CALCULATOR");                                                                                 
        jf.setSize(300, 350); // Increased height to fit all buttons
        jf.setLocation(1000, 100);
        jf.setLayout(null);

        JLabel txt = new JLabel("WELCOME");
        txt.setBounds(0, 0, 300, 30);
        txt.setBackground(Color.BLACK);
        txt.setForeground(Color.YELLOW);
        txt.setHorizontalAlignment(SwingConstants.CENTER);
        txt.setFont(new Font("Georgia", Font.BOLD, 20));
        txt.setOpaque(true);

        disp = new JLabel("");
        disp.setFont(new Font("Arial", Font.BOLD, 40));
        disp.setBounds(0, 40, 300, 50);
        disp.setBackground(Color.WHITE);
        disp.setOpaque(true);
        disp.setVisible(true);

        int buttonWidth = 60;
        int buttonHeight = 50;
        int verticalSpacing = 10;
        int initialY = 110;

        jb7 = createButton("7", 20, initialY);
        jb8 = createButton("8", 90, initialY);
        jb9 = createButton("9", 160, initialY);

        initialY += buttonHeight + verticalSpacing;

        jb4 = createButton("4", 20, initialY);
        jb5 = createButton("5", 90, initialY);
        jb6 = createButton("6", 160, initialY);

        initialY += buttonHeight + verticalSpacing;

        jb1 = createButton("1", 20, initialY);
        jb2 = createButton("2", 90, initialY);
        jb3 = createButton("3", 160, initialY);

        initialY += buttonHeight + verticalSpacing;

        jb0 = createButton("0", 20, initialY);
        jbdot = createButton(".", 90, initialY);
        jbe = createButton("=", 160, initialY);

        int operatorInitialY = 110;
        jbp = createButton("+", 230, operatorInitialY);
        jbd = createButton("/", 230, operatorInitialY + buttonHeight + verticalSpacing);
        jbmi = createButton("-", 230, operatorInitialY + 2 * (buttonHeight + verticalSpacing));
        jbm = createButton("*", 230, operatorInitialY + 3 * (buttonHeight + verticalSpacing));

        JPanel jp = new JPanel();
        jp.setBackground(Color.gray);
        jp.setBounds(0, 0, 300, 450); // Adjusted to match frame size
        jp.setLayout(null);

        jp.add(txt);
        jp.add(disp);
        jp.add(jb7);
        jp.add(jb8);
        jp.add(jb9);
        jp.add(jb4);
        jp.add(jb5);
        jp.add(jb6);
        jp.add(jb1);
        jp.add(jb2);
        jp.add(jb3);
        jp.add(jb0);
        jp.add(jbdot);
        jp.add(jbe);
        jp.add(jbp);
        jp.add(jbm);
        jp.add(jbd);
        jp.add(jbmi);

        jf.add(jp);

        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 60, 50);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.addActionListener(this);
        return button;
    }

    public static void main(String[] args) {
        System.setProperty("java.awt.headless", "true");
        new calculator();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb7) {
            disp.setText(disp.getText() + "7");
        } else if (e.getSource() == jb8) {
            disp.setText(disp.getText() + "8");
        } else if (e.getSource() == jb9) {
            disp.setText(disp.getText() + "9");
        } else if (e.getSource() == jb4) {
            disp.setText(disp.getText() + "4");
        } else if (e.getSource() == jb5) {
            disp.setText(disp.getText() + "5");
        } else if (e.getSource() == jb6) {
            disp.setText(disp.getText() + "6");
        } else if (e.getSource() == jb1) {
            disp.setText(disp.getText() + "1");
        } else if (e.getSource() == jb2) {
            disp.setText(disp.getText() + "2");
        } else if (e.getSource() == jb3) {
            disp.setText(disp.getText() + "3");
        } else if (e.getSource() == jb0) {
            disp.setText(disp.getText() + "0");
        } else if (e.getSource() == jbdot) {
            disp.setText(disp.getText() + ".");
        } else if (e.getSource() == jbp) {
            num1 = Double.parseDouble(disp.getText());
            operator = "+";
            disp.setText("");
        } else if (e.getSource() == jbm) {
            num1 = Double.parseDouble(disp.getText());
            operator = "*";
            disp.setText("");
        } else if (e.getSource() == jbd) {
            num1 = Double.parseDouble(disp.getText());
            operator = "/";
            disp.setText("");
        } else if (e.getSource() == jbmi) {
            num1 = Double.parseDouble(disp.getText());
            operator = "-";
            disp.setText("");
        } else if (e.getSource() == jbe) {
            num2 = Double.parseDouble(disp.getText());
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }
            disp.setText(String.valueOf(result));
        }
    }
}
