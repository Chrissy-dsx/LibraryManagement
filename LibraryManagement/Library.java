package Question12;

import java.util.ArrayList;

public class Library 
{
	private String name;
	private ArrayList<IUser> users = new ArrayList<IUser>(); // the array list does not contain any user
	private ArrayList<ModelListener> listener = new ArrayList<ModelListener>();
	private ArrayList<Integer> history = new ArrayList<Integer>();
	
	public Library(String name)
	{
		this.name = name;
		history.add(0,0); // when the library is created, it has no books being lent or borrowed
	}
	
	public void addUser(IUser user) // adds the user to the array list of users for the library
	{
		users.add(user);
		notifyListeners(); // every time a change is made to the library's data
		history.add(totalBorrowedBooks());
	}
	
	public int totalBorrowedBooks() // returns the total number of books borrowed by all users of the library
	{
		int sum = 0;
		for(IUser user: users) // for each IUser user in array users
		{
			sum = sum + user.getBook();
		}
		return sum;
	}
	
	public int getBook(String name) throws UnknownUserException // returns the number of books currently borrowed by the user
	{
		for(IUser user: users)
		{
			if(user.getName().equals(name)) // the library have a user with the given name
			{
				return user.getBook();
			}
		}
		throw new UnknownUserException("User " + name + " unknown.");
	}
	
	public void moreBook(String name, int number) throws UnknownUserException, NotALenderException 
	{
		// changes the number of books currently borrowed by that user
		for(IUser user: users)
		{
			if(user.getName().equals(name)) // the library have a user with the given name
			{
				user.moreBook(number);
				notifyListeners(); // every time a change is made to the library's data
				history.add(totalBorrowedBooks());
				return; // jump out of the loop
			}
		}
		throw new UnknownUserException("User " + name + " unknown.");
	}
	
	public static void testLibrary() 
	{
		Library li = new Library("UIC Library");
		System.out.println(li.totalBorrowedBooks() == 0);
		li.addUser(new Lender("L1", 10));
		try 
		{
			System.out.println(li.getBook("L1") == -10);
			System.out.println(li.totalBorrowedBooks() == -10);
			li.addUser(new Borrower("B1", 20));
			System.out.println(li.getBook("L1") == -10);
			System.out.println(li.getBook("B1") == 20);
			System.out.println(li.totalBorrowedBooks() == 10);
			li.getBook("B2");
		} 
		catch(UnknownUserException ex) 
		{
			System.out.println(ex.getMessage().equals("User B2 unknown."));
		} 
		catch(NotALenderException ex) 
		{
			// This should never happen!
			System.out.println(false);
		}
	}
	
	public void addListener(ModelListener listeners) // adds it to the array list of listeners
	{
		listener.add(listeners);
	}
	
	private void notifyListeners() // update all the listeners of the library
	{
		for(ModelListener l : listener)
		{
			l.update();
		}
	}
	
	public ArrayList<Integer> getHistory() // the library’s history
	{
		return history;
	}
}
