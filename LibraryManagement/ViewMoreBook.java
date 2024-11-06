package Question12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ViewMoreBook extends View<ControllerMoreBook>
// add a new “more book” view that allows the user of the system to increase the number of book borrowed or lent by the user of a specific user
{
	private JTextField t1; // text field where the user can type text
	private JTextField t2;
	
	public ViewMoreBook(Library m, ControllerMoreBook c)
	{
		super(m, c);
		this.setTitle("View More Book");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close the window
		this.setLocationRelativeTo(null); // center horizontally
		this.setLayout(new GridLayout(3, 1)); // use grid layout manager to position the three components
		JTextField t1 = new JTextField("Type a user name here");
		this.add(t1);
		JTextField t2 = new JTextField("Type a number of books here");
		this.add(t2);
		JButton b = new JButton("More Book");
		this.add(b);
		
		b.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(!c.moreBook(t1.getText(), t2.getText()).equals(""))// controller is different from the empty string "" 
				{
					// this string displayed back to the user using a message dialog 
					JOptionPane.showMessageDialog(null, c.moreBook(t1.getText(), t2.getText()), "Message", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		this.setVisible(true);
	}
	
	public void update()
	{
		
	}
}
