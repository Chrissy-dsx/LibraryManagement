package Question12;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CLI // use to run the interactive text- based interface of my program
{
	private static Scanner input = new Scanner(System.in);
	
	public static String readLine(String message) // read a whole line of text from the user of the program and returns the text
	{
		System.out.print(message);
		return input.nextLine(); // read the next line from user
	}
	
	public static int readPosInt(String message) // read an integer from the user of the program
	{
		while(true) // Permanent cycle
		{
			System.out.print(message); // a message telling the user to type some integer
			try
			{
				int num = input.nextInt(); // read the next integer				
				if(num >= 0)
				{
					input.nextLine();
					return num;
				}
				else
				{
					System.out.println("Positive integers only!");
				}
			}
			catch(InputMismatchException e)
			{
				System.out.println("You must type an integer!");
				input.nextLine(); // read the newline character
			}
			
		}
	}
	
	public static void main(String[] args) // print a menu that allows the user of your system to do six different actions
	{
		Library lib = new Library("UIC Library");
		while(true)
		{
			// automatically repeat the menu and ask the user to type an integer again
			int action = readPosInt("Type an action (total:1 add:2 get:3 more:4 less:5 quit:6): ");
			switch(action)
			{
				case 1: 
					// printing the total number of books borrowed by all users
					System.out.println("Total number of borrowed books: "+ lib.totalBorrowedBooks());
					break;
				
				case 2:
					//  adding a new user to the library
					int get = readPosInt("Type the user role (lender:1 borrower:2): ");
					
					try 
					{
						if(get == 1) // user choose lender
						{    
							 String name = readLine("Enter the name of the user: "); // give the name to the user
							 int iniBook =  readPosInt("Enter the initial number of borrowed books: "); // give the initial number to the user
							 Lender lend = new Lender(name, iniBook); // create a Lender
							 lib.addUser(lend);
							 System.out.println("Lender \"" + name + "\" lending " + iniBook + " book(s) has been added.");
						}
						else if(get == 2) // user choose borrower
						{
							String name = readLine("Enter the name of the user: "); // give the name to the user
							int iniBook =  readPosInt("Enter the initial number of borrowed books: "); // give the initial number to the user
							Borrower borrow = new Borrower(name, iniBook);//create the user
							lib.addUser(borrow);//add the user to the library
							System.out.println("Borrower \"" + name + "\" borrowing " + iniBook + " book(s) has been added.");
						}
						else
						{
							System.out.println("Unknown user role!");
						}
					}
					
					catch(NotALenderException e) // handle the error
					{
						System.out.println("BUG! This must never happen!");
						System.exit(1); // immediately terminating the program
					}
					break;
					
				case 3:
					// get the number of books borrowed by a given user
					String name3 = readLine("Enter the name of the user: "); // find user name
					try
					{
						System.out.println(name3 + " borrows " + lib.getBook(name3) + " book(s)");
					}
					catch(UnknownUserException e)
					{
						System.out.println("User " + name3 + " unknown");
					}
					break;
					
				case 4:
					// increasing the number of books of a given user
					String name4 = readLine("Enter the name of the user: "); // find user name
					int iniBook4 = readPosInt("Enter the number of books: "); // increase books
					try
					{
						lib.moreBook(name4, iniBook4);
					}
					catch(UnknownUserException e) // the name of the user is wrong
					{
						System.out.println("User " + name4 + " unknown.");
					} 
					catch (NotALenderException e) 
					{
						System.out.println("BUG! This must never happen!");
						System.exit(1); // immediately terminating the program
					}
					break;
					
				case 5:
					// decreasing the number of books of a given user
					String name5 = readLine("Enter the name of the user: "); // find user name
					int iniBook5 = readPosInt("Enter the number of books: "); // decrease books
					try
					{
						lib.moreBook(name5, -iniBook5); // decreasing books by a negative number
					}
					catch(UnknownUserException e) // the name of the user is wrong
					{
						System.out.println("User " + name5 + " unknown.");
					} 
					catch (NotALenderException e) 
					{
						System.out.println(e.getMessage()); // some user can't generate books
					}
					break;
					
				case 6:
					// quitting the program
					System.out.println("Goodbye!");
                    System.exit(0);
							
				default:
					System.out.println("Unknown action!");
			}
		}
	}
}
