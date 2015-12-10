package basicApplication.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import org.hibernate.SessionFactory;

import basicApplication.databaseEngine.LoggingEngine;


public class GraphicUIwindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private Map<String, JButton> buttons = new HashMap<String, JButton>();
	private Map<String, JTextArea> textAreas = new HashMap<String, JTextArea>();
	private Map<String, JScrollPane> scrollArea = new HashMap<String, JScrollPane>();
	
	private DefaultTableModel model;
	private JTable table;
	private Vector<Object> columns = new Vector<Object>();
	private Vector<Object[]> rows = new Vector<Object[]>();
	//private JScrollPane scrollPane;
	
	//private SessionFactory factory;
	
	private Container container;
	private LoggingEngine log;
	
	public GraphicUIwindow(SessionFactory factory)
	{
		//this.factory = factory;
		setLayout();
		initialiseTextAreaAndTable();
		postitioningTheCoponentsInJFrame();
		initialiseButtonsWithActions();
		log = new LoggingEngine();
		displayLog("All components are initialised ");
	}

	public void setLayout()
	{
		setTitle("zeroJava - Window");
		setSize(1000, 600);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void postitioningTheCoponentsInJFrame()
	{
		//---------------------- Generating the components ---------------------------------------------------
		initialiseTextAreaAndTable();
		initialiseButtons();
		createTableContent();
		
		container = this.getContentPane();
		container.setLayout(null);
		
		//---------------------- Adding and positioning the components ---------------------------------------
		
		//container.add(textAreas.get("mainTextBoxWindow")); leave this just in-case we want to revert back to JTextarea area from JTable.
		//textAreas.get("mainTextBoxWindow").setBounds(250, 30, 700, 300);
		
		//container.add(scrollPane);
		//scrollPane.setBounds(250, 30, 700, 300); // setting the location to 205 x and 30 y; and the size to 700 width and 300 height. 
		
		container.add(scrollArea.get(GUIConstance.ScrollForTable));
		scrollArea.get(GUIConstance.ScrollForTable).setBounds(250, 30, 700, 300); // setting the location to 205 x and 30 y; and the size to 700 width and 300 height. 
		
		container.add(scrollArea.get(GUIConstance.ScrollForTextArea));
		scrollArea.get(GUIConstance.ScrollForTextArea).setBounds(250, 350, 700, 170);
		
		//container.add(textAreas.get(GUIConstance.LoggingTextBoxWindow));
		//textAreas.get(GUIConstance.LoggingTextBoxWindow).setBounds(250, 350, 700, 170);
		
		container.add(buttons.get(GUIConstance.SearchDatabaseButton));
		buttons.get(GUIConstance.SearchDatabaseButton).setBounds(30, 30, 200, 50);
		
		container.add(buttons.get(GUIConstance.DisplayInfoButton));
		buttons.get(GUIConstance.DisplayInfoButton).setBounds(30, 90, 200, 50);
		
		container.add(buttons.get(GUIConstance.ExitApplicationButton));
		buttons.get(GUIConstance.ExitApplicationButton).setBounds(30, 470, 200, 50);
	}
	
	public void initialiseButtons()
	{
		/* Generate the button, by assigning them values --------- */
		//buttons.put("TestButton", new JButton("TestButton"));
		addButtons(GUIConstance.ExitApplicationButton);
		addButtons(GUIConstance.SearchDatabaseButton);
		addButtons(GUIConstance.DisplayInfoButton);
	}
	
	public void addButtons(String string)
	{
		buttons.put(string, new JButton(string));
	}
	
	public Map<String, JButton> getButtons()
	{
		return buttons;
	}
	
	private void initialiseTextAreaAndTable()
	{
		/* generating the text area and table, by assigning them values */ 
		//textAreas.put("mainTextBoxWindow", new JTextArea(10, 70)); this text area has been replace with a table.
		
		/* ------------------- creating the textareas and adding text area to scroll pane ------------------------- */
		
		textAreas.put(GUIConstance.LoggingTextBoxWindow, new JTextArea()); // (10, 70) old default value
		scrollArea.put(GUIConstance.ScrollForTextArea, new JScrollPane(textAreas.get(GUIConstance.LoggingTextBoxWindow)));
		textAreas.get(GUIConstance.LoggingTextBoxWindow).setSize(new Dimension(700, 170));
		
		/* ------------------- setting up scroll pane for text area ------------------------- */
		
		scrollArea.get(GUIConstance.ScrollForTextArea).setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollArea.get(GUIConstance.ScrollForTextArea).setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//scrollArea.get(GUIConstance.ScrollForTextArea).setViewportView(textAreas.get(GUIConstance.LoggingTextBoxWindow));
		
		/* ------------------- creating the table ------------------------- */
		
		table = new JTable();
		model = new DefaultTableModel(0, 0);
		scrollArea.put(GUIConstance.ScrollForTable, new JScrollPane(table));
		table.setPreferredScrollableViewportSize(new Dimension(700, 300));
		table.setFillsViewportHeight(true);
		table.setEnabled(false);
		
		/* ------------------- adding table to scroll ------------------------- */
		scrollArea.get(GUIConstance.ScrollForTable).setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollArea.get(GUIConstance.ScrollForTable).setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollArea.get(GUIConstance.ScrollForTable).setViewportView(table);
		
		/*----legacy code ----*/
		//scrollPane = new JScrollPane(table); legacy code
		//scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); legacy code
		//scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//scrollPane.setViewportView(table);
		
		
		/* ------------------------- Giving the text area a dark line.-------------------------------------- */
		scrollArea.get(GUIConstance.ScrollForTable).setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		scrollArea.get(GUIConstance.ScrollForTextArea).setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		//textAreas.get(GUIConstance.LoggingTextBoxWindow).setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		//textAreas.get("mainTextBoxWindow").setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		//scrollPane.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		// Borderfactory.createEmptyBorder() create empty space around the border.
	}
	
	public void createTableContent()
	{
		initialiseColumsData();
		model.setColumnIdentifiers(columns);
		table.setModel(model);
	}
	
	public void initialiseColumsData()
	{
		columns.add("ID");
		columns.add("FirstName");
		columns.add("LastName");
	}
	
	public void setValueFromData(List<Object[]> list)
	{
		if(!rows.isEmpty())
		{
			reValidateTable();
		}
		
		rows.addAll(list);
		
		for(int i = 0; i < rows.size(); i++)
		{
			model.addRow(rows.get(i));	
		}
	}
	
	public void reValidateTable()
	{
		rows.clear();
		model.fireTableDataChanged();
		model.setRowCount(0);
	}
	
	public void initialiseButtonsWithActions()
	{
		buttons.get(GUIConstance.SearchDatabaseButton).addActionListener(new SerachButtonActionListenerClass());
		buttons.get(GUIConstance.DisplayInfoButton).addActionListener(new DisplayInfoActionListner());
		buttons.get(GUIConstance.ExitApplicationButton).addActionListener(new ExitActionListener());
	}
	
	public void actionGUI()
	{
		new SearchOptionDialogBox(this);
	}
	
	public void displayLog(String text)
	{
		textAreas.get(GUIConstance.LoggingTextBoxWindow).append(text + " on " + Calendar.getInstance().getTime() + "\n");
		log.writeToFile(text + " on " + Calendar.getInstance().getTime() + "\n");
	}
	
	private class SerachButtonActionListenerClass implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			actionGUI();
			System.out.println("gdhg");
		}
	}
	
	private class DisplayInfoActionListner implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			displayLog("BasicApplication using hibernate.\n" + "Database: sakila\n" 
					+ "Table: actor\n" + "SQL type: mysql\n" + "open-source\n");
		}
	}
	
	private class ExitActionListener implements ActionListener
	{
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			displayLog("Exiting the application ");
			System.exit(0);	
		}
	}
}
