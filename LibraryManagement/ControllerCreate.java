package Question12;

public class ControllerCreate extends Controller
{
	public ControllerCreate(Library m)
	{
		super(m);
	}
	
	public String create(String name, String number, int type)
	{
		try
		{
			if (type == 0) // lender type
			{
				Lender p = new Lender(name, Integer.parseInt(number)); // change string to integer
				m.addUser(p);
				return ""; // returns the empty string
			}
			
			else if (type == 1) // borrow type
			{
				try
				{
					Borrower h = new Borrower(name, Integer.parseInt(number));
					m.addUser(h);
					return ""; // returns the empty string
				}
				catch (NotALenderException e) // catch this exception and return as result the error message from the exception object
				{
					return e.getMessage(); 
				}
			}
			
			else
			{
				return "Warning! This will never happen";
			}
		}
		catch (NumberFormatException n) // catch this exception and return as result the error message from the exception object
		{
			return n.getMessage();
		}
	}
}
