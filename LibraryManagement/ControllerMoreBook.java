package Question12;

public class ControllerMoreBook extends Controller
{
	public ControllerMoreBook(Library m)
	{
		super(m);
	}
	
	public String moreBook(String name, String number)
	{
		try
		{
			m.moreBook(name, Integer.parseInt(number)); // transforms the number of books from a string to an integer
			return ""; // returns the empty string
		}
		catch (UnknownUserException e) // catch this exception and return as result the error message from the exception object
		{
			return e.getMessage();
		}
		catch (NotALenderException e) // catch this exception and return as result the error message from the exception object
		{
			return e.getMessage(); 
		}
		catch (NumberFormatException e) // catch this exception and return as result the error message from the exception object
		{
			return e.getMessage();
		}
	}
}
