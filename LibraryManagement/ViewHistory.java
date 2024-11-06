package Question12;

import javax.swing.JFrame;

public class ViewHistory extends View<ControllerHistory>
{
	public ViewHistory(Library m, ControllerHistory c)
	{
		super(m,c);
		this.setTitle("View History");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close the window
		this.setLocationRelativeTo(null); // center horizontally
		HistoryPanel h = new HistoryPanel(m);
		this.add(h);
		this.setVisible(true);
	}
	
	public void update() // redraw everything every time the model changes
	{
		repaint();
	}
}