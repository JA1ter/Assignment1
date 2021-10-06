package Week8to11;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
    JLabel titlelbl;
    JLabel usernamelbl;
    JLabel passwordlbl;

    JTextField txtname;
    JPasswordField txtpassword;

    JButton loginbtn;
    JButton clearbtn;
    JButton registerbtn;

    Login() {
        setTitle("Login System");
        setLayout(null);
        this.getContentPane().setBackground(new Color(145, 100, 0,255));

        titlelbl = new JLabel("Enter Your Credentials ");
        usernamelbl = new JLabel("Enter your Username:");
        passwordlbl = new JLabel("Enter your Password:");

        txtname = new JTextField(20);
        txtpassword = new JPasswordField(20);

        loginbtn = new JButton("Sign in");
        clearbtn = new JButton("Reset");
        registerbtn = new JButton("Create a New Account");

        loginbtn.addActionListener(this);
        clearbtn.addActionListener(this);
        registerbtn.addActionListener(this);

        titlelbl.setBounds(550, 75, 500, 50);
        titlelbl.setFont(new Font("Avallon", Font.ITALIC, 35));

        usernamelbl.setBounds(550, 190, 400, 50);
        passwordlbl.setBounds(550, 300, 400, 50);

        txtname.setBounds(700, 200, 200, 30);
        txtpassword.setBounds(700, 300, 200, 30);

        clearbtn.setBounds(550, 500, 100, 30);
        loginbtn.setBounds(700, 500, 100, 30);
        registerbtn.setBounds(850, 500, 200, 30);

        add(titlelbl);
        add(usernamelbl);
        add(txtname);

        add(passwordlbl);
        add(txtpassword);

        add(loginbtn);
        add(clearbtn);
        add(registerbtn);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1366, 1080);
        setVisible(true);
    }

    public static void main(String[] args) {
        Login f = new Login();
    }

    public void reset() {
        txtname.setText("");
        txtpassword.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == loginbtn) {
            String name = txtname.getText();
            String password = txtpassword.getText();

            try {
                File f = new File("D:\\covidTracker\\FileHandling\\registerdetails.txt");
                BufferedReader br = new BufferedReader(new FileReader(f));
                String line;

                while ((line = br.readLine()) != null) {
                    String data[] = line.split(",");
                    if (name.equals(data[0]) && password.equals(data[2])) {
                        JOptionPane.showMessageDialog(null, "Login Successful");
                        AdminDashboard admin = new AdminDashboard();
                        dispose();
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Login Failed");
                    }
                }
            }
            catch (Exception ee) {
                ee.printStackTrace();
            }
        }
        else if (source == clearbtn) {
            txtname.setText("");
            txtpassword.setText("");
        } else if (source == registerbtn) {
            Register register = new Register();
            dispose();
        }
    }
}
