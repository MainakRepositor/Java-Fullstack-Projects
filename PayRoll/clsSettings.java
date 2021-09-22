import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class clsSettings
 { 	
 
	public JLabel setJLabel(JLabel lbl, int sLeft, int sTop, int sWidth, int sHeight, boolean setBool)
	{
		lbl.setBounds(sLeft,sTop,sWidth, sHeight);
		lbl.setFont(new Font("Dialog",Font.PLAIN,12));
		if(setBool == true){lbl.setForeground(new Color(166,0,0));}
		else{lbl.setForeground(java.awt.Color.BLACK);}
		return lbl;
	}//Set-up in JLabel
	public JTextField setJTextField(JTextField txtfield, int sLeft, int sTop, int sWidth, int sHeight)
	{
		txtfield.setBounds(sLeft,sTop,sWidth, sHeight);
		txtfield.setFont(new Font("Dialog",Font.PLAIN,12));
		txtfield.setSelectionColor(new Color(200,150,150));
		txtfield.setSelectedTextColor(new Color(0,0,0));
		return txtfield;
	}//Set-up in JTextField
	

	public JMenu setJMenu(JMenu menu)
	{
		menu.setFont(new Font("Dialog", Font.BOLD, 12)); 	
		menu.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menu.setForeground(new Color(0,0,0));
		return menu;
	}//Create a Menu
	public JMenuItem setJMenuItem(JMenuItem mnuitem, String sCaption, String imgLocation)
	{		
		mnuitem.setText(sCaption);
		mnuitem.setIcon(new ImageIcon(imgLocation));
		mnuitem.setCursor(new Cursor(Cursor.HAND_CURSOR));
		mnuitem.setFont(new Font("Dialog", Font.PLAIN, 12));  
		mnuitem.setForeground(new Color(0,0,0));
		return 	mnuitem;							
	}//Create a MenuItem
	public JTabbedPane setJTabbedPane(	JTabbedPane setTabbed, String setTitle, String setIcon, JPanel setPanel, int sLeft, int sTop, int sWidth, int sHeight)
	{
		setTabbed.setBounds(sLeft,sTop,sWidth, sHeight);
        setTabbed.setCursor(new Cursor(Cursor.HAND_CURSOR));
        setTabbed.setFont(new Font("Dialog", Font.CENTER_BASELINE, 12));
        setTabbed.setForeground(new Color(166,0,0));
        setTabbed.addTab(setTitle, new ImageIcon(setIcon), setPanel);
		return setTabbed;
	}//Create a JTabbedPane
	public JButton CreateJToolbarButton(String srcToolTipText,String srcImageLocation,String srcActionCommand, ActionListener JToolBarActionListener)
	{
		JButton bttnToolbar = new JButton(new ImageIcon(srcImageLocation));
		
		bttnToolbar.setActionCommand(srcActionCommand);
		bttnToolbar.setToolTipText(srcToolTipText);
		bttnToolbar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bttnToolbar.setFont(new Font("Dialog", Font.PLAIN, 12));
		bttnToolbar.addActionListener(JToolBarActionListener);
		return bttnToolbar;
	}//Create JToolbarButton
	
	
	public void Numvalidator(JTextField txtField)
	{
		
			txtField.addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent e) {
           char c = e.getKeyChar();
           if (!(Character.isDigit(c) ||
              (c == KeyEvent.VK_BACK_SPACE) ||
              (c == KeyEvent.VK_DELETE))) {
            // getToolkit().beep();
             e.consume();
           }
         }
       });
	}
	
	
	
	    	
    	  
}