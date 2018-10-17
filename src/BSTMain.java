/**
 * BSTMain.java
 * @author Ivan Andreev
 *
 */

/**
 * A class to test BST.java
 */
public class BSTMain 
{
	public static void main(String[] args)
	{
		// generate people
		Profile p1=new Profile("aaa",10, 11, 1960, "Swansea", "United Kingdom", "Bulgarian",
				new String[] {"anime", "video games"});

		Profile p2=new Profile("bbb",10, 11, 1960, "Swansea", "United Kingdom", "Bulgarian",
				new String[] {"anime", "video games"});

		Profile p3=new Profile("ccc",10, 11, 1960, "Swansea", "United Kingdom", "Bulgarian",
				new String[] {"anime", "video games"});

		Profile p4=new Profile("ddd",10, 11, 1960, "Swansea", "United Kingdom", "Bulgarian",
				new String[] {"anime", "video games"});

		System.out.println("---Test 1----");
		// create a tree and insert profiles randomly
		BST tree= new BST();
		tree.insertProfile(p2);
		tree.insertProfile(p4);
		tree.insertProfile(p3);
		tree.insertProfile(p1);
		
		// if the tree is working, they should be sorted by name
		// and no profiles should be missing
		tree.printAlphabetical();
		
		// test the find method
		Profile supposedlyP4=tree.find("ddd");
		System.out.println(supposedlyP4.toString());
	}
}
