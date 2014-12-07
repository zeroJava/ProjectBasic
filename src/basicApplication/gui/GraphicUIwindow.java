package basicApplication.gui;

import javax.swing.JFrame;

public class GraphicUIwindow extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public GraphicUIwindow()
	{
		setLayout();
	}

	private void setLayout()
	{
		setTitle("zeroJava - Window");
		setSize(1000, 600);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
