/**
 * BSTNode.java
 * @author Ivan Andreev
 *
 */

/**
 * A class to implement a binary search tree node.
 * Each node has data (of type Profile), a left child and a right child.
 */
public class BSTNode 
{
	/**
	 * The data to be stored in the node.
	 */
	private Profile data;
	
	/**
	 * A reference to the left child of the node.
	 */
	private BSTNode left;
	
	/**
	 * A reference to the right child of the node.
	 */
	private BSTNode right;
	
	
	/**
	 * Creates a BSTNode object.
	 * @param data the data stored in the node
	 */
	public BSTNode(Profile data)
	{
		this.data=data;
	}
	
	/**
	 * Retrieve the data stored in the current node.
	 * @return the Profile data
	 */
	public Profile getProfile()
	{
		return this.data;
	}
	
	/**
	 * Change the left child of the node.
	 * @param left the new left child
	 */
	public void setLeft(BSTNode left)
	{
		this.left=left;
	}
	
	/**
	 * Find the left child of the node.
	 * @return the left child
	 */
	public BSTNode getLeft()
	{
		return this.left;
	}
	
	/**
	 * Change the right child of the node.
	 * @param right the new right child
	 */
	public void setRight(BSTNode right)
	{
		this.right=right;
	}
	
	/**
	 * Find the right child of the node.
	 * @return the new right child
	 */
	public BSTNode getRight()
	{
		return this.right;
	}
	
}
