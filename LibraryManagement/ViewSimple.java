package Question12;

import javax.swing.*;

public class ViewSimple extends View<ControllerSimple> implements ModelListener // registers the view with the library
{
	private JLabel label;
	
	public ViewSimple(Library m, ControllerSimple c) 
	{
		super(m, c);
		// displays the current value of the total number of books borrowed by all users of the library
		this.setTitle("View Simple");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close the window
		this.setLocationRelativeTo(null); // center horizontally
		label = new JLabel();
		label.setText("total number of borrowed books: " + m.totalBorrowedBooks());
		update();
		this.add(label);
		this.setVisible(true);
	}
	
	public void update() // updates the text of the label as necessary
	{
		label.setText("total number of borrowed books: " + m.totalBorrowedBooks());
	}
}
