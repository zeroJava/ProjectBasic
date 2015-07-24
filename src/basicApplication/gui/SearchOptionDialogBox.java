package basicApplication.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SearchOptionDialogBox extends JDialog{
	
	private static final long serialVersionUID = 7405652935608262033L;
	
	private Map<String, JTextField> textFields = new HashMap<String, JTextField>();
	private Map<String, JRadioButton> radioButtons = new HashMap<String, JRadioButton>();
	private Map<String, JButton> buttons = new HashMap<String, JButton>();
	
	private Container container;
	
	public enum selections { ID, FIRSTNAME, LASTNAME }
	
	public SearchOptionDialogBox()
	{
		this.setLayoutOfSearchOptionDialogBox();
	}
	
	public void setLayoutOfSearchOptionDialogBox()
	{
		setTitle("Filter your search");
		setVisible(true);
		setSize(500, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		positionComponents();
		addActionToRadioButtons();
		addActionToButtons();
	}
	
	public void intialiseVaraibles()
	{
		textFields.put("Search Text Area", new JTextField(70));
		radioButtons.put("ID", new JRadioButton("ID"));
		radioButtons.put("FirstName", new JRadioButton("FirstName"));
		radioButtons.put("LastName", new JRadioButton("LastName"));
		radioButtons.put("All", new JRadioButton("All"));
		buttons.put("Search", new JButton("Search"));
	}
	
	public void positionComponents()
	{
		intialiseVaraibles();
		
		container = this.getContentPane();
		container.setLayout(null);
		
		container.add(textFields.get("Search Text Area"));
		textFields.get("Search Text Area").setBounds(30, 20, 300, 50);
		textFields.get("Search Text Area").setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		container.add(radioButtons.get("ID"));
		radioButtons.get("ID").setBounds(30, 70, 50, 50);
		
		container.add(radioButtons.get("FirstName"));
		radioButtons.get("FirstName").setBounds(80, 70, 100, 50);
		
		container.add(radioButtons.get("LastName"));
		radioButtons.get("LastName").setBounds(180, 70, 100, 50);
		
		container.add(radioButtons.get("All"));
		radioButtons.get("All").setBounds(280, 70, 70, 50);
		
		container.add(buttons.get("Search"));
		buttons.get("Search").setBounds(340, 25, 100, 40);
	}
	
	public void addActionToRadioButtons()
	{
		radioButtons.get("ID").addActionListener(null);
		radioButtons.get("FirstName").addActionListener(null);
		radioButtons.get("LastName").addActionListener(null);
		radioButtons.get("All").addActionListener(null);
	}
	
	public void addActionToButtons()
	{
		buttons.get("Search").addActionListener(null);
	}
	
	private class RadioButtonActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			// TODO Auto-generated method stub
		}
	}
	
	private class SearchButtonActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			// TODO Auto-generated method stub	
		}	
	}
}
