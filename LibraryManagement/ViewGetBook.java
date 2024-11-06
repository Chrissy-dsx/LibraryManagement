package Question12;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ViewGetBook extends View<ControllerGetBook>
{
	private JTextField t; // where the user can type text
	
	public ViewGetBook(Library m, ControllerGetBook c)
	{
		super(m, c);
		this.setTitle("View GetBook");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close the window
		this.setLocationRelativeTo(null); // center horizontally
		this.setLayout(new GridLayout(2, 1)); // 2 rows 1 column
		// shows the text field called and a button
		JTextField t = new JTextField("Type a user name here");
		JButton b = new JButton("Tell me the book number");
		this.add(t);
		this.add(b);
		b.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(null, c.getBook(t.getText()));
			}
		});
		this.setVisible(true);
		
	}
	
	public void update()
	{
		
	}

}
