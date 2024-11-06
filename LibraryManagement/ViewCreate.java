package Question12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ViewCreate extends View<ControllerCreate>
{
	private JTextField t1; // the text field where the user can type text
	private JTextField t2;
	private JComboBox<String> cb; // the combo box where the user can select one option from a menu
	
	public ViewCreate(Library m, ControllerCreate c)
	{
		super(m, c);
		this.setTitle("View Create");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close the window
		this.setLocationRelativeTo(null); // center horizontally
		this.setLayout(new GridLayout(4, 1)); // 4 rows 1 column
		JTextField t1 = new JTextField("Type a new user name here");
		this.add(t1);
		JTextField t2 = new JTextField("Type a number of books here");
		this.add(t2);
		cb =new JComboBox<String>(); 
		this.add(cb);
		cb.addItem("Lender"); // add lender type
		cb.addItem("Borrower"); // add borrower type
		
		JButton b = new JButton("Create");
		this.add(b);
		b.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String action=c.create(t1.getText(), t2.getText(), cb.getSelectedIndex());
				if (!action.equals(""))
				{
					JOptionPane.showMessageDialog(null, action, "Message", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});	
		this.setVisible(true);
	}
	
	public void update()
	{
		
	}
}
