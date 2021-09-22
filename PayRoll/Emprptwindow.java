import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.net.*;
import java.lang.String;
import java.awt.print.*;
import java.text.DateFormat;
import java.util.Date;


  public class Emprptwindow extends JInternalFrame implements ActionListener {
  
	JFrame JFParentFrame;
	
	static Date td  = new Date();
	static String sDate 	= DateFormat.getDateTimeInstance().format(td);
	
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private JPanel panel5_1;
	private JPanel panel5_2;
	private JPanel panel6;
	private JPanel panel6_1;
	private JPanel panel6_2;
	private JPanel panel7;
	private JPanel panel8_1;
	private JPanel panel9;
	private JPanel panel10;
	private JPanel panel11;
	private JPanel panel12;
	private JPanel panel13;
	private JPanel panel14;
		
	private JButton GenerateBtn;
	private JButton PrintBtn;
	private JButton ExitBtn;
	
	
	private JTextField TxtCategory_Type,TxtCategory_Name;
	private JComboBox MonthCombo;	
	private JTextField TxtYear;
	private JLabel LblMonth;
	private String[] Month_Name =       {"January",
                                        "February",
                                        "March",
                                        "April",
                                        "May",
                                        "June",
                                        "July",
                                        "August",
                                        "September",
                                        "October",
                                        "November",
                                        "December"};
   
	
	String dialogmessage;
    String dialogs;
    int dialogtype = JOptionPane.PLAIN_MESSAGE;
    public static int record;
    
        
    
     // Class Variables
     
     clsSettings settings = new clsSettings();
     clsConnection connect = new clsConnection();
     
     // Connection
     Connection conn;
     
     ////// Report Variables
     
     private JLabel Lblcollege1, Lblcollege2, Lblcollege3, Lbldate, LblSalary_Slip;
     private JLabel LblEmp_Name, LblEmp_Code, LblEmp_Desi, LblBasic_Pay, LblAllowance, LblDeduction;
     private JLabel LblDA, LblHRA, LblWA, LblGPF, LblIT, LblGIS, LblPF, LblLIC;
     private JLabel LblTot_Allowance, LblTot_Deduction, LblNet_Salary;
     
     private JTextField TxtDate, TxtEmp_Name1, TxtEmp_Name2 , TxtEmp_Code,TxtSalary_Month, TxtEmp_Desi, TxtBasic_Pay;
     private JTextField TxtDA, TxtHRA, TxtWA, TxtGPF, TxtIT, TxtGIS, TxtPF, TxtLIC;
     private JTextField TxtTot_Allowance, TxtTot_Deduction, TxtNet_Salary;
    
    
    public String sEmp_Code = "";
	public String sEmp_Name1 = "";
	public	String sEmp_Name2 = "";
	public	String sEmp_Desi = "";
	
    public String sCategory_Type = "";
    public String sCategory_Name = "";
    public String sBasic_Pay = "";
    public String sDA = "";
    public String sHRA = "";
    public String sWA = "";
    public String sGPF = "";
    public String sIT = "";
    public String sGIS = "";
    public String sPF = "";
    public String sLIC = "";
    public String sDA_Allow = "";
    public String sHRA_Allow = "";
    public String sWA_Allow = "";
    public String sGPF_Dedu = "";
    public String sIT_Dedu = "";
    public String sGIS_Dedu = "";
    public String sPF_Dedu = "";
    public String sLIC_Dedu = "";
    public String sAllow = "";
    public String sDedu = "";
    public String sNet_Salary = "";
    
    public String Emp_Month;
    public String Emp_Year;
    
    
    	public static int vBasic_Pay, DA_Rs, HRA_Rs ,WA_Rs , GPF_Rs, IT_Rs, GIS_Rs, PF_Rs, LIC_Rs;
    	public static int DA_Value,HRA_Value, WA_Value, GPF_Value, IT_Value, GIS_Value, PF_Value, LIC_Value;  
    	public static int Allow, Dedu, Net_Salary;
    
        
    
     
    public Emprptwindow(JFrame getParentFrame) 
 
    {
       super("Employee PaySlip",true,true,true,true);
       setSize(600,700);
       JFParentFrame = getParentFrame;
       
       
                     
    	panel1 = new JPanel();
    	panel1.setLayout(new FlowLayout());
    	LblEmp_Code = new JLabel("Employee Code: ");
    	TxtEmp_Code = new JTextField(10);
		LblMonth = new JLabel("For the Month :");
		
		
		MonthCombo = new JComboBox();
		MonthCombo.addActionListener(this);
				
    	for ( int i = 0; i <= 11; i++ )
    	{
    		MonthCombo.addItem(Month_Name[i]); 
    	}
    	TxtYear = new JTextField(5);    	
    	
    	panel1.add(LblEmp_Code);
    	panel1.add(TxtEmp_Code);
    	panel1.add(LblMonth);
    	panel1.add(MonthCombo);
    	panel1.add(TxtYear);
    	
    	
    	    	
    	panel2 = new JPanel();
    	panel2.setLayout(new FlowLayout());
    	
    	LblEmp_Name = new JLabel("Employee Name :");
    	TxtEmp_Name1 = new JTextField(10);
    	TxtEmp_Name2 = new JTextField(10);
    	
    	TxtEmp_Name1.setEditable(false);
    	TxtEmp_Name2.setEditable(false);
    	
    	panel2.add(LblEmp_Name);
    	panel2.add(TxtEmp_Name1);
    	panel2.add(TxtEmp_Name2);
    	
    	
    	panel3 = new JPanel();
    	panel3.setLayout(new FlowLayout());
    	
    	LblEmp_Desi = new JLabel("Designation :");
    	TxtEmp_Desi = new JTextField(20);
    	TxtEmp_Desi.setEditable(false);
    	
    
    	panel3.add(LblEmp_Desi);
    	panel3.add(TxtEmp_Desi);
    	
    
    	
    	panel4 = new JPanel();
    	panel4.setLayout(new FlowLayout());
    	
    	GenerateBtn = new JButton("Generate");
		GenerateBtn.addActionListener(this);
    	panel4.add(GenerateBtn);
    	
    

    	  ////// Report Variables
    
    	 
    	 

    	 Lblcollege2 = new JLabel("GOVT ENGINEERING COLLEGE AURANGABAD");
    	 Lbldate = new JLabel         ("   Date :");
    	 LblSalary_Slip = new JLabel  ("   Salary Slip :");
    	 LblBasic_Pay = new JLabel    ("   Basic Pay :");	
    	 LblAllowance = new JLabel    ("********** A  L  L  O  W  A  N  C  E ********");
    	 LblDeduction = new JLabel    ("********** D  E  D  U  C  T  I  O  N ********");	
    	 LblDA  = new JLabel          ("    DA :");
    	 LblHRA = new JLabel          ("    HRA :");
    	 LblWA  = new JLabel          ("    WA :");
    	 LblGPF = new JLabel          ("    GPF :");
    	 LblIT  = new JLabel          ("    IT :");
    	 LblGIS = new JLabel          ("    GIS :");
    	 LblPF  = new JLabel          ("    PF :");
    	 LblLIC = new JLabel          ("    LIC :");
    	 LblTot_Allowance = new JLabel("    Total Allowances :");
    	 LblTot_Deduction = new JLabel("    Total Deduction  :");
    	 LblNet_Salary = new JLabel   ("    Net Salary       :");
    	   
    
    	 TxtDate = new JTextField(10);
    	 
    	 TxtSalary_Month = new JTextField(20);
    	 TxtBasic_Pay = new JTextField(10);
    	 TxtDA = new JTextField(5);
    	 TxtHRA = new JTextField(5);
    	 TxtWA = new JTextField(5);
    	 TxtGPF = new JTextField(5);
    	 TxtIT = new JTextField(5);
    	 TxtGIS = new JTextField(5);
    	 TxtPF = new JTextField(5);
    	 TxtLIC = new JTextField(5);
    	 TxtTot_Allowance = new JTextField(6);
    	 TxtTot_Deduction = new JTextField(6);
    	 TxtNet_Salary = new JTextField(6);
    	 
    	 TxtDate.setEditable(false);
    	 TxtSalary_Month.setEditable(false);
    	 TxtBasic_Pay.setEditable(false);
    	 TxtDA.setEditable(false);
    	 TxtHRA.setEditable(false);
    	 TxtWA.setEditable(false);
    	 TxtGPF.setEditable(false);
    	 TxtIT.setEditable(false);
    	 TxtGIS.setEditable(false);
    	 TxtPF.setEditable(false);
    	 TxtLIC.setEditable(false);
    	 
    	 TxtTot_Allowance.setEditable(false);
    	 TxtTot_Deduction.setEditable(false);
    	 TxtNet_Salary.setEditable(false);
    	 
    	 
    	 
    	 
    	 panel5 = new JPanel();
    	 panel5.setLayout(new FlowLayout());
    	 panel5.add(Lblcollege2, BorderLayout.CENTER);
    	 
    	 
    	 panel5_1 = new JPanel();
    	 panel5_1.setLayout(new GridLayout(3,3));
    	 panel5_1.add(Lbldate);
    	 panel5_1.add(TxtDate);
    	 
    	
    	 panel5_1.add(LblSalary_Slip, "CENTER");
    	 panel5_1.add(TxtSalary_Month,"RIGHT");
    	 
    	 
    	 
    	 panel5_1.add(LblBasic_Pay,"LEFT");
    	 panel5_1.add(TxtBasic_Pay,"CENTER");
    	 
    	 panel7 = new JPanel();
    	 panel7.setLayout(new FlowLayout());
    	    	 
    	 panel7.add(LblAllowance, "CENTER");
    	 
    	 
    	 panel8_1 = new JPanel();
    	 panel8_1.setLayout(new GridLayout(3,2));
    	 panel8_1.add(LblDA);
    	 panel8_1.add(TxtDA);
    	 panel8_1.add(LblHRA);
    	 panel8_1.add(TxtHRA);
    	 panel8_1.add(LblWA);
    	 panel8_1.add(TxtWA);
    	 
    	 panel9 = new JPanel();
    	 panel9.setLayout(new GridLayout(1,3));
    	 
    	 panel9.add(LblTot_Allowance, "EAST");
    	 panel9.add(TxtTot_Allowance, "EAST");
    	     	 
    	 panel10 = new JPanel();
    	 panel10.setLayout(new FlowLayout());
    	 panel10.add(LblDeduction, "CENTER");
    	 
    	 panel11 = new JPanel();
    	 panel11.setLayout(new GridLayout(5,5));
    	 panel11.add(LblGPF);
    	 panel11.add(TxtGPF);
    	 panel11.add(LblIT);
    	 panel11.add(TxtIT);
    	 panel11.add(LblGIS);
    	 panel11.add(TxtGIS);
    	 panel11.add(LblPF);
    	 panel11.add(TxtPF);
    	 panel11.add(LblLIC);
    	 panel11.add(TxtLIC);
    	 
    	 panel12 = new JPanel();
    	 panel12.setLayout(new GridLayout(1,3));
    	 
    	 panel12.add(LblTot_Deduction);
    	 panel12.add(TxtTot_Deduction);
    	 
    	 panel13 = new JPanel();
    	 panel13.setLayout(new FlowLayout());
    	 panel13.add(LblNet_Salary);
    	 panel13.add(TxtNet_Salary);
    	 
    	 
		
		panel14 = new JPanel();
    	panel14.setLayout(new FlowLayout());
    	
    	PrintBtn = new JButton("Preview", new ImageIcon("images/prints.png"));
    	PrintBtn.addActionListener(this);
		ExitBtn = new JButton("Exit", new ImageIcon("images/exit.png"));
		ExitBtn.addActionListener(this);
    	
    	panel14.add(PrintBtn);
    	panel14.add(ExitBtn);
    	
       
   			Container pane = getContentPane();
    		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
			pane.add(panel1);
			pane.add(panel2);
			pane.add(panel3);
			pane.add(panel4);
			pane.add(panel5);
			pane.add(panel5_1);
			pane.add(panel7);
			pane.add(panel8_1);
			
			pane.add(panel9);
			pane.add(panel10);
			pane.add(panel11);
			pane.add(panel12);
			pane.add(panel13);
			pane.add(panel14);
			
			
		
       		setFrameIcon(new ImageIcon( "images/New.gif"));
       	 setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       	 pack();	
       
     }
    
    public void actionPerformed(ActionEvent event)
    {
    		Object source = event.getSource();
    	
    				if ( source  == MonthCombo)
    	{
				
    			String Emp_Month = (String)MonthCombo.getSelectedItem();
    			
    			
    		
    	}
    	
    	if (source == PrintBtn)
    	{
    		printwindow prn = new printwindow();
    		prn.fill_data(sEmp_Name1,sEmp_Name2,Emp_Month, Emp_Year,sEmp_Code,sDate,
    					  sEmp_Desi, sBasic_Pay, sDA_Allow, sHRA_Allow, sWA_Allow,
    					  sGPF_Dedu, sIT_Dedu, sGIS_Dedu, sPF_Dedu,sLIC_Dedu , sAllow, sDedu, sNet_Salary );
       
       
       
       
    	}
    			
    	if (source == GenerateBtn)
    	{
    		sEmp_Code = TxtEmp_Code.getText().trim();
    		Get_Data(sEmp_Code);
    		Generate_Report(sEmp_Desi);
    		
    		
    	}
    	   	
    	if (source == ExitBtn)
    	{
    		setVisible (false);
    		dispose();
    		    		
    	}
    		
    }
    

    public void Get_Data(String code)
    {
    			 	
		
		
		try {
                conn = connect.setConnection(conn,"","");
            }
            catch(Exception e)
            {
            }
				 try {
			    		
			    Statement stmt = conn.createStatement();          
    		
         if (!code.equals(""))
         {	
     			String query = "SELECT * FROM EMPLOYEE WHERE Emp_Code = '" + code +"'";
     		
                ResultSet rs = stmt.executeQuery(query);
                int foundrec = 0;
                while (rs.next())
                {
                		sEmp_Code = code;
                		sEmp_Name1 = rs.getString(2).trim();
                		sEmp_Name2 = rs.getString(3).trim();
						sEmp_Desi = rs.getString(4).trim();
						
						Emp_Month = (String)MonthCombo.getSelectedItem();
						Emp_Year = TxtYear.getText().trim();
						
						
						foundrec = 1;
                    	
                    	
                    	
                    
                }
                
     		if (foundrec == 0)
                {
                    dialogmessage = "No Such Employuee";
                                   
                    dialogtype = JOptionPane.WARNING_MESSAGE;
                    JOptionPane.showMessageDialog((Component)null, dialogmessage, dialogs, dialogtype);
                   
                   
                }
                
         }
         else
         {
         			dialogmessage = "No Blank Field Allowed";
                                   
                    dialogtype = JOptionPane.WARNING_MESSAGE;
                    JOptionPane.showMessageDialog((Component)null, dialogmessage, dialogs, dialogtype);
                   
                   
         }    
		  
          
     		
			 }
				 catch(Exception e)
            {
                System.out.println("\nUnknown Error at Genrate_Data");
            }
           
           
				   
		 }
		 
		 
		 public void Generate_Report(String Desi)
		 {
		 	
		 	
		 	
		try {
                conn = connect.setConnection(conn,"","");
            }
            catch(Exception e)
            {
            }
				 try {
			    		
			    Statement stmt = conn.createStatement();          
    		
         if (!Desi.equals(""))
         {	
     			String query = "SELECT * FROM Settings WHERE Category_Name = '" + Desi +"'";
     			 
                ResultSet rs = stmt.executeQuery(query);
                int foundrec = 0;
              
                while (rs.next())
                {
                	
                sCategory_Type = rs.getString(1).trim();
                sCategory_Name = rs.getString(2).trim();
                vBasic_Pay = rs.getInt(3); 
                	               
				sDA = rs.getString(4).trim();
				sHRA = rs.getString(5).trim();
				sWA = rs.getString(6).trim();
				sGPF = rs.getString(7).trim();
				sIT = rs.getString(8).trim();
				sGIS = rs.getString(9).trim();
				sPF = rs.getString(10).trim();
				sLIC = rs.getString(11).trim();
              

                DA_Value = rs.getInt(12);
    			HRA_Value = rs.getInt(13);
    			WA_Value = rs.getInt(14);
    			GPF_Value = rs.getInt(15);
    			IT_Value = rs.getInt(16);
    			GIS_Value = rs.getInt(17);
    			PF_Value = rs.getInt(18);
    			LIC_Value = rs.getInt(19);
    		
    			
    			if (sDA.equals("true") )
    			{
    				DA_Rs =  vBasic_Pay*DA_Value/100;
    		
    			}
    			else
    			{
    				DA_Rs = DA_Value;
    			
    			}
    			
    			if (sHRA.equals("true"))
    			{
    				HRA_Rs = (vBasic_Pay * HRA_Value) / 100;	
    			}
    			else
    			{
    				HRA_Rs = HRA_Value;
    			}
    			
    			if (sWA.equals("true"))
    			{
    				WA_Rs = (vBasic_Pay * WA_Value) / 100;	
    			}
    			else
    			{
    				WA_Rs = WA_Value;
    			}
    			
    			if (sGPF.equals("true"))
    			{
    				GPF_Rs = (vBasic_Pay * GPF_Value) / 100;	
    			}
    			else
    			{
    				GPF_Rs = GPF_Value;
    			}
    			
    			if (sIT.equals("true"))
    			{
    				IT_Rs = (vBasic_Pay * IT_Value) / 100;	
    			}
    			else
    			{
    				IT_Rs = IT_Value;
    			}
    			
    			if (sGIS.equals("true"))
    			{
    				GIS_Rs = (vBasic_Pay * GIS_Value) / 100;	
    			}
    			else
    			{
    				GIS_Rs = GIS_Value;
    			}
    			
    				if (sPF.equals("true"))
    			{
    				PF_Rs = (vBasic_Pay * PF_Value) / 100;	
    			}
    			else
    			{
    				PF_Rs = PF_Value;
    			}
    			
    			
    				if (sLIC.equals("true"))
    			{
    				LIC_Rs = (vBasic_Pay * LIC_Value) / 100;	
    			}
    			else
    			{
    				LIC_Rs = LIC_Value;
    			}
    			
    		
    			
    			Allow = DA_Rs + HRA_Rs + WA_Rs;
    			Dedu = GPF_Rs + IT_Rs + GIS_Rs + PF_Rs + LIC_Rs;
    			Net_Salary = (vBasic_Pay + Allow) - Dedu ;
    		
    			
    			sBasic_Pay = Integer.toString(vBasic_Pay);
    			sDA_Allow = Integer.toString(DA_Rs);
    			sHRA_Allow = Integer.toString(HRA_Rs);
    			sWA_Allow = Integer.toString(WA_Rs);
    			sGPF_Dedu = Integer.toString(GPF_Rs);
    			sIT_Dedu = Integer.toString(IT_Rs);
    			sGIS_Dedu = Integer.toString(GIS_Rs);
    			sPF_Dedu = Integer.toString(PF_Rs);
    			sLIC_Dedu = Integer.toString(LIC_Rs);
    			sAllow = Integer.toString(Allow);
    			sDedu = Integer.toString(Dedu);
    			sNet_Salary = Integer.toString(Net_Salary);
    			
    			///// Feeding values to the form
				 TxtDate.setText(sDate);    			
    			TxtEmp_Name1.setText(sEmp_Name1);
    			TxtEmp_Name2.setText(sEmp_Name2);
    			TxtSalary_Month.setText("For the Month of " + Emp_Month + " , " + Emp_Year);
    			TxtEmp_Code.setText(sEmp_Code);
    			TxtEmp_Desi.setText(sEmp_Desi);
    			
    			TxtBasic_Pay.setText(sBasic_Pay);
    			
    			TxtDA.setText(sDA_Allow);
    			TxtHRA.setText(sHRA_Allow);
    			TxtWA.setText(sWA_Allow);
    			TxtTot_Allowance.setText(sAllow);
    			
    			TxtGPF.setText(sGPF_Dedu);
    			TxtIT.setText(sIT_Dedu);
    			TxtGIS.setText(sGIS_Dedu);
    			TxtPF.setText(sPF_Dedu);
    			TxtLIC.setText(sLIC_Dedu);
    			TxtTot_Deduction.setText(sDedu);
    			TxtNet_Salary.setText(sNet_Salary);
    			
    			
    			
    			 
    			foundrec = 1;
                    
                }
                
     		if (foundrec == 0)
                {
                    dialogmessage = "No Such Employuee";
                                   
                    dialogtype = JOptionPane.WARNING_MESSAGE;
                    JOptionPane.showMessageDialog((Component)null, dialogmessage, dialogs, dialogtype);
                  
                   
                }
                
         }
         else
         {
         			dialogmessage = "No Blank Field Allowed";
                                   
                    dialogtype = JOptionPane.WARNING_MESSAGE;
                    JOptionPane.showMessageDialog((Component)null, dialogmessage, dialogs, dialogtype);
                   
                   
         }    
		  conn.close();
          
     		
			 }
				 catch(Exception e)
            {
                System.out.println("\nUnknown Errorat Generate -report");
            }
           
           		   
		 }	
		
		 	 
	
	
	 
	
}	 	
	
  	
   	 	
		 
    

