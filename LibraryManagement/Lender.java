package Question12;

public class Lender extends User
{
	public Lender(String name, int book) // takes as arguments a name and the number of books lent by the user
	{
		super(name, -book); // lending books is the same as borrowing a negative number of books
	}
	
	public void moreBook(int number) // the number of books lent by the lender user by the number given
	{
		setBook(getBook() - number);
	}
	
	public static void testLender()
	{
		Lender l = new Lender("Anna",5);
		System.out.println(l.getName() == "Anna");
		System.out.println(l.getBook() == -5);
		l.setBook(-6);
		System.out.println(l.getBook() == -6);
		l.moreBook(2);
		System.out.println(l.getBook() == -8);
		l.moreBook(-9);
		System.out.println(l.getBook() == 1);
	}

}
