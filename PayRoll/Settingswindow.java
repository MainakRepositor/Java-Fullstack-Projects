import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.net.*;

  public class Settingswindow extends JInternalFrame implements ActionListener, ItemListener {

	JFrame JFParentFrame;
	JDesktopPane desktop;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private JPanel panel6;
	private JPanel panel7;
	private JPanel panel8;
		
	private JButton AddBtn;
	private JButton ChangeBtn;
	private JButton ExitBtn;
	private JButton DeleteBtn;
	private JLabel LblHeading, LblBasic_Salary, LblAllowance, LblPercent1, LblRs1;
	private JLabel LblDeduction, LblPercent2, LblRs2;
	private JLabel LblDA, LblHRA, LblWA, LblGPF, LblIT,LblGIS,LblPF, LblLIC;
	private JLabel Emp_Type, SELECT1, SELECT2;
					
	private JTextField   TxtBasic, TxtDA1, TxtHRA1, TxtWA1, TxtGPF1, TxtIT1, TxtGIS1, TxtPF1, TxtLIC1; 
	private JTextField TxtCategory_Name,TxtDA2,  TxtHRA2, TxtWA2;
	private JTextField TxtGPF2,TxtIT2,  TxtGIS2,  TxtPF2,  TxtLIC2; 
	private JComboBox Cat_Name;
    private JCheckBox  chDA,chHRA,chWA, chGPF, chIT, chGIS, chPF, chLIC;
    
    
    
    		
	String dialogmessage;
    String dialogs;
     int dialogtype = JOptionPane.PLAIN_MESSAGE;
     public static int record;
     
     // Class Variables
     
     clsSettings settings = new clsSettings();
     clsConnection connect = new clsConnection();
     
     // Connection
     Connection conn;
    
    private String sCategory_Type = "";
    private String sCategory_Name = "";
    private String sBasic_Pay = "";
    private String sDA = "false";
    private String sHRA = "false";
    private String sWA = "false";
    private String sGPF = "false";
    private String sIT = "false";
    private String sGIS = "false";
    private String sPF = "false";
    private String sLIC = "false";
    private String sDA_Allow = "";
    private String sHRA_Allow = "";
    private String sWA_Allow = "";
    private String sGPF_Dedu = "";
    private String sIT_Dedu = "";
    private String sGIS_Dedu = "";
    private String sPF_Dedu = "";
    private String sLIC_Dedu = "";
    public static boolean s;
    
    
     
    public Settingswindow(JFrame getParentFrame) 
    {
    	super("Employee - Settings",true,true,true,true);
    	setSize(800,850);
    	JFParentFrame = getParentFrame;
           	    	
    	panel2 = new JPanel();
    	panel2.setLayout(new FlowLayout());
    	Emp_Type = new JLabel("Employee Type :"); 
    	Cat_Name = new JComboBox();
       	Cat_Name.addActionListener(this);
    	Cat_Name.setEditable(false);
    	add_Cat_combo(Cat_Name);
    	TxtCategory_Name = new JTextField(10);
    	TxtCategory_Name.setText(null);
    	String cat_Name = (String)Cat_Name.getSelectedItem();
    	
    	 	
    	panel2.add(Emp_Type,"LEFT");
    	panel2.add(Cat_Name,"CENTER");
    	panel2.add(TxtCategory_Name,"RIGHT");
    	
    	
    	panel3 = new JPanel();
    	panel3.setLayout(new FlowLayout());
    	LblBasic_Salary = new JLabel("Basic Salary : ");
    	TxtBasic = new JTextField(10);
    	panel3.add(LblBasic_Salary,"LEFT");
    	panel3.add(TxtBasic,"RIGHT");
    	
    	
    	 panel4 = new JPanel();
    	 panel4.setLayout(new GridLayout(1,4,5,5));
    	 SELECT1 = new JLabel("Check for %");
    	 LblAllowance = new JLabel("Allowance");
    	 LblPercent1 = new JLabel(" Allowance Value");
    	 LblRs1 = new JLabel("Information");
    	 
    	 panel4.add(SELECT1,"CENTER");
    	 panel4.add(LblAllowance, "CENTER");
    	 panel4.add(LblPercent1, "CENTER");
    	 panel4.add(LblRs1, "CENTER");
    	 
    	    	 
    	 panel5 = new JPanel();
    	 panel5.setLayout(new GridLayout(3,4,5,5));
    	 
    	 LblDA = new JLabel("DA Allowance   :");
    	 LblHRA = new JLabel("HRA Allowance :");
    	 LblWA = new JLabel("WA Allowane    :");
    	 
    	 TxtDA1 = new JTextField();
    	 TxtDA2 = new JTextField("Enter in Rupees");
    	 
    	 TxtHRA1 = new JTextField();
    	 
    	 TxtHRA2 = new JTextField("Enter in Rupees");
    	 
    	 TxtWA1 = new JTextField();
    
    	 TxtWA2 = new JTextField("Enter in Rupees");
    	 
    	 chDA = new JCheckBox("DA",false);
    	 chDA.addItemListener(this);
    	 chHRA = new JCheckBox("HRA",false);
    	 chHRA.addItemListener(this);
    	 chWA = new JCheckBox("WA",false);
    	 chWA.addItemListener(this);
    	 
    	 panel5.add(LblDA);
    	 panel5.add(chDA);
    	 panel5.add(TxtDA1);
    	 panel5.add(TxtDA2);
    	 
    	 
    	 panel5.add(LblHRA);
    	 panel5.add(chHRA);
    	 panel5.add(TxtHRA1);
    	 panel5.add(TxtHRA2);
    	 
    	 panel5.add(LblWA);
    	 panel5.add(chWA);
    	 panel5.add(TxtWA1);
    	 panel5.add(TxtWA2);
    	 
    	 
    	 
    	 panel6 = new JPanel();
    	 panel6.setLayout(new GridLayout(1,4,5,5));
    	 SELECT2 = new JLabel("Check for %");
    	 LblDeduction = new JLabel("Deduction :");
    	 LblPercent2 = new JLabel("Deduction Value");
    	 LblRs2= new JLabel("Information");
    	
      	 panel6.add(SELECT2,"CENTER");
    	 panel6.add(LblDeduction, "CENTER");
    	 panel6.add(LblPercent2, "CENTER");
    	 panel6.add(LblRs2, "CENTER");
    	 
    	 
    		panel7 = new JPanel();
    		panel7.setLayout(new GridLayout(6,4,2,2));
    	
    	 LblGPF = new JLabel ("GPF Deduction :");
    	 LblIT = new JLabel  ("I.T. Deduction:");
    	 LblGIS = new JLabel ("GIS Deduction :");
    	 LblPF = new JLabel  ("PF Deductoin  :");
    	 LblLIC = new JLabel ("LIC Deduction :");
    	 
    	 
    	 
    	 TxtGPF1 = new JTextField();
    	 
    	 TxtGPF2 = new JTextField("Enter in Rupees");
    	 TxtIT1 = new JTextField();
    	 TxtIT2 = new JTextField("Enter in Rupees");
    	 TxtGIS1 = new JTextField();
    	 TxtGIS2 = new JTextField("Enter in Rupees");
    	 TxtPF1 = new JTextField();
    	 TxtPF2 = new JTextField("Enter in Rupees");
    	 TxtLIC1 = new JTextField();
    	 TxtLIC2 = new JTextField("Enter in Rupees");
    	 
    	 
    	 chGPF = new JCheckBox("GPF",false);
    	 chGPF.addItemListener(this);
    	 chIT = new JCheckBox("IT",false);
    	 chIT.addItemListener(this);
    	 chGIS = new JCheckBox("GIS",false);
    	 chGIS.addItemListener(this);
    	 chPF = new JCheckBox("PF",false);
    	 chPF.addItemListener(this);
    	 chLIC = new JCheckBox("LIC",false);
    	 chLIC.addItemListener(this);
    	 panel7.add(LblGPF);
    	 panel7.add(chGPF);
    	 panel7.add(TxtGPF1);
    	 panel7.add(TxtGPF2);
    	 
    	 
    	 panel7.add(LblIT);
    	 panel7.add(chIT);
    	 panel7.add(TxtIT1);
    	 panel7.add(TxtIT2);
    	 
    	 panel7.add(LblGIS);
    	 panel7.add(chGIS);
    	 panel7.add(TxtGIS1);
    	 panel7.add(TxtGIS2);
    	
    	
    	 panel7.add(LblPF);
    	 panel7.add(chPF);    	 
    	 panel7.add(TxtPF1);
    	 panel7.add(TxtPF2);
    	
    	 panel7.add(LblLIC);
    	 panel7.add(chLIC);    	 
    	 panel7.add(TxtLIC1);
    	 panel7.add(TxtLIC2);
    	 panel7.setOpaque(true);
    	 
    	
    	
    	panel8 = new JPanel();
    	panel8.setLayout(new FlowLayout(FlowLayout.CENTER));
    	AddBtn = new JButton("Add New");
    	AddBtn.addActionListener(this);
    	ChangeBtn = new JButton("Edit");
    	ChangeBtn.addActionListener(this);
    	DeleteBtn = new JButton("Delete");
    	DeleteBtn.addActionListener(this);
    	ExitBtn = new JButton("Exit");
    	ExitBtn.addActionListener(this);
    	
    	panel8.add(AddBtn);
    	panel8.add(ChangeBtn);
    	panel8.add(DeleteBtn);
    	panel8.add(ExitBtn);
    	panel8.setOpaque(true);
    	   	 
    	   	 check_false();
    	   	 uncheck_true();
      
   Container pane = getContentPane();
    		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
			pane.add(panel2);
			pane.add(panel3);
			pane.add(panel4);
			pane.add(panel5);
			pane.add(panel6);
			pane.add(panel7);
			pane.add(panel8);
    	 
    	 setFrameIcon(new ImageIcon( "images/settings.gif"));
       	 setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       	 pack();	
       
      settings.Numvalidator(TxtBasic);
      settings.Numvalidator(TxtDA1);
      settings.Numvalidator(TxtDA2);
      settings.Numvalidator(TxtHRA1);
      settings.Numvalidator(TxtHRA2);
      settings.Numvalidator(TxtWA1);
      settings.Numvalidator(TxtWA2);
      settings.Numvalidator(TxtGPF1);
      settings.Numvalidator(TxtGPF2);
      settings.Numvalidator(TxtIT1);
      settings.Numvalidator(TxtIT2);
      settings.Numvalidator(TxtGIS1);
      settings.Numvalidator(TxtGIS2);
      settings.Numvalidator(TxtPF1);
      settings.Numvalidator(TxtPF2);
      settings.Numvalidator(TxtLIC1);
      settings.Numvalidator(TxtLIC2);
      fill_form(cat_Name);

    }
    
    public void actionPerformed(ActionEvent event)
    {
    		Object source = event.getSource();
    		
    			if ( source  == Cat_Name)
    	{
				
    			String cat_Name = (String)Cat_Name.getSelectedItem();
    			fill_form(cat_Name);
    			
    		
    	}
    	if (source == AddBtn)
    	{
    		add_record();
    	}
    	
    	if (source == ChangeBtn)
    	{
    		edit_record();
    	}
    	
    	if (source == DeleteBtn)
    	{
    		delete_record();
    	}
    	
    	if (source == ExitBtn)
    	{
    		setVisible (false);
				dispose();
    		
    	}
    		
    }
    
    
    public void itemStateChanged(ItemEvent event)
    {
    	
    	Object item = event.getItemSelectable();

      			
    	 if (item == chDA)
    	{
    	
    		if (event.getStateChange() == ItemEvent.SELECTED) {
            sDA = "true";
            TxtDA2.setText("Enter in % of Basic");
                        
        }
        else if (event.getStateChange() == ItemEvent.DESELECTED)
        {
        	 sDA = "false";
        	 
        	TxtDA2.setText("Enter in Rupees");
            
        	 
        }
        
    	}
        else if (item == chHRA)
        {
        	if (event.getStateChange() == ItemEvent.SELECTED) {
            sHRA = "true";
            TxtHRA2.setText("Enter in % of Basic");
        	 
           
        }
         else if (event.getStateChange() == ItemEvent.DESELECTED)
        {
        	 sHRA = "false";
        	 TxtHRA2.setText("Enter in Rupees");
        	
        	 
        }
        }
         else if (item == chWA)
        {
        	if (event.getStateChange() == ItemEvent.SELECTED) {
            sWA = "true";
            TxtWA2.setText("Enter in % of Basic");
        	
           
        }
         else if (event.getStateChange() == ItemEvent.DESELECTED)
        {
        	 sWA = "false";
        	 TxtWA2.setText("Enter in Rupees");
        }
         }
        else if (item == chGPF)
        {
        	if (event.getStateChange() == ItemEvent.SELECTED) {
            sGPF = "true";
            TxtGPF2.setText("Enter in % of Basic");
        	
        }
         else if (event.getStateChange() == ItemEvent.DESELECTED)
        {
        	 sGPF = "false";
        	 TxtGPF2.setText("Enter in Rupees");
        }
         }
         
         else if (item == chIT)
        {
        	if (event.getStateChange() == ItemEvent.SELECTED) {
            sIT = "true";
            TxtIT2.setText("Enter in % of Basic");
        	
        }
         else if (event.getStateChange() == ItemEvent.DESELECTED)
        {
        	 sIT = "false";
        	 TxtIT2.setText("Enter in Rupees");
        }
         }
         else if (item == chGIS)
        {
        	if (event.getStateChange() == ItemEvent.SELECTED) {
            sGIS = "true";
           TxtGIS2.setText("Enter in % of Basic");
        	 
        }
         else if (event.getStateChange() == ItemEvent.DESELECTED)
        {
        	 sGIS = "false";
        	TxtGIS2.setText("Enter in Rupees");
        }
         }
         
         else if (item == chPF)
        {
        	if (event.getStateChange() == ItemEvent.SELECTED) {
            sPF = "true";
            TxtPF2.setText("Enter in % of Basic");
        	 
        }
         else if (event.getStateChange() == ItemEvent.DESELECTED)
        {
        	 sPF = "false";
        	TxtPF2.setText("Enter in Rupees");
        	 
        }
         }
         
         else if (item == chLIC)
        {
        	if (event.getStateChange() == ItemEvent.SELECTED) {
            sLIC = "true";
          TxtLIC2.setText("Enter in % of Basic");
        
        }
         else if (event.getStateChange() == ItemEvent.DESELECTED)
        {
        	 sLIC = "false";
        	 TxtLIC2.setText("Enter in Rupees");
        	 
        }
         }
    	
    	
    	
    	
        

    	}
    	
    	public void check_false()
    	{
    	
    	 TxtDA1.setEditable(true);
    	 TxtHRA1.setEditable(true);
    	 TxtWA1.setEditable(true);
   	  	 TxtGPF1.setEditable(true);
    	 TxtIT1.setEditable(true);
    	 TxtGIS1.setEditable(true);
    	 TxtPF1.setEditable(true);
    	 TxtLIC1.setEditable(true); 
    	 
    	 
    	}
    	
    	public void uncheck_true()
    	{
    	
    		TxtDA2.setEditable(false);
    		TxtHRA2.setEditable(false);
    		TxtWA2.setEditable(false);
    		TxtGPF2.setEditable(false);
    		TxtIT2.setEditable(false);
    		TxtGIS2.setEditable(false);
    		TxtPF2.setEditable(false);
    		TxtLIC2.setEditable(false);
    		
    	}
    	
    	public void seteditable_true(JTextField chtxt )
    	{
    	 chtxt.setEditable(true);
    	 
    	}
    	
    	public void seteditable_false(JTextField chtxt)
    	{
    		chtxt.setEditable(false);
    	}
    	
    	public void checkbox_state( JCheckBox chbox, String opt)
    	{
    		
    		
    			s = Boolean.valueOf(opt);
    			chbox.setSelected(s);
    			
    	
    	}
    	
    	public void txtbox_fill(JTextField txt1, String value)
    	{
    		
    		//s = Boolean.valueOf(option);
    		
    			txt1.setText(value);
    	}
    	
    	
    	   public void add_Cat_combo(JComboBox cmb)
        {
        	     
                   
            try {
                conn = connect.setConnection(conn,"","");
            }
            catch(Exception e)
            {
            }
            try{
             	
				           
                Statement stmt = conn.createStatement();
                
                String query = "SELECT * FROM Settings";
                ResultSet rs = stmt.executeQuery(query);
                               
                while (rs.next())
                {
                	

                	String Txtcmb = rs.getString(2).trim();
                	record = rs.getInt("Category_Type");
                	cmb.addItem(Txtcmb); 
                	
                }	
                	conn.close();
          }
                
        
        catch(Exception ex)
          {
          	
          	}		
          	
    }
    /////////////////////////////////
    public void add_record()
    {
    	  
    	  
    	  try {
                conn = connect.setConnection(conn,"","");
                
            }
            catch(Exception e)
            {
            
            }
            try{
            	
            	
            	record = record +1;
            	sCategory_Type = ""+record; 	            
				sCategory_Name	 = TxtCategory_Name.getText().trim();
                sBasic_Pay = TxtBasic.getText().trim();
    			sDA_Allow = TxtDA1.getText().trim();
    			sHRA_Allow =TxtHRA1.getText().trim();
    			sWA_Allow = TxtWA1.getText().trim();
    			sGPF_Dedu = TxtGPF1.getText().trim();
    			sIT_Dedu = TxtIT1.getText().trim();
    			sGIS_Dedu = TxtGIS1.getText().trim();
    			sPF_Dedu = TxtPF1.getText().trim();
    			sLIC_Dedu = TxtLIC1.getText().trim();
    		
    		
    		
    			
            	 if (!sCategory_Type.equals("") &&
            	 	!sCategory_Name.equals("")&&
     				!sBasic_Pay.equals("")&&
     				!sDA_Allow.equals("") &&
     				!sHRA_Allow.equals("")&&
     				!sWA_Allow.equals("") &&
     				!sGPF_Dedu.equals("") &&
     				!sIT_Dedu.equals("")&&
     				!sGIS_Dedu.equals("")&&
     				!sPF_Dedu.equals("") &&
     				!sLIC_Dedu.equals(""))
     				{
				     					
     			System.out.println("Category Name :" +sCategory_Name);		
                Statement stmt = conn.createStatement();
                
                String query = "SELECT * FROM Settings WHERE Category_Name='" +sCategory_Name+ "'";
               
                ResultSet rs = stmt.executeQuery(query);
                int foundrec=0;                               
                while (rs.next())
                {
                
                	dialogmessage = "Record Already Exists in DataBase!!!";
                    dialogtype = JOptionPane.WARNING_MESSAGE;
                    JOptionPane.showMessageDialog((Component)null, dialogmessage, dialogs, dialogtype);
                  
                    foundrec = 1;
                	                	
              
                }	
                	  if (foundrec == 0)
                {
                
               
                String temp = "INSERT INTO Settings VALUES (" + sCategory_Type 	+",'" +
                											   sCategory_Name 	+"'," +
     														   sBasic_Pay      	+",'"  +
     														  sDA             	+"','" +	
     														  sHRA 				+"','" +
     														  sWA 				+ "','" +
     														  sGPF 				+"','"+
     														  sIT 				+"','"+
     														  sGIS				+"','"+		
     														  sPF				+"','"+
     														  sLIC				+"',"+
     														  sDA_Allow 		+","+
     														  sHRA_Allow		+","+
     														  sWA_Allow			+","+
     														  sGPF_Dedu 		+","+
     														  sIT_Dedu 			+","+
     														  sGIS_Dedu 		+","+
     														  sPF_Dedu 		    +","+
     														  sLIC_Dedu 		+")";									
     														 
     			
     			  int result = stmt.executeUpdate( temp );
                                 if ( result == 1 )
                                 {
                           		 dialogmessage = "New Position Added";
                    			dialogtype = JOptionPane.INFORMATION_MESSAGE;
                    	JOptionPane.showMessageDialog((Component)null, dialogmessage, dialogs, dialogtype);
                    	Cat_Name.addItem(sCategory_Name);
                    	
                           		
                                 }
                                 else {
                                 		dialogmessage = "Failed To Insert";
                    JOptionPane.showMessageDialog(null, dialogmessage,
                            "WARNING!!",JOptionPane.WARNING_MESSAGE);
                            	
                    
                                 }
                }
                	
     				}
     				else 
     				{
     						dialogmessage = "EMPTY VALUE FOUND";
                    JOptionPane.showMessageDialog(null, dialogmessage,
                            "WARNING!!",JOptionPane.WARNING_MESSAGE);
                            	
     					
     				} 	
                	conn.close();
          }
               
        catch(Exception ex)
          {
          	System.out.println("Unknown Error" +ex);
          	
          	
          	}
    	
    }	
    	   	
 
    	  public void fill_form(String name)
        {
        	     
                   
            try {
                conn = connect.setConnection(conn,"","");
                
            }
            catch(Exception e)
            {
            
            }
            try{
             	
             
                Statement stmt = conn.createStatement();
                
                String query = "SELECT * FROM Settings WHERE Category_Name='" +name+ "'";
               
                ResultSet rs = stmt.executeQuery(query);
                                               
                while (rs.next())
                {
                 	sCategory_Type = "";
                 	sCategory_Name = "";          
					sBasic_Pay = "";
					sDA = "";
    				sHRA = "";
    				sWA = "";
    				sGPF = "";
    				sIT = "";
    				sGIS = "";
    				sPF = "";
    				sLIC = "";
    				sDA_Allow = "";
    				sHRA_Allow = "";
    				sWA_Allow = "";
    				sGPF_Dedu = "";
    				sIT_Dedu = "";
    				sGIS_Dedu = "";
    				sPF_Dedu = "";
    				sLIC_Dedu = "";
					
				
				
                sCategory_Type += rs.getString(1).trim();
                sCategory_Name = rs.getString(2).trim();
                sBasic_Pay = rs.getString(3).trim();
    			sDA = rs.getString(4).trim();
    			sHRA = rs.getString(5).trim();
    			sWA = rs.getString(6).trim();
    			sGPF = rs.getString(7).trim();
    			sIT = rs.getString(8).trim();
    			sGIS = rs.getString(9).trim();
    			sPF = rs.getString(10).trim();
    			sLIC = rs.getString(11).trim();
    			sDA_Allow = rs.getString(12).trim();
    			sHRA_Allow = rs.getString(13).trim();
    			sWA_Allow = rs.getString(14).trim();
    			sGPF_Dedu = rs.getString(15).trim();
    			sIT_Dedu = rs.getString(16).trim();
    			sGIS_Dedu = rs.getString(17).trim();
    			sPF_Dedu = rs.getString(18).trim();
    			sLIC_Dedu = rs.getString(19).trim();
    			
    			TxtBasic.setText(sBasic_Pay);
    			
    			checkbox_state( chDA, sDA );
    			checkbox_state( chHRA, sHRA );
    			checkbox_state( chWA, sWA );
    			checkbox_state( chGPF, sGPF );
    			checkbox_state( chIT, sIT );
    			checkbox_state( chGIS, sGIS );
    			checkbox_state( chPF, sPF );
    			checkbox_state( chLIC, sLIC );
  
    				txtbox_fill(TxtDA1,sDA_Allow);
    				txtbox_fill(TxtHRA1,sHRA_Allow);
    				txtbox_fill(TxtWA1,sWA_Allow);
    				txtbox_fill(TxtGPF1,sGPF_Dedu);
    				txtbox_fill(TxtIT1,sIT_Dedu);
    				txtbox_fill(TxtGIS1,sGIS_Dedu);
    				txtbox_fill(TxtPF1, sPF_Dedu);
    				txtbox_fill(TxtLIC1, sLIC_Dedu); 
    					
                	                	
                rs = null;
                
                	
                }	
                	conn.close();
          }
               
        catch(Exception ex)
          {
          	
          	}		
          	
    }
    
       public void edit_record()
    {
    	  try {
                conn = connect.setConnection(conn,"","");
                
            }
            catch(Exception e)
            {
            
            }
            try{
            	
            	
            	sCategory_Name = (String)Cat_Name.getSelectedItem();
                sBasic_Pay = TxtBasic.getText().trim();
    			sDA_Allow = TxtDA1.getText().trim();
    			sHRA_Allow =TxtHRA1.getText().trim();
    			sWA_Allow = TxtWA1.getText().trim();
    			sGPF_Dedu = TxtGPF1.getText().trim();
    			sIT_Dedu = TxtIT1.getText().trim();
    			sGIS_Dedu = TxtGIS1.getText().trim();
    			sPF_Dedu = TxtPF1.getText().trim();
    			sLIC_Dedu = TxtLIC1.getText().trim();
    		
    		
            	 if (!sCategory_Name.equals("")&&
     				!sBasic_Pay.equals("")&&
     				!sDA_Allow.equals("") &&
     				!sHRA_Allow.equals("")&&
     				!sWA_Allow.equals("") &&
     				!sGPF_Dedu.equals("") &&
     				!sIT_Dedu.equals("")&&
     				!sGIS_Dedu.equals("")&&
     				!sPF_Dedu.equals("") &&
     				!sLIC_Dedu.equals(""))
     				
     				{
     			
     				 Statement stmt = conn.createStatement();
                	
                	String temp = "UPDATE Settings SET " +
                             "Category_Type= " +sCategory_Type+
                             ", Category_Name= '" + sCategory_Name +
					"',Basic_Pay= " + sBasic_Pay +
                    ", DA='" + sDA +
					"',HRA= '" + sHRA +
					"',WA= '" + sWA +
					"',GPF = '" + sGPF +
					"',IT = '" + sIT +
					"',GIS = '" + sGIS +		
					"',PF = '" + sPF +	
					"',LIC = '" + sLIC +
					"',DA_Allow = " + sDA_Allow +
					",HRA_Allow = " + sHRA_Allow +
					",WA_Allow = " + sWA_Allow +
					",GPF_Dedu = " + sGPF_Dedu +
					",IT_Dedu = " + sIT_Dedu +
					",GIS_Dedu = " + sGIS_Dedu +
					",PF_Dedu = " + sPF_Dedu +
					",LIC_Dedu = " + sLIC_Dedu +
					" WHERE Category_Type= " + sCategory_Type;
					int result = stmt.executeUpdate( temp );
     				if ( result == 1 )
                                 {
                	dialogmessage = "Record Altered into  DataBase!!!";
                    dialogtype = JOptionPane.INFORMATION_MESSAGE;
                    JOptionPane.showMessageDialog((Component)null, dialogmessage, dialogs, dialogtype);
                  
                    
                				}
                else
                	{
                	dialogmessage = "NO SUCH POSITION FOUND!!!";
                    dialogtype = JOptionPane.WARNING_MESSAGE;
                    JOptionPane.showMessageDialog((Component)null, dialogmessage, dialogs, dialogtype);
                  
                    
                	}		
                			
     		}
     		
     		else
     		{
     				dialogmessage = "NULL VALUES IN TEXTFIELD OCCURED!!!";
                    dialogtype = JOptionPane.WARNING_MESSAGE;
                    JOptionPane.showMessageDialog((Component)null, dialogmessage, dialogs, dialogtype);
     		}
     		conn.close();
     		
            }
     			catch(Exception ex)
          {
          	JOptionPane.showMessageDialog(null,"GENERAL EXCEPTION", "WARNING!!!",JOptionPane.INFORMATION_MESSAGE);
          	}				
    }		
    

//////////////////////////////////

     public void delete_record()
    {
    	 
    	 	sCategory_Name = (String)Cat_Name.getSelectedItem();
    int DResult = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete Record?");

	if (DResult == JOptionPane.NO_OPTION || DResult == JOptionPane.CANCEL_OPTION) {
					dialogmessage = "Operation Calceld By User!!!";
                    dialogtype = JOptionPane.INFORMATION_MESSAGE;
                    JOptionPane.showMessageDialog((Component)null, dialogmessage, dialogs, dialogtype);
		
	}
	if (DResult == JOptionPane.YES_OPTION)
	{
		 
    	 
    	  try {
                conn = connect.setConnection(conn,"","");
                
            }
            catch(Exception e)
            {
            
            }
            try{
            	
            	
            
	
	 
	  
  
    		
            	 if (!sCategory_Name.equals(""))
     				
     				{
     			
     				 Statement stmt = conn.createStatement();
                	
                	 String temp = "DELETE from Settings " +
                                     " WHERE Category_Name = '" + sCategory_Name + "'";
                	
                	int result = stmt.executeUpdate( temp );
     				if ( result == 1 )
                                 {
                	dialogmessage = "Record Deleted From DataBase!!!";
                    dialogtype = JOptionPane.INFORMATION_MESSAGE;
                    JOptionPane.showMessageDialog((Component)null, dialogmessage, dialogs, dialogtype);
                  
                    
                				}
                else
                	{
                	dialogmessage = "No Such Record Found!!!";
                    dialogtype = JOptionPane.WARNING_MESSAGE;
                    JOptionPane.showMessageDialog((Component)null, dialogmessage, dialogs, dialogtype);
                  
                    
                	}		
                			
     		}
     		
     		else
     		{
     				dialogmessage = "Empty Record Found!!!";
                    dialogtype = JOptionPane.WARNING_MESSAGE;
                    JOptionPane.showMessageDialog((Component)null, dialogmessage, dialogs, dialogtype);
     		}
     		
            
     		conn.close();
     		
            }
     			catch(Exception ex)
          {
          	JOptionPane.showMessageDialog(null,"GENERAL EXCEPTION", "WARNING!!!",JOptionPane.INFORMATION_MESSAGE);
              	}				
	} 		
    }
    
    
    


///////////////////////////////
}
