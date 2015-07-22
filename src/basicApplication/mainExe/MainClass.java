package basicApplication.mainExe;

import org.hibernate.SessionFactory;

import basicApplication.gui.GraphicUIwindow;
import basicApplication.utilitiesEngine.HibernateUtilitiess;

public class MainClass {

	public static void main(String[] args)
	{
		SessionFactory factory = HibernateUtilitiess.getSessionFactory();
		@SuppressWarnings("unused")
		GraphicUIwindow graphicUIwindow = new GraphicUIwindow(factory);
	}
}
