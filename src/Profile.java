/**
 * Profile.java
 * @author Ivan Andreev
 *
 */
import java.util.ArrayList;
/**
 * A class to implement a user's profile.
 * Each user has name, birth date, town and country of residence,
 * nationality, interests and is connected to their friends.
 */
public class Profile 
{
	/**
	 * Name of the user.
	*/
	private String name;
	
	/**
	 * Information about the user's birthday.
	 */
	private int birthDay;
	private int birthMonth;
	private int birthYear;
	
	/**
	 * The town in which they currently reside in.
	 */
	private String town;
	
	/**
	 * The country in which they currently reside in.
	 */
	private String country;
	
	/**
	 * A user's current nationality.
	 */
	private String nationality;
	
	/**
	 * A list of the user's interests.
	 */
	private String[] interests;
	
	/**
	 * A list of the user's friends.
	 */
	private ArrayList<Profile> friends;
	
	/**
	 * True if the person is already in the party tree (for bigParty),
	 * false otherwise.
	 */
	private boolean isAtTheParty;
	
	/**
	 * Creates a Profile object.
	 * @param name the name of the user
	 * @param birthDay the day of birth of the user
	 * @param birthMonth the month of birth of the user
	 * @param birthYear the year of birth of the user
	 * @param town the town the user currently lives in
	 * @param country the country the user currently lives in
	 * @param nationality the nationality of the user
	 * @param interests a list of the user's interests
	 */
	public Profile(String name, int birthDay, int birthMonth, int birthYear,
			String town, String country, String nationality, String[] interests)
	{
		// set all the attributes
		this.name=name;
		this.birthDay=birthDay;
		this.birthMonth=birthMonth;
		this.birthYear=birthYear;
		this.town=town;
		this.country=country;
		this.nationality=nationality;
		this.interests=interests;
		
		// originally no one is at the party
		this.isAtTheParty=false;
		// initialize the friends arrayList
		this.friends=new ArrayList<Profile>();
	}
	
	/**
	 * Changes the town of residence of the user.
	 * @param town the new town
	 */
	public void setTown(String town)
	{
		this.town=town;
	}
	
	/**
	 * Find the user's town of residence.
	 * @return the user's town of residence
	 */
	public String getTown()
	{
		return this.town;
	}
	
	/**
	 * Changes the country of residence of the user.
	 * @param country the new country
	 */
	public void setCountry(String country)
	{
		this.country=country;
	}
		
	/**
	 * Find a user's country.
	 * @return the user's country of residence
	 */
	public String getCountry()
	{
		return this.country;
	}
	
	
	/**
	 * Changes the user's nationality.
	 * @param nationality the new nationality
	 */
	public void setNationality(String nationality)
	{
		this.nationality=nationality;
	}
	
	/**
	 * Find a user's current nationality.
	 * @return the user's nationality
	 */
	public String getNationality()
	{
		return this.nationality;
	}
	
	/**
	 * Changes the user's interests.
	 * @param interests a list of the user's new interests
	 */
	public void setInterests(String[] interests)
	{
		this.interests=interests;
	}
	
	/**
	 * Find the user's interests.
	 * @return a list of the user's interests
	 */
	public String[] getInterests()
	{
		return this.interests;
	}
	
	/**
	 * Find a user's name.
	 * @return the user's name
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * Find a user's birthday
	 * @return the user's birthday formatted day.month.year
	 */
	public String getDateOfBirth()
	{
		String dateOfBirth=this.birthDay + "." + this.birthMonth
				+ "." +this.birthYear;
		return dateOfBirth;
	}
	
	/**
	 * Adds a friend to the user's friend list.
	 * @param p the new friend
	 */
	public void addFriend(Profile p)
	{
		this.friends.add(p);	
	}
	
	/**
	 * Find a user's friend.
	 * @param i the friend's number in the list of the user's friends
	 * @return the friend's profile
	 */
	public Profile getFriend(int i)
	{
		return this.friends.get(i);
	}
	
	/**
	 * Finds how many friends a user has.
	 * @return the number of friends
	 */
	public int numOfFriends()
	{
		return this.friends.size();
	}
		
	/**
	 * Prints information about the user.
	 */
	@Override
	public String toString()
	{
		String information = this.name + " is " + this.nationality
				+ ". They currently live in " + this.town + ", " + this.country
				+ ".\nTheir date of birth is "+ this.getDateOfBirth() +".\nThey have "
				+ this.numOfFriends() + " friends - ";
		
		/* add a user's friends' names to the information string
		 * firstly adds all but the last friend with "," in between and
		 * then adds the very last friend with "." at the end (and not "," behind it) 
		*/ 
		for(int i=0; i<this.numOfFriends()-1; i++)
		{
			information = information + this.getFriend(i).getName() + ", ";
		}
		
		if(this.numOfFriends()>0) // if there are 0 friends, this line will cause error
		{
			information = information + this.getFriend(this.numOfFriends()-1).getName();
		}
		
		information += ".\n";
		
		/*
		 * add a user's interests to the information String
		 * firstly adds all but the last interests with "," in between and
		 * then adds the very last interest with "." at the end (and no "," behind the very last interest)
		 */
		 information = information + this.name +" is interested in : ";
		 for(int i=0; i<this.interests.length -1; i++)
		 {
			 information = information + interests[i] + ", ";
		 }
		 
		 if(this.interests.length>0) // if there are 0 interests, this line will cause error
		 {
			 information = information + interests[this.interests.length-1];
		 }
		 information = information + ". \n";
		return information;
	}
	
	
	/**
	 * Says if a person is at the party.
	 * @return true if the person is at the party, false otherwise
	 */
	public boolean isAtParty()
	{
		return this.isAtTheParty;
	}
	
	/**
	 * Makes the person go to the party.
	 */
	public void setToParty()
	{
		this.isAtTheParty=true;
	}

}
