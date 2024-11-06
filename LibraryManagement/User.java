package Question12;

public abstract class User implements IUser
{
	private String name; // indicates the user name
	private int book; // the number of books borrowed by the user
	
	public User(String name, int book)
	{
		this.name = name;
		this.book = book;
	}
	
	public String getName() // getter
	{
		return name;
	}
	
	public int getBook() // getter
	{
		return book;
	}
	
	protected void setBook(int book) // changes the number of books borrowed by the user
	{
		this.book = book;
	}
	
	public abstract void moreBook(int number) throws NotALenderException; // increase the number of books borrowed or lent by the user by the number
	
	public static void testUser()
	{
		// This is an abstract class, which cannot be instantiated.
	}

}
