/**
 * Main.java
 * @author Ivan Andreev
 *
 */

/**
 *	A class to test Profile.java. 
 *
 */
public class ProfileMain 
{
	public static void main(String[] args)
	{
		// generate the tested person
		Profile person= new Profile("Ivan Andreev",10, 11, 1960, "Swansea", "United Kingdom", "Bulgarian",
				new String[] {"anime", "video games"});
				
		// generate his friends
		Profile friend1=new Profile("Peter Peter",10, 11, 1960, "Swansea", "United Kingdom", "Bulgarian",
				new String[] {"anime", "video games"});

		Profile friend2=new Profile("John John",10, 11, 1960, "Swansea", "United Kingdom", "Bulgarian",
				new String[] {"anime", "video games"});

		Profile friend3=new Profile("Andrey Andreev",10, 11, 1960, "Swansea", "United Kingdom", "Bulgarian",
				new String[] {"anime", "video games"});
		
		person.addFriend(friend1);
		person.addFriend(friend2);
		person.addFriend(friend3);
		
		System.out.println(person.toString());
		
		Profile friend4=person.getFriend(2);
		System.out.println(friend4.toString());

	}
}
