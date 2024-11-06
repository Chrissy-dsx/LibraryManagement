package Question12;

public class GUI 
{
	public static void main(String[] args) 
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable()
    	{
    		public void run() 
    		{
    			Library l = new Library("UIC Library"); // create a model object
    			try 
    			{
					l.addUser(new Lender("Anna", 5)); // test a lender who has borrowed -5 books
					l.addUser(new Borrower("Bob", 10)); // test a borrower who has borrowed 10 books
				} 
    			catch (NotALenderException e) 
    			{
    				System.out.println("Warning! This will never happen");
				}
    			ControllerSimple cs = new ControllerSimple(l); // create a ControllerSimple object
    			ViewSimple vs = new ViewSimple(l, cs); // create a ViewSimple object

    			ControllerGetBook cgb = new ControllerGetBook(l); // create a ControllerGetBook object
				ViewGetBook vgb = new ViewGetBook(l, cgb); // create a ViewGetBook object
				
				ControllerMoreBook cmb = new ControllerMoreBook(l); // create a ControllerMoreBook object
				ViewMoreBook vmb = new ViewMoreBook(l, cmb); // create a ViewMoreBook object
				
				ControllerCreate cc = new ControllerCreate(l); // create a ControllerCreate object
				ViewCreate vc = new ViewCreate(l, cc); // create a ViewCreate object
				
				ControllerHistory ch = new ControllerHistory(l); // create a ControllerHistory object
				ViewHistory vh = new ViewHistory(l, ch); // create a ViewHistory object
    		}	
    	});
	}
}
