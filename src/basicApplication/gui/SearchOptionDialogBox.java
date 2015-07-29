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
		this.minGUI = gui; // this will ensure the presence of the main GUI is present during this sub-process
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
		textFields.put(GUIConstance.SearchValueTextField, new JTextField(70));
		
		radioButtons.put(GUIConstance.ID, new JRadioButton(GUIConstance.ID));
		radioButtons.put(GUIConstance.FIRST_NAME, new JRadioButton(GUIConstance.FIRST_NAME));
		radioButtons.put(GUIConstance.LAST_NAME, new JRadioButton(GUIConstance.LAST_NAME));
		radioButtons.put(GUIConstance.ALL, new JRadioButton(GUIConstance.ALL));
		
		buttonGroup.add(radioButtons.get(GUIConstance.ID));
		buttonGroup.add(radioButtons.get(GUIConstance.FIRST_NAME));
		buttonGroup.add(radioButtons.get(GUIConstance.LAST_NAME));
		buttonGroup.add(radioButtons.get(GUIConstance.ALL));
		
		buttons.put("Search", new JButton("Search"));
	}
	
	public void positionComponents()
	{
		intialiseVaraibles();
		
		container = this.getContentPane();
		container.setLayout(null);
		
		container.add(textFields.get(GUIConstance.SearchValueTextField));
		setEditableTextField(true);
		textFields.get(GUIConstance.SearchValueTextField).setBounds(30, 20, 300, 50);
		textFields.get(GUIConstance.SearchValueTextField).setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		setOfTextField(stateOfTextField, false, false);
		
		container.add(radioButtons.get(GUIConstance.ID));
		radioButtons.get(GUIConstance.ID).setBounds(30, 70, 50, 50);
		
		container.add(radioButtons.get(GUIConstance.FIRST_NAME));
		radioButtons.get(GUIConstance.FIRST_NAME).setBounds(80, 70, 100, 50);
		
		container.add(radioButtons.get(GUIConstance.LAST_NAME));
		radioButtons.get(GUIConstance.LAST_NAME).setBounds(180, 70, 100, 50);
		
		container.add(radioButtons.get(GUIConstance.ALL));
		radioButtons.get(GUIConstance.ALL).setBounds(280, 70, 70, 50);
		
		container.add(buttons.get("Search"));
		buttons.get("Search").setBounds(340, 25, 100, 40);
	}
	
	public void setEditableTextField(boolean state)
	{
		textFields.get(GUIConstance.SearchValueTextField).setEditable(state);
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
		radioButtons.get(GUIConstance.ID).addActionListener(new RadioButtonActionListener());
		radioButtons.get(GUIConstance.FIRST_NAME).addActionListener(new RadioButtonActionListener());
		radioButtons.get(GUIConstance.LAST_NAME).addActionListener(new RadioButtonActionListener());
		radioButtons.get(GUIConstance.ALL).addActionListener(new RadioButtonActionListener());
	}
	
	public void addActionToButtons()
	{
		buttons.get("Search").addActionListener(new SearchButtonActionListener());
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[] > decisionToSearch(Session session, String option, String value)
	{
		List<Object[] > list = null;
		switch(option)
		{
			case GUIConstance.ALL:
				list = (List<Object[]>) DatabaseSearchEng.retrieveAllActors(session);
				return list;
			
			case GUIConstance.ID:
				int id = Integer.parseInt(value);
				list = (List<Object[]>) DatabaseSearchEng.retrieveAllActorsWithID(session, id);
				return list;
				
			case GUIConstance.FIRST_NAME:
				list = (List<Object[]>) DatabaseSearchEng.retrieveAllActorWithFirstName(session, value);
				return list;
				
			case GUIConstance.LAST_NAME:
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
				case GUIConstance.ALL:
					searchOption = e.getActionCommand();
					setOfTextField(stateOfTextField, false, false);
					break;
					
				case GUIConstance.FIRST_NAME:
					searchOption = e.getActionCommand();
					setOfTextField(!stateOfTextField, true, true);
					break;
					
				case GUIConstance.LAST_NAME:
					searchOption = e.getActionCommand();
					setOfTextField(!stateOfTextField, true, true);
					break;
					
				case GUIConstance.ID:
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
				searchValue = textFields.get(GUIConstance.SearchValueTextField).getText();
				List<Object[]> list = null;
				if(searchOption.equals(GUIConstance.ALL))
				{
					list = decisionToSearch(session, searchOption, searchValue);
					minGUI.displayLog("Eecuted all saerch ");
				}
				else if(!searchOption.isEmpty() && !searchValue.isEmpty())
				{
					list = decisionToSearch(session, searchOption, searchValue);
					minGUI.displayLog("Eecuted all search " + searchOption + " With value " + searchValue);
				}
				
				if(list != null)
				{
					minGUI.setValueFromData(list); //http://www.dreamincode.net/forums/topic/305238-pass-info-from-jdialog-to-jframe/
					// action here will directly deal with the main GUI
					minGUI.displayLog("All Values Found, and displayed on table ");
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
