package Question12;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class HistoryPanel extends JPanel
{
	private Library m;
	
	public HistoryPanel(Library m)
	{
		this.m = m;
	}
	
	private int historyMax(ArrayList<Integer> a) // return as result the maximum number in the array list
	{
		int hMax = 0; // assume that the array list contains at least one number
		for (int i = 0; i < a.size(); i++)
		{
			if (hMax < a.get(i)) // if the number is bigger than hMax
			{
				hMax = a.get(i);
			}
		}
		return hMax; // now this number is the biggest
	}
	
	private int historyMin(ArrayList<Integer> a) // return as result the maximum number in the array list
	{
		int hMin = 0; // assume that the array list contains at least one number
		for (int i = 0; i < a.size(); i++)
		{
			if (hMin > a.get(i)) // if the number is less than hMin
			{
				hMin = a.get(i);
			}
		}
		return hMin; // now this number is the smallest
	}
	
	private int historyRange(ArrayList<Integer> a) // returns as result the difference between the hMax and hMin of the integers
	{
		if (historyMax(a) - historyMin(a) <= 10) // returns as result 10 if the difference between the man and min of the integers
		{
			return 10;
		}
		else
		{
			return historyMax(a) - historyMin(a);//return the true difference
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) // draw graphically how the total number of books borrowed by all users of the library changes over time
	{
		super.paintComponent(g);
        ArrayList<Integer> history = m.getHistory();
        int min = historyMin(history);
        int range = historyRange(history);
        int maxX = getWidth() - 1;
        int maxY = getHeight() - 1;
        int zero = maxY + min * maxY / range;
		g.setColor(Color.BLUE); // a blue line between the point (0, zero) and the point (maxX, zero)
		g.drawLine(0, zero, maxX, zero);
		for (int i = 1; i < m.getHistory().size(); i++)
		{
			int x = i * 10;
			int y = zero - m.getHistory().get(i) * maxY / range; // the vertical coordinate
			int x1 = (i - 1) * 10; // x's pre point
			int y1 = zero - m.getHistory().get(i - 1) * maxY / range; // y's pre point
			g.setColor(Color.red); // draw red lines between all the points (x, y)
			g.drawLine(x1, y1, x, y); // line the previous points
		}
	}
}
