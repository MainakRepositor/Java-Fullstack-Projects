import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;
import java.util.*;
import java.net.*;

public class Deletewindow extends JInternalFrame implements ActionListener  {

//	Dimension screen 	= Toolkit.getDefaultToolkit().getScreenSize();
	JFrame JFParentFrame;
	JDesktopPane desktop;
	private JPanel panel1;
	private JPanel panel2;
	private JButton FindBtn;
	private JButton DeleteBtn;
	private JButton ExitBtn;
	private JLabel LblEmp_Code,LblEmp_Name1, LblEmp_Name2, LblEmp_Desi,LblEmp_Add,LblEmp_No;
	private JTextField TxtEmp_Code, TxtEmp_Name1, TxtEmp_Name2, TxtEmp_Desi,TxtEmp_Add, TxtEmp_No; 
	String dialogmessage;
    String dialogs;
     int dialogtype = JOptionPane.PLAIN_MESSAGE;
    // Class Variables
    
    clsSettings settings = new clsSettings(); 

// Connection Class Variables
clsConnection connect = new clsConnection();
Connection conn;

	

    public Deletewindow(JFrame getParentFrame) 
    {
    	
    	super("Delete - Employee ",true,true,true,true);
    	setSize(400,800);
    	JFParentFrame = getParentFrame;
        panel1 = new JPanel();
    	panel1.setLayout(new GridLayout(7,7));
    	
	    LblEmp_Code = new JLabel                    (" Employee Code :");
	    LblEmp_Name1 = new JLabel  					(" First Name    :");	
	    LblEmp_Name2 = new JLabel  					(" Last Name     :");
	    LblEmp_Desi  = new JLabel  					(" Designation   :");
	    LblEmp_Add = new JLabel  					(" Address       :");
	    LblEmp_No = new JLabel  					(" Contact No    :");
	    
	    TxtEmp_Code = new JTextField(20);
	    TxtEmp_Name1 = new JTextField(20);
	    TxtEmp_Name2 = new JTextField(20);
	    TxtEmp_Desi = new JTextField(20);
	    TxtEmp_Add = new JTextField(20);
	    TxtEmp_No = new JTextField(20);
	    
	    
	    TxtEmp_Name1.setEditable(false);
	    TxtEmp_Name2.setEditable(false);
	    TxtEmp_Desi.setEditable(false);
	    TxtEmp_Add.setEditable(false);
	    TxtEmp_No.setEditable(false);
	    
	    panel1.add(LblEmp_Code);
	    panel1.add(TxtEmp_Code);
	    
	    panel1.add(LblEmp_Name1);
	    panel1.add(TxtEmp_Name1);
	    
	    panel1.add(LblEmp_Name2);
	    panel1.add(TxtEmp_Name2);
	    
	    panel1.add(LblEmp_Desi);
	    panel1.add(TxtEmp_Desi);
	    
	    panel1.add(LblEmp_Add);
	    panel1.add(TxtEmp_Add);
	    
	    panel1.add(LblEmp_No);
	    panel1.add(TxtEmp_No);
	    
	    
        panel2 = new JPanel();
   		panel2.setLayout(new FlowLayout());
   		FindBtn = new JButton("Find");
   		DeleteBtn = new JButton("Delete");
        ExitBtn = new JButton("Exit");
        
        panel2.add(FindBtn);
        FindBtn.addActionListener(this);
   		panel2.add(DeleteBtn);
   		DeleteBtn.addActionListener(this);
   		panel2.add(ExitBtn);
        ExitBtn.addActionListener(this);
        panel2.setOpaque(true);
        
           	 
    	 getContentPane().setLayout(new GridLayout(2,1)); 
    	 getContentPane().add(panel1,"CENTER");
    	 getContentPane().add(panel2,"CENTER");
    	 setFrameIcon(new ImageIcon( "images/backup.gif"));
       	 setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       	 pack();	
       	 settings.Numvalidator(TxtEmp_No);

    }
    
    	public void actionPerformed(ActionEvent event)
		{
			
			Object source = event.getSource();
			
            String sEmp_Code = "";
			String sEmp_Name1 = "";
			String sEmp_Name2 = "";
			String sEmp_Desi = "";
			String sEmp_Add  = "";
			String sEmp_No   = "";    
				 if(source.equals(FindBtn))
				 {
					
		sEmp_Code = TxtEmp_Code.getText().trim();
			try {
                conn = connect.setConnection(conn,"","");
            }
            catch(Exception e)
            {
            }
				 try {
			
    		
			    Statement stmt = conn.createStatement();          
    		
         if (!sEmp_Code.equals(""));
     			
     	
     		 String query = "SELECT * FROM EMPLOYEE WHERE Emp_Code='" + sEmp_Code +"'";
                ResultSet rs = stmt.executeQuery(query);
                int foundrec = 0;
                while (rs.next())
                {
                	ResultSetMetaData rsmd = rs.getMetaData();
                	int columnCount = rsmd.getColumnCount();
                	
                	
                		sEmp_Name1 = rs.getString(2).trim();
						sEmp_Name2 = rs.getString(3).trim();
						sEmp_Desi = rs.getString(4).trim();
						sEmp_Add = rs.getString(5).trim();
						sEmp_No = rs.getString(6).trim();
		
                	TxtEmp_Name1.setText(sEmp_Name1);
                    TxtEmp_Name2.setText(sEmp_Name2);
					TxtEmp_Desi.setText(sEmp_Desi);
                	TxtEmp_Add.setText(sEmp_Add);
                	TxtEmp_No.setText(sEmp_No);
                	foundrec = 1;
                    
                }
                
     		if (foundrec == 0)
                {
                    dialogmessage = "No Such Employuee";
                                   
                    dialogtype = JOptionPane.WARNING_MESSAGE;
                    JOptionPane.showMessageDialog((Component)null, dialogmessage, dialogs, dialogtype);
                   ResetRecord();
                   
                }
		  conn.close();
          
     		
			 }
				 catch(Exception e)
            {
                System.out.println("\nUnknown Error");
            }
           
           
				   
		 }	
			 
			else if(source.equals(DeleteBtn))
			{
								
	 	int DResult = JOptionPane.showConfirmDialog((Component) null,"Are you sure you want to delete Record?");

		if (DResult == JOptionPane.NO_OPTION) {
			ResetRecord();
		
			} 		 
	
	 if (DResult == JOptionPane.YES_OPTION)
         {
         	
         	try {
                conn = connect.setConnection(conn,"","");
            }
            catch(Exception e)
            {
            }
                          
              try
              {
                  Statement stmt = conn.createStatement();   
			    sEmp_Code = TxtEmp_Code.getText().trim();	
              	                      
                         if ( !sEmp_Code.equals(""))
                         {
						         	 String temp = "DELETE from EMPLOYEE " +
                                     " WHERE Emp_Code= '" + sEmp_Code + "'";
                                   int result = stmt.executeUpdate( temp );

                                   if ( result == 1 )
                                 {
                                 dialogmessage = "Employee Record Deleted!!!";
                    			dialogtype = JOptionPane.WARNING_MESSAGE;
                    		JOptionPane.showMessageDialog((Component)null, dialogmessage, dialogs, dialogtype);
                    			ResetRecord();
                               }

                               else

                            {
                               dialogmessage = "No Such Employuee";
                                
                    		dialogtype = JOptionPane.WARNING_MESSAGE;
                    		JOptionPane.showMessageDialog((Component)null, dialogmessage, dialogs, dialogtype);
                   			ResetRecord();

                             }
                             
                      }

                      
                 conn.close();
                     
            }

            catch(Exception e)
           {
               System.out.println("\nUnknown Error" + e);
           }
          }
				
			}
			else if(source  == ExitBtn)	
			{
				setVisible (false);
				dispose();
			}
			
		}
		
    private void ResetRecord()
    {
		TxtEmp_Code.setText("");
	    TxtEmp_Name1.setText(""); 
	    TxtEmp_Name2.setText(""); 
	    TxtEmp_Desi.setText(""); 
	    TxtEmp_Add.setText(""); 
	    TxtEmp_No.setText(""); 
    }
    
    
	


}
