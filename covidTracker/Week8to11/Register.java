package Week8to11;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import javax.swing.*;

public class Register extends JFrame implements ActionListener {
    JLabel titlelbl;
    JLabel usernamelbl;
    JLabel rolelbl;
    JLabel addresslbl;
    JLabel phonelbl;
    JLabel emaillbl;
    JLabel passwordlbl;
    JLabel cpasswordlbl;

    JTextField txtname;
    JComboBox roletxt;
    JTextField txtaddress;
    JTextField txtphone;
    JTextField txtemail;
    JPasswordField txtpassword;
    JPasswordField txtcpassword;

    JButton registerbtn;
    JButton loginbtn;
    JButton clearbtn;

    Register() {
        setTitle("Register");
        setLayout(null);
        this.getContentPane().setBackground(new Color(15, 110, 150,255));

        titlelbl = new JLabel("Register");
        usernamelbl = new JLabel("Username:");
        rolelbl = new JLabel("Role:");
        addresslbl = new JLabel("Address:");
        phonelbl = new JLabel("Phone:");
        emaillbl = new JLabel("Email:");
        passwordlbl = new JLabel("Password:");
        cpasswordlbl = new JLabel("Confirm Password:");

        txtname = new JTextField(20);
        String role[] = { "Admin" };
        roletxt = new JComboBox(role);
        txtaddress = new JTextField(20);
        txtphone = new JTextField(20);
        txtemail = new JTextField(20);
        txtpassword = new JPasswordField(20);
        txtcpassword = new JPasswordField(20);

        registerbtn = new JButton("Register");
        loginbtn = new JButton("Back to Login");
        clearbtn = new JButton("Clear");

        registerbtn.addActionListener(this);
        loginbtn.addActionListener(this);
        clearbtn.addActionListener(this);

        titlelbl.setBounds(110, 15, 100, 30);
        titlelbl.setFont(new Font("Arial", Font.BOLD, 25));

        usernamelbl.setBounds(500, 100, 75, 25);
        emaillbl.setBounds(500, 150, 75, 25);
        passwordlbl.setBounds(500, 200, 75, 25);
        cpasswordlbl.setBounds(450, 250, 255, 25);

        txtname.setBounds(570, 100, 200, 25);
        txtemail.setBounds(570, 150, 200, 25);
        txtpassword.setBounds(570, 200, 200, 25);
        txtcpassword.setBounds(570, 250, 200, 25);

        registerbtn.setBounds(500, 400, 90, 35);
        clearbtn.setBounds(600, 400, 90, 35);
        loginbtn.setBounds(700, 400, 120, 35);

        add(titlelbl);
        add(usernamelbl);
        add(txtname);

        add(emaillbl);
        add(txtemail);
        add(passwordlbl);
        add(txtpassword);

        add(cpasswordlbl);
        add(txtcpassword);

        add(registerbtn);
        add(loginbtn);
        add(clearbtn);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1360, 1080);
        setVisible(true);
    }

    public static void main(String[] args) {
        Register f = new Register();
    }

    public void reset() {
        txtname.setText("");
        txtaddress.setText("");
        txtphone.setText("");
        txtemail.setText("");
        txtpassword.setText("");
        txtcpassword.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source == registerbtn) {
            String username = txtname.getText();
            String address = txtaddress.getText();
            String phone = txtphone.getText();
            String email = txtemail.getText();
            String password = txtpassword.getText();
            String cpassword = txtcpassword.getText();

            if (username.isEmpty() == false && email.isEmpty() == false && password.equals(cpassword)) {

                String userdata = username + "," + email + "," + password;
                try {
                    File f = new File("D:\\covidTracker\\FileHandling\\registerdetails.txt");
                    if (!f.exists()) {
                        f.createNewFile();
                    }
                    FileWriter fw = new FileWriter(f, true);
                    fw.write(userdata);
                    fw.write("\n");
                    fw.flush();
                    fw.close();
                } catch (Exception a) {
                    a.printStackTrace();
                }

                JOptionPane.showMessageDialog(null, "Register Success");
                reset();
            } else {
                JOptionPane.showMessageDialog(null, "Register Failed");
            }

        } else if (source == clearbtn) {
            txtname.setText("");
            txtaddress.setText("");
            txtphone.setText("");
            txtemail.setText("");
            txtpassword.setText("");
            txtcpassword.setText("");
        } else if (source == loginbtn) {
            Login f = new Login();
            dispose();
        }

    }
}