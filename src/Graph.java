/**
 * Graph.java
 * @author Ivan Andreev
 *
 */
import java.util.ArrayList;
import java.io.IOException;
/**
 * A class to implement a graph.
 * A graph has a BST with people and a file with their connections.
 */
public class Graph 
{
	/**
	 * A binary search tree containing all the people.
	 */
	private BST tree;
		
	
	/**
	 * Creates a graph object.
	 * @param filename the name of the file that contains information about who is friends with who
	 * @param tree a binary search tree with all the people
	 * @throws IOException if any of the names in the file is not in our BST list of people
	 */
	public Graph(String filename, BST tree) throws IOException
	{
		this.tree=tree;
		
		// makes an ArrayList (that contains pairs with the names of friends) from the file   
		ArrayList<FriendsPair> friends=ReadNames.readNames(filename);
		
		// makes the relationships between the friends
		// if one or two of the friends don't exist, it will throw an exception
		createFriends(friends);
	}
	
	/**
	 * Creates the links in between all friends.
	 * @param friends an ArrayList stating who is friend with who
	 * @throws IOException if one of the two names in any friends pair doesn't exist in our BST of people
	 */
	private void createFriends(ArrayList<FriendsPair> friends) throws IOException
	{
		// for every pair of friends, create the link between them
		for(FriendsPair fp: friends)
		{
			make2PeopleFriends(fp);
		}
	}
	
	/**
	 * Establishes a friend relation between the two names in the FriendsPair.
	 * @param fp the FriendsPair containing the two names
	 * @throws IOException if one of the two names in the friends pair doesn't exist in our BST of people
	 */
	private void make2PeopleFriends(FriendsPair fp) throws IOException
	{
		// the names of the first and second friend
		String name1=fp.getName1();
		String name2=fp.getName2();
		
		// the profiles of the first and second friend
		Profile profile1=tree.find(name1);
		Profile profile2=tree.find(name2);
			
		// throw exception if one (or both) of the friends don't exist
		if(profile1==null || profile2==null)
		{
			if(profile1==null && profile2==null)
			{
				throw new IOException(name1 +" and " + name2 + " don't exist "
						+ "in the list of people");
			}
			else if(profile1==null)
			{
				throw new IOException(name1 + " doesn't exist in the list of people");
			}
			else if(profile2==null)
			{
				throw new IOException(name2 + " doesn't exist in the list of people");
			}
		}
		
		// Creates the friend relation
			profile1.addFriend(profile2);
			profile2.addFriend(profile1);
	}
	
	
	/**
	 * Invites a list of people and their friends to a party.
	 * @param invitations the list of people to be invited directly
	 * @return partyTree a BST with the people and their friends that will be invited
	 * @throws IOException if any Profile in the invitation list is null
	 */
	public BST bigParty(ArrayList<Profile> invitations)
	{
		
		BST partyTree=new BST();
		
		// firstly add the people, directly invited to the party,
		// if they are not already there
		for(Profile p: invitations)
		{
			if(!p.isAtParty())
			{
				partyTree.insertProfile(p);
				p.setToParty();
			}
		}
		
		// add their friends, if they are not already there
		for (Profile p: invitations)
		{
			for(int i=0; i < p.numOfFriends(); i++)
			{
				Profile friend = p.getFriend(i);
				if(!friend.isAtParty())
				{
					partyTree.insertProfile(friend);
					friend.setToParty();
				}
			}
		}
		
		return partyTree;
	}
		
}
