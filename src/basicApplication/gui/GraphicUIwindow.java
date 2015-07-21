package basicApplication.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;


public class GraphicUIwindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private Map<String, JButton> buttons = new HashMap<String, JButton>();
	private Map<String, JTextArea> textAreas = new HashMap<String, JTextArea>();
	
	private DefaultTableModel model;
	private JTable table;
	private Vector<Object> columns = new Vector<Object>();
	private Vector<Object> rows = new Vector<Object>();
	private JScrollPane scrollPane;
	private JPanel panel;
	
	private Container container;
	
	public GraphicUIwindow()
	{
		setLayout();
		createTextAreaAndTable();
		postitioningTheCoponentsInJFrame();
		initialiseButtonsWithActions();
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
		createTextAreaAndTable();
		createButtons();
		createTableContent();
		
		container = this.getContentPane();
		container.setLayout(null);
		
		//---------------------- Adding and positioning the components ---------------------------------------
		
		//container.add(textAreas.get("mainTextBoxWindow")); leave this just in-case we want to revert back to JTextarea area from JTable.
		//textAreas.get("mainTextBoxWindow").setBounds(250, 30, 700, 300);
		
		container.add(scrollPane);
		scrollPane.setBounds(250, 30, 700, 300); // setting the location to 205 x and 30 y; and the size to 700 width and 300 height. 
		
		container.add(textAreas.get("LoggingTextBoxWindow"));
		textAreas.get("LoggingTextBoxWindow").setBounds(250, 350, 700, 170);
		
		container.add(buttons.get("Search Database"));
		buttons.get("Search Database").setBounds(30, 30, 200, 50);
		
		container.add(buttons.get("Display Info"));
		buttons.get("Display Info").setBounds(30, 90, 200, 50);
		
		container.add(buttons.get("Exit"));
		buttons.get("Exit").setBounds(30, 150, 200, 50);
	}
	
	public void createButtons()
	{
		/* Generate the button, by assigning them values --------- */
		buttons.put("TestButton", new JButton("TestButton"));
		addButtons("Exit");
		addButtons("Search Database");
		addButtons("Display Info");
	}
	
	public void addButtons(String string)
	{
		buttons.put(string, new JButton(string));
	}
	
	public Map<String, JButton> getButtons()
	{
		return buttons;
	}
	
	private void createTextAreaAndTable()
	{
		/* generating the text area and table, by assigning them values */ 
		//textAreas.put("mainTextBoxWindow", new JTextArea(10, 70)); this text area has been replace with a table.
		textAreas.put("LoggingTextBoxWindow", new JTextArea(10, 70));
		
		table = new JTable();
		model = new DefaultTableModel(0, 0);
		scrollPane = new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(700, 300));
		table.setFillsViewportHeight(true);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportView(table);
		
		/* ------------------------- Giving the text area a dark line.--------------------------------------*/
		//textAreas.get("mainTextBoxWindow").setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		scrollPane.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		textAreas.get("LoggingTextBoxWindow").setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
	}
	
	public void createTableContent()
	{
		createColumsData();
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		for(int i = 0; i < 100; i++)
		{
			rows.add("" + i);
		}
		model.addRow(rows);
		model.addRow(rows);
		model.addRow(rows);
	}
	
	public void createColumsData()
	{
		columns.add("ID");
		columns.add("FirstName");
		columns.add("LastName");
	}
		
	public void initialiseButtonsWithActions()
	{
		buttons.get("Search Database").addActionListener(new SerachButtonActionListenerClass());
	}
	
	private class SerachButtonActionListenerClass implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			//SearchOptionDialogBox optionDialogBox = new SearchOptionDialogBox();
			//optionDialogBox.setLayoutOfSearchOptionDialogBox();
			
		}
	}
}
