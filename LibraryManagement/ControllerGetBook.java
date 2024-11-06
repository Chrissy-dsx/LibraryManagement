package Question12;

public class ControllerGetBook extends Controller
{
	public ControllerGetBook (Library m)
	{
		super(m);
	}
	
	public String getBook(String name) // get the number of books currently borrowed by that user
	{
		try // check that querying the number of books of an unknown user correctly shows an error message
		{
			return Integer.toString(m.getBook(name)); // change string to integer
		}
		catch (UnknownUserException e)
		{
			return e.getMessage();
		}
		
	}

}
