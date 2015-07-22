package basicApplication.gui;

import javax.swing.JDialog;

public class SearchOptionDialogBox extends JDialog{
	
	public enum selections 
	{
		ID, FIRSTNAME, LASTNAME
	}
	
	private static final long serialVersionUID = 7405652935608262033L;
	
	public SearchOptionDialogBox()
	{
		//this.setLayoutOfSearchOptionDialogBox();
	}
	
	public void setLayoutOfSearchOptionDialogBox()
	{
		setTitle("Filter you search");
		setVisible(true);
		setSize(500, 300);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	@SuppressWarnings("unused")
	private void selectFilteredSearchOption()
	{
		
	}
}
