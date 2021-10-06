package Week8to11;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewContactTracing extends JFrame implements MouseListener, ActionListener {
    JLabel titlelbl;
    JLabel patientIdlbl;

    JTextField txtpatientId;
    
    JTextArea txtareaDetails;
    JScrollPane scroll;
    JScrollPane sp;
    
    
    JButton showbtn;
    JButton showVertexbtn;
    JButton backbtn;
    JButton showModerateRisk;
    JButton showHighRisk;
    
    JTable tbl;
    DefaultTableModel model;
    
    JTable tbl1;
    DefaultTableModel model1;

    ViewContactTracing() {
    	
        setTitle("Show Contact Details");
        setLayout(null);
		this.getContentPane().setBackground(new Color(10, 100, 100,255));

        titlelbl=new JLabel("Show Contact Details");
        patientIdlbl = new JLabel("Covid Patient Id:");
       
        txtpatientId = new JTextField(10);
        
        txtareaDetails = new JTextArea();
        txtareaDetails.setBounds( 30, 200 ,400 ,600 );
        txtareaDetails.setVisible(true);
        
        scroll = new JScrollPane (txtareaDetails);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        
        
        showbtn = new JButton("Patient Infos");
        showVertexbtn = new JButton("Patient Tree");
        backbtn = new JButton("Back");
        showModerateRisk = new JButton("Moderate Risk List");
        showHighRisk = new JButton("High Risk List");
        
        showbtn.addActionListener(this);
        showVertexbtn.addActionListener(this);
        backbtn.addActionListener(this);
        showHighRisk.addActionListener(this);
        showModerateRisk.addActionListener(this);
        
	     titlelbl.setBounds(110, 15, 300, 30);
	     titlelbl.setFont(new Font("Arial", Font.BOLD, 25));
	    
	     patientIdlbl.setBounds(50, 100, 120, 25);
	     
	     
	     txtpatientId.setBounds(170, 100, 200, 25);
	     
	     
	     showbtn.setBounds(450, 300, 150, 45);
	     backbtn.setBounds(450, 370, 150, 45);
	     showVertexbtn.setBounds(450, 440, 150, 45);
	     showHighRisk.setBounds(450,510 , 150, 45);
	     showModerateRisk.setBounds(450,580 , 150, 45);
	     
	     String [] cols= {"Patient_Id","Name","Address","Phone","Covid Date","Created Date","Contacted Date"};
	     model=new DefaultTableModel(cols,0);
	     tbl=new JTable(model);
	     
	     sp=new JScrollPane(tbl);
	     sp.setBounds(650, 20, 700, 350);
	     add(sp);
	     tbl.addMouseListener(this);
	     
	     
	     String [] cols1= {"Patient_Id","Name","Address","Phone","Covid Date","Created Date","Contacted Date"};
	     model1=new DefaultTableModel(cols1,0);
	     tbl1=new JTable(model1);
	     
	     JScrollPane sp1=new JScrollPane(tbl1);
	     sp1.setBounds(650, 400, 700, 500);
	     add(sp1);
	     tbl1.addMouseListener(this);

	     
	     
	     add(titlelbl);
	     add(patientIdlbl);
	     add(txtpatientId);
	     
	     add(txtareaDetails);
	     getContentPane().add(scroll);
	     
	     add(showbtn);
	     add(showVertexbtn);
	     add(backbtn);
	     add(showModerateRisk);
	     add(showHighRisk);
	    
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     setSize(1366,1080);
	     setVisible(true);
         
	     displayTable();
	     
    }
    
    public void displayTable() {
        try {
        	File f = new File("D:\\covidTracker\\FileHandling\\patientDetails.txt");
        	Scanner reader = new Scanner(f);
            
            while(reader.hasNextLine()) {
            	String line = reader.nextLine();
            	String data[] = line.split(",");
                
                String id=data[0];
                String name=data[1];
                String address=data[2];
                String phone=data[3];
                String covidDate = data[4];
                String date = data[5];
                String contactedDate = data[6];
                model.addRow(new Object[] {id,name,address,phone,covidDate,date,contactedDate});
            }
            reader.close();       
        }
        catch(Exception ee) {
            ee.printStackTrace();
        }
    }
    
    
    public void displayHighTable() {
        	ContactTracingAlgorithm ct = new ContactTracingAlgorithm(100);
        	try {
	        	File f = new File("D:\\covidTracker\\FileHandling\\patientDetails.txt");
	        	Scanner reader = new Scanner(f);
	            while(reader.hasNextLine()) {
	            	String line = reader.nextLine();
	            	String data[] = line.split(",");
	            	int id = Integer.parseInt(data[0]);
	            	File f1 = new File("D:\\covidTracker\\FileHandling\\contactTracingDetails.txt");
		        	Scanner reader1 = new Scanner(f1);
	            	while(reader1.hasNextLine()) {
	            		String line1 = reader1.nextLine();
		            	String data1[] = line1.split(",");
		            	int id1 = Integer.parseInt(data1[1]);
		            	int id2 = Integer.parseInt(data1[0]);
	            		if(id==id1) {
		            		if(data[4].equals("Null") &&!ct.findDate(id2).equals("Null")) {
		            			 String ID=data[0];
		                         String name=data[1];
		                         String address=data[2];
		                         String phone=data[3];
		                         String covidDate = data[4];
		                         String date = data[5];
		                         String contactedDate = data[6];
		                         model1.addRow(new Object[] {ID,name,address,phone,covidDate,date,contactedDate});
		            		}
		            	}
	            		
	            	}
	            	reader1.close();
	            	
	            }
	            reader.close();  
	            
	        }
	        catch(Exception ee) {
	            ee.printStackTrace();
	        }
    }
    
    
    public void displayModerateTable() {
        	ContactTracingAlgorithm ct = new ContactTracingAlgorithm(100);
        	try {
	        	File f = new File("D:\\covidTracker\\FileHandling\\patientDetails.txt");
	        	Scanner reader = new Scanner(f);
	        	
	        	
	            while(reader.hasNextLine()) {
	            	String line = reader.nextLine();
	            	String data[] = line.split(",");
	            	int id = Integer.parseInt(data[0]);
	            	File f1 = new File("D:\\covidTracker\\FileHandling\\contactTracingDetails.txt");
		        	Scanner reader1 = new Scanner(f1);
	            	while(reader1.hasNextLine()) {
	            		String line1 = reader1.nextLine();
		            	String data1[] = line1.split(",");
		            	int id1 = Integer.parseInt(data1[1]);
		            	int id2 = Integer.parseInt(data1[0]);
	            		if(id==id1) {
		            		if(data[4].equals("Null") &&ct.findDate(id2).equals("Null")) {
		            			 String ID=data[0];
		                         String name=data[1];
		                         String address=data[2];
		                         String phone=data[3];
		                         String covidDate = data[4];
		                         String date = data[5];
		                         String contactedDate = data[6];
		                         model1.addRow(new Object[] {ID,name,address,phone,covidDate,date,contactedDate});
		            		}
		            	}
	            	}
	            	reader1.close();
	            	
	            }
	            reader.close();  
	        }
	        catch(Exception ee) {
	            ee.printStackTrace();
	        }
    }
    
    public void remove_table() {
        for(int i=model1.getRowCount()-1;i>=0;i--) {
            model1.removeRow(i);
        }
       
   }
    
    public static void main(String[] args) {
    	ViewContactTracing f = new ViewContactTracing();
    }
 
    public void reset_txtField() {
    	txtpatientId.setText("");
        }
    
    public void reset_txtArea() {
    	txtareaDetails.setText("");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source=e.getSource();
        
        if(source==showHighRisk) {
        	reset_txtArea();
        	remove_table();
        	displayHighTable();
        }
        else if(source==showModerateRisk) {
        	reset_txtArea();
        	remove_table();
        	displayModerateTable();
        }
        else if(source==showbtn) {
        	reset_txtArea();
        	String final_detail = "";
        	String PatientId = txtpatientId.getText();
        	int data1 = Integer.parseInt(PatientId);
            if (PatientId.isEmpty()==false ) {
                try {
                	ContactTracingAlgorithm ct = new ContactTracingAlgorithm(100);
                	try {
                    	File f = new File("D:\\covidTracker\\FileHandling\\contactTracingDetails.txt");
                    	Scanner reader = new Scanner(f);
                        
                        while(reader.hasNextLine()) {
                        	String line = reader.nextLine();
                        	String data[] = line.split(",");
                        	int int1 = Integer.parseInt(data[0]);
                        	int int2 = Integer.parseInt(data[1]);
                            ct.addEdge(int1,int2);
                        }
                        reader.close();       
                    }
                    catch(Exception ee) {
                        ee.printStackTrace();
                    }
            		String textArea = ct.printEdge(data1);
            		final_detail= final_detail + textArea;
            		List<Integer> list1 = ct.get_CovidContactList(data1);
            		for(int i=0; i<list1.size();i++) {
            			String textArea21 = ct.printEdge(list1.get(i));
            			final_detail =final_detail + textArea21;
            		}
            		
            		txtareaDetails.setText(final_detail);
            		
                	
                } catch (Exception a) {
                    a.printStackTrace();
                }
                reset_txtField();
            } else {
                JOptionPane.showMessageDialog(null, "Showing Failed");
            }
        }
        else if(source == showVertexbtn) {
        	String PatientId = txtpatientId.getText();
        	int data1 = Integer.parseInt(PatientId);
            try {
            ViewNodes k = new ViewNodes(data1);
            } catch(Exception ee) {
            	JOptionPane.showMessageDialog(null, "Select a Patient ID");
            }
        }
        else if(source==backbtn) {
            AdminDashboard f = new AdminDashboard();
            dispose();
        }

    }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row=tbl.rowAtPoint(e.getPoint());
        System.out.println("row_id= "+row);
        
        System.out.println(model.getValueAt(row, 0));
        txtpatientId.setText(model.getValueAt(row, 0).toString());
		
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
