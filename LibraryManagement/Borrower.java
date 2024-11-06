package Question12;

public class Borrower extends User
{
	public Borrower(String name, int book) throws NotALenderException// takes a name and a number of books borrowed by the borrower
	{
		super(name, book);
		if(book < 0) // the number of books given as argument is strictly less than zero
		{
			throw new NotALenderException("A new borrower cannot lend books.");
		}
	}

	public void moreBook(int number) throws NotALenderException // the number of books borrowed by the borrower by the number of books given
	{
		if((getBook() + number) < 0)
		{
			throw new NotALenderException("A borrower cannot lend " + -(getBook() + number) + " book(s).");
		}
		else
		{
			setBook(getBook() + number);
		}
	}
	
	public static void testBorrower()
	{
		try
		{
			Borrower b = new Borrower("Bob",-1);
		} 
		catch(NotALenderException e)
		{
			System.out.println(e.getMessage().equals("A new borrower cannot lend books."));
		}
		try
		{
			Borrower b = new Borrower("Bob",10);
			System.out.println(b.getName()=="Bob");
			System.out.println(b.getBook()==10);
			b.setBook(5);
			System.out.println(b.getBook()==5);
			b.moreBook(2);
			System.out.println(b.getBook()==7);
			b.moreBook(-2);
			System.out.println(b.getBook()==5);
			b.moreBook(-5);
			System.out.println(b.getBook()==0);
			b.moreBook(-1);
		} 
		catch(NotALenderException e)
		{
			System.out.println(e.getMessage().equals("A borrower cannot lend 1 book(s)."));
		}
	}

}
