package Week8to11;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AdminDashboard extends JFrame implements MouseListener, ActionListener{
	   
	 JButton addPatientDetailsbtn;
	 JButton addContactTracingbtn;
	 JButton viewContactTracingbtn;
	 JButton logoutbtn;
	 
	 Connection conn;
	 
	 JTable tbl;
	 DefaultTableModel model;

     AdminDashboard() {
	   setTitle("Admin");
       setLayout(null);
       this.getContentPane().setBackground(new Color(145, 100, 0,255));
       
       addPatientDetailsbtn=new JButton("Add Patient Details");
       addContactTracingbtn=new JButton("Add Contact Tracing");
       viewContactTracingbtn=new JButton("View Contact Tracing");
       logoutbtn=new JButton("Logout");
       
       addPatientDetailsbtn.addActionListener(this);
       addContactTracingbtn.addActionListener(this);
       viewContactTracingbtn.addActionListener(this);
       logoutbtn.addActionListener(this);

       addPatientDetailsbtn.setBounds(10, 50, 470, 250);
       addContactTracingbtn.setBounds(500, 50,  400, 250);
       viewContactTracingbtn.setBounds(920, 50,  400, 250);
       logoutbtn.setBounds(600, 500,  200, 150);
       

       add(addPatientDetailsbtn);
       add(addContactTracingbtn);
       add(viewContactTracingbtn);
       add(logoutbtn);

       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(1366,1080);
       setVisible(true);


   	}

            
   
   public static void main(String[] args) {
	   AdminDashboard f = new AdminDashboard();
   }

   @Override
   public void actionPerformed(ActionEvent e) {
       Object source=e.getSource();
       
       if(source==addPatientDetailsbtn) {
    	   AddPatientDetails f = new AddPatientDetails();
           dispose();
       }else if (source == logoutbtn) {
    	   Login f = new Login();
           dispose();
       }else if (source == addContactTracingbtn) {
    	   AddContactTracing f = new AddContactTracing();
           dispose();
       } else if (source == viewContactTracingbtn) {
    	   ViewContactTracing f = new ViewContactTracing();
           dispose();
       }



   }

@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
	
	
}
