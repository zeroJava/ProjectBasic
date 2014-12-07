package basicApplication.gui;

import javax.swing.JFrame;

public class GraphicUI extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public GraphicUI()
	{
		setLayout();
	}

	private void setLayout()
	{
		setTitle(getName());
		setSize(1000, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
