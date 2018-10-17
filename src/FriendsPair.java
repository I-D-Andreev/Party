/**
 * FriendsPair.java
 * @author Ivan Andreev
 *
 */

/**
 * A class to implement a pair of friends.
 * Shows that friend1 and friend2 are friends.
 */
public class FriendsPair 
{
	/**
	 * Name of friend 1
	 */
	private String name1;

	/**
	 * Name of friend 2
	 */
	private String name2;
	
	/**
	 * Creates a FriendsPair object.
	 * @param friend1 name of first friend
	 * @param friend2 name of second friend
	 */
	public FriendsPair(String name1, String name2)
	{
		this.name1=name1;
		this.name2=name2;
	}
	
	/**
	 * Get the name of friend 1.
	 * @return the name of the first friend
	 */
	public String getName1()
	{
		return this.name1;
	}
	
	/**
	 * Get the name of friend2
	 * @return the name of the second friend
	 */
	public String getName2()
	{
		return this.name2;
	}
}
