
/**
 * AlphaMain.java
 * @author Ivan Andreev
 *
 */

/**
 * A class to test BST printAll() method
 */
public class AlphaMain 
{
	public static void main(String[] args)
	{
		// tree from a File
		System.out.println("------- Test 1 ---------");
		BST fileTree=new BST();
		fileTree=FileReader.readProfiles("profiles.txt");
		
		fileTree.printAlphabetical();
		
		// hardcoded tree
		// generate people
		Profile p1=new Profile("aaa",10, 11, 1960, "Swansea", "United Kingdom", "Bulgarian",
				new String[] {"anime", "video games"});

		Profile p2=new Profile("bbb",10, 11, 1960, "Swansea", "United Kingdom", "Bulgarian",
				new String[] {"anime", "video games"});

		Profile p3=new Profile("ccc",10, 11, 1960, "Swansea", "United Kingdom", "Bulgarian",
				new String[] {"anime", "video games"});

		Profile p4=new Profile("ddd",10, 11, 1960, "Swansea", "United Kingdom", "Bulgarian",
				new String[] {"anime", "video games"});

		Profile p5=new Profile("eee",10, 11, 1960, "Swansea", "United Kingdom", "Bulgarian",
				new String[] {"anime", "video games"});

		Profile p6=new Profile("fff",10, 11, 1960, "Swansea", "United Kingdom", "Bulgarian",
				new String[] {"anime", "video games"});

		System.out.println("---Test 2----");
		// create a tree and insert profiles randomly
		BST tree= new BST();
		tree.insertProfile(p2);
		tree.insertProfile(p4);
		tree.insertProfile(p3);
		tree.insertProfile(p1);
		tree.insertProfile(p6);
		tree.insertProfile(p5);
		
		tree.printAlphabetical();
		
		System.out.println("-----Test 3-----('aaa' and 'bbb' repeated 2 times) ");
		// test with repeating names
		BST tree2=new BST();
		tree2.insertProfile(p1);
		tree2.insertProfile(p2);
		tree2.insertProfile(p3);
		tree2.insertProfile(p4);
		tree2.insertProfile(p6);
		tree2.insertProfile(p5);
		tree2.insertProfile(p2);
		tree2.insertProfile(p1);
		
		tree2.printAlphabetical();
	}
}
