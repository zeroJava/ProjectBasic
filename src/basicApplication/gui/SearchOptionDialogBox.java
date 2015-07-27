package basicApplication.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import basicApplication.databaseEngine.DatabaseSearchEng;
import basicApplication.utilitiesEngine.HibernateUtilitiess;

public class SearchOptionDialogBox extends JDialog{
	
	private static final long serialVersionUID = 7405652935608262033L;
	
	private GraphicUIwindow minGUI;
	
	private SessionFactory factory;
	
	private Map<String, JTextField> textFields = new HashMap<String, JTextField>();
	private Map<String, JRadioButton> radioButtons = new HashMap<String, JRadioButton>();
	private Map<String, JButton> buttons = new HashMap<String, JButton>();
	private ButtonGroup buttonGroup = new ButtonGroup();
	
	private static String searchOption = null;
	private static String searchValue = null;
	private boolean stateOfTextField = true;
	
	private Container container;
	
	//public enum selections { ID, FIRSTNAME, LASTNAME }
	
	public SearchOptionDialogBox(GraphicUIwindow gui)
	{
		this.minGUI = gui;
		factory = HibernateUtilitiess.getSessionFactory();
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
		
		buttonGroup.add(radioButtons.get("ID"));
		buttonGroup.add(radioButtons.get("FirstName"));
		buttonGroup.add(radioButtons.get("LastName"));
		buttonGroup.add(radioButtons.get("All"));
		
		buttons.put("Close", new JButton("Close"));
	}
	
	public void positionComponents()
	{
		intialiseVaraibles();
		
		container = this.getContentPane();
		container.setLayout(null);
		
		container.add(textFields.get("Search Text Area"));
		setEditableTextField(true);
		textFields.get("Search Text Area").setBounds(30, 20, 300, 50);
		textFields.get("Search Text Area").setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		setOfTextField(stateOfTextField, false, false);
		
		container.add(radioButtons.get("ID"));
		radioButtons.get("ID").setBounds(30, 70, 50, 50);
		
		container.add(radioButtons.get("FirstName"));
		radioButtons.get("FirstName").setBounds(80, 70, 100, 50);
		
		container.add(radioButtons.get("LastName"));
		radioButtons.get("LastName").setBounds(180, 70, 100, 50);
		
		container.add(radioButtons.get("All"));
		radioButtons.get("All").setBounds(280, 70, 70, 50);
		
		container.add(buttons.get("Close"));
		buttons.get("Close").setBounds(340, 25, 100, 40);
	}
	
	public void setEditableTextField(boolean state)
	{
		textFields.get("Search Text Area").setEditable(state);
	}
	
	private void setOfTextField(boolean currentStateOfTxtField, boolean newStateOfTxtField, boolean setEditable)
	{
		if(currentStateOfTxtField)
		{
			stateOfTextField = newStateOfTxtField;
			setEditableTextField(setEditable);
		}
	}
	
	public void addActionToRadioButtons()
	{
		radioButtons.get("ID").addActionListener(new RadioButtonActionListener());
		radioButtons.get("FirstName").addActionListener(new RadioButtonActionListener());
		radioButtons.get("LastName").addActionListener(new RadioButtonActionListener());
		radioButtons.get("All").addActionListener(new RadioButtonActionListener());
	}
	
	public void addActionToButtons()
	{
		buttons.get("Close").addActionListener(new SearchButtonActionListener());
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[] > decisionToSearch(Session session, String option, String value)
	{
		List<Object[] > list = null;
		switch(option)
		{
			case "All":
				list = (List<Object[]>) DatabaseSearchEng.retrieveAllActors(session);
				return list;
			
			case "ID":
				int id = Integer.parseInt(value);
				list = (List<Object[]>) DatabaseSearchEng.retrieveAllActorsWithID(session, id);
				return list;
				
			case "FirstName":
				list = (List<Object[]>) DatabaseSearchEng.retrieveAllActorWithFirstName(session, value);
				return list;
				
			case "LastName":
				list = (List<Object[]>) DatabaseSearchEng.retrieveAllActorsWithLastName(session, value);
				return list;
				
			default:
				list = null;
				break;
		}
		return list;
	}
	
	private class RadioButtonActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			switch (e.getActionCommand())
			{
				case "All":
					searchOption = e.getActionCommand();
					setOfTextField(stateOfTextField, false, false);
					break;
					
				case "FirstName":
					searchOption = e.getActionCommand();
					setOfTextField(!stateOfTextField, true, true);
					break;
					
				case "LastName":
					searchOption = e.getActionCommand();
					setOfTextField(!stateOfTextField, true, true);
					break;
					
				case "ID":
					//setSearchOption(e.getActionCommand());
					searchOption = e.getActionCommand();
					setOfTextField(!stateOfTextField, true, true);
					break;
					
				default:
					break;
			}
		}
	}
	
	private class SearchButtonActionListener implements ActionListener
	{	
		@Override
		public void actionPerformed(ActionEvent e)
		{
			Session session = null;
			Transaction transaction = null;
			try
			{
				session = factory.openSession();
				transaction = session.beginTransaction();
				searchValue = textFields.get("Search Text Area").getText();
				if(!searchOption.isEmpty() && !searchValue.isEmpty())
				{
					List<Object[]> list = decisionToSearch(session, searchOption, searchValue);
					minGUI.setValueFromData(list); //http://www.dreamincode.net/forums/topic/305238-pass-info-from-jdialog-to-jframe/
				}
				transaction.commit();
			}
			catch(HibernateException he)
			{
				System.out.println(he.getMessage());
			}
			finally
			{
				session.close();
			}
			dispose();
		}	
	}
}
