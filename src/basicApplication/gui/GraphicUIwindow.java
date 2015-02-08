package basicApplication.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;


public class GraphicUIwindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private Map<String, JButton> buttons = new HashMap<String, JButton>();
	private Map<String, JTextArea> textAreas = new HashMap<String, JTextArea>();
	
	private DefaultTableModel model = new DefaultTableModel();
	private JTable table = new JTable(model);
	private Map<String, String> columns = new HashMap<String, String>();
	
	private Container container;
	
	public GraphicUIwindow()
	{
		setLayout();
		creatTextArea();
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
	
	public void createButtons()
	{
		buttons.put("TestButton", new JButton("TestButton"));
		addButtons("Exit");
		addButtons("Search Database");
		addButtons("Display Info");
	}
	
	public void addButtons(String string)
	{
		buttons.put(string, new JButton(string));
	}
	
	private void creatTextArea()
	{
		textAreas.put("mainTextBoxWindow", new JTextArea(10, 70));
		textAreas.put("LoggingTextBoxWindow", new JTextArea(10, 70));
		
		//------------------------ Giving the text area a dark line.
		textAreas.get("mainTextBoxWindow").setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		textAreas.get("LoggingTextBoxWindow").setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
	}
	
	public void createTableContent()
	{
		createColumsData();
		model.addColumn(columns.get("ID"));
	}
	
	public void createColumsData()
	{
		addColumnToTable("ID", "ID");
		addColumnToTable("lastname", "LastName");
	}
	
	private void addColumnToTable(String key, String value)
	{
		columns.put(key, value);
	}
	
	public void postitioningTheCoponentsInJFrame()
	{
		//---------------------- Invoke the creation method of components
		creatTextArea();
		createButtons();
		createTableContent();
		
		container = this.getContentPane();
		container.setLayout(null);
		
		
		//---------------------- Adding and positioning the components 
		container.add(textAreas.get("mainTextBoxWindow"));
		textAreas.get("mainTextBoxWindow").setBounds(250, 30, 700, 300);
		
//		container.add(table);
//		table.setBounds(250, 30, 700, 300);
		
		container.add(textAreas.get("LoggingTextBoxWindow"));
		textAreas.get("LoggingTextBoxWindow").setBounds(250, 350, 700, 170);
		
		container.add(buttons.get("Search Database"));
		buttons.get("Search Database").setBounds(30, 30, 200, 50);
		
		container.add(buttons.get("Display Info"));
		buttons.get("Display Info").setBounds(30, 90, 200, 50);
		
		container.add(buttons.get("Exit"));
		buttons.get("Exit").setBounds(30, 150, 200, 50);
	}
	
	public void initialiseButtonsWithActions()
	{
		buttons.get("Search Database").addActionListener(new SerachButtonActionListenerClass());
	}
	
	private class SerachButtonActionListenerClass implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			SearchOptionDialogBox optionDialogBox = new SearchOptionDialogBox();
			optionDialogBox.setLayoutOfSearchOptionDialogBox();
		}
	}
}
