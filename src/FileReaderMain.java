/**
 * FileReaderMain.java
 * @author Ivan Andreev
 *
 */

/**
 * A class to test FileReader.java
 * 
 */
public class FileReaderMain 
{
	public static void main(String[] args)
	{
		String filename="profiles.txt";
		
		// construct the tree
		BST tree=new BST();
		tree=FileReader.readProfiles(filename);
		
		// test
		tree.printAlphabetical();
		
		// test when the file doesn't exist
		FileReader.readProfiles("doesntexist.txt");
	}
	

}
