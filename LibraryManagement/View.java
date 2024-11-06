package Question12;

import javax.swing.*;

public abstract class View <T extends Controller> extends JFrame implements ModelListener 
{
	protected Library m;
	protected T c;
	
	public View(Library m, T c)
	{
		this.m = m;
		this.c = c;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close the window
	}
	
	public abstract void update();
}
