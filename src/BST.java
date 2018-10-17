/**
 * BST.java
 * @author Ivan Andreev
 *
 */

/**
 * A class to implement a Binary Search Tree.
 * 
 */
public class BST 
{
	/**
	 * The root of the tree.
	 */
	private BSTNode root;
	
	/**
	 * Creates a BST object.
	 * Empty constructor.
	 */
	public BST()
	{
	}
	
	
	/**
	 * Inserts a Profile object into the tree.
	 * @param p the profile that we want to insert
	 */
	public void insertProfile(Profile p)
	{
		BSTNode nodeToInsert=new BSTNode(p);
		
		if(root==null)
		{
			root=nodeToInsert;
		}
		else
		{
			insertNode(nodeToInsert);
		}
	}
	
	/**
	 * A method to insert a node into the tree.
	 * Calls insertNode(recursive method) from the root.
	 * @param insert the node to be inserted
	 */
	private void insertNode(BSTNode insert)
	{
		insertNode(this.root, insert);
	}
	
	/**
	 * A recursive method to insert a node into the tree.
	 * @param currentPosition the current node we are looking at
	 * @param insert the node to be inserted
	 */
	private void insertNode(BSTNode currentPosition, BSTNode insert)
	{
		
		//  insertName <= currentPositionName
		if(insert.getProfile().getName().compareTo(currentPosition.getProfile().getName()) <= 0)
		{
			
			// if the left child is empty, then we have found where to insert the node
			if(currentPosition.getLeft()==null)
			{
				currentPosition.setLeft(insert);
				return;
			}
			
			// we haven't found where to insert the node, so keep searching
			insertNode(currentPosition.getLeft(), insert);
			
		}
		// insertName > currentPositionName
		else if(insert.getProfile().getName().compareTo(currentPosition.getProfile().getName()) > 0)
		{
			// if the right child is empty, we have found where to insert the node
			if(currentPosition.getRight()==null)
			{
				currentPosition.setRight(insert);
				return;
			}
			
			// we haven't found where to insert the node, so we keep searching
			insertNode(currentPosition.getRight(), insert);
		}
	}
	
	/**
	 * Prints out the names of all the people in the tree
	 * in alphabetical order.
	 */
	public void printAlphabetical()
	{
		inorderPrint(this.root);
	}
	
	/**
	 * A recursive method to go through the tree
	 * with an inorder traversal. Prints the names of the
	 * nodes that we visit.
	 * @param current the current node we are at
	 */
	private void inorderPrint(BSTNode current)
	{
		if(current==null)
		{
			return;
		}
		
		inorderPrint(current.getLeft());
		System.out.println(current.getProfile().getName());
		inorderPrint(current.getRight());
	}
	
	
	/**
	 * Finds and returns the profile of a person, based on name.
	 * @param name the name of the person
	 * @return searchedProfile the profile of the person or null if it doesn't exist
	 */
	public Profile find(String name)
	{
		Profile searchedProfile=null;
		
		BSTNode current=root;
		boolean found=false;

		/*
		 * We are looking through a Binary Search Tree, so:
		 * if the name we are looking for is equal to the current Node's name, we are done
		 * if the name we are looking for is smaller than the current Node's name, search in the left subtree
		 * if the name we are looking for is bigger than the current Node's name, search in the right subtree
		 */
		while(current!=null && !found)
		{
			if(name.compareTo(current.getProfile().getName())==0)
			{
				searchedProfile=current.getProfile();
				found=true;
			}
			else if(name.compareTo(current.getProfile().getName())<0)
			{
				current=current.getLeft();
			}
			else if(name.compareTo(current.getProfile().getName())>0)
			{
				current=current.getRight();
			}
		}
		
		return searchedProfile;
	}
}
