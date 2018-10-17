/**
 * BSTNodeMain.java
 * @author Ivan Andreev
 *
 */

/**
 * A class to test BSTNode.java
 */
public class BSTNodeMain 
{
	public static void main(String[] args)
	{
		// generate 3 people
		Profile person1=new Profile("Peter Peter",10, 11, 1960, "Swansea", "United Kingdom", "Bulgarian",
				new String[] {"anime", "video games"});

		Profile person2=new Profile("John John",10, 11, 1960, "Swansea", "United Kingdom", "Bulgarian",
				new String[] {"anime", "video games"});

		Profile person3=new Profile("Andrey Andreev",10, 11, 1960, "Swansea", "United Kingdom", "Bulgarian",
				new String[] {"anime", "video games"});
		
		// create a simple tree with a root and 2 children
		BSTNode root=new BSTNode(person1);
		root.setLeft(new BSTNode(person2));
		root.setRight(new BSTNode(person3));
		
		// test
		System.out.println(root.getProfile().getName());
		System.out.println("left child - " + root.getLeft().getProfile().getName());
		System.out.println("right child - " + root.getRight().getProfile().getName());
		
	}
}
