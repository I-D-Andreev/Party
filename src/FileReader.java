/**
 * FileReader.java
 * @author Ivan Andreev
 *
 */

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * A class to read information from a file.
 * Format is:
 * <name>,<DD>,<MM>,<YY>,<Town>,<Country>,<Nationality>,<interest 1>;...;<interest n>
 */
public class FileReader 
{
	/**
	 * The path to the files' location from the project's folder.
	 */
	private static final String PATH="src/data/";
	
	/**
	 * A method to read information from a file and put it into a tree.
	 * @param filename the name of the file from which we will read
	 * @return tree a binary search tree with the data in filename
	 */
	public static BST readProfiles(String filename)
	{
		
		// Opening file.
		File inputFile=new File(PATH + filename);
		
		// create a Scanner to read from file
		Scanner in=FileReader.createScanner(inputFile);
			
		// call readDataFile, which will construct a tree for us
		return FileReader.readDataFile(in);
	}
	
	/**
	 * A method to create a scanner. Also, checks if the file
	 * is missing and exits the program in case of an error.
	 * @param inputFile the file from which we will read
	 * @return in the constructed scanner
	 */
	private static Scanner createScanner(File inputFile)
	{
		/// create Scanner to read from file and also check if the file exists
	    Scanner in = null;  // closes before the end of readDataFile
	    try 
	    {
	    	in=new Scanner(inputFile);
	    }
	    catch(FileNotFoundException e) 
	    {
	    	System.out.println("The file "+ inputFile.getName() + " can not be found!");
	    	System.exit(0);
	    }
	    
	    return in;
	}
	
	/**
	 * Reads the data file used by the program and returns the
	 * binary search tree with the data.
	 * @param in the scanner of the file
	 * @return tree a binary search tree with the profiles of the people form the file
	 */
	private static BST readDataFile(Scanner in)
	{
		BST tree=new BST();
		
		//read the file line by line
		while(in.hasNextLine())
		{
			// Scanner to read 1 line; closed before end of while loop
			String currentLine=in.nextLine();
			Scanner line=new Scanner(currentLine);
			
			// makes the scanner separate the information in the line by "," and ";"
			line.useDelimiter(",|;");
			
			// create a profile from the line and insert it into the tree
			Profile p=createProfile(line);
			tree.insertProfile(p);	
					
			line.close();
		}
		
		in.close();
		return tree;
	}
	
	/**
	 * Creates a profile from a single line, containing the information
	 * about the user.
	 * @param line  information about the profile
	 * @return p the profile
	 */
	private static Profile createProfile(Scanner line)
	{
		// get the name
		String name=line.next();
		
		// get the date of birth (dd,mm,yyy)
		int dayOfBirth=line.nextInt();
		int monthOfBirth=line.nextInt();
		int yearOfBirth=line.nextInt();
		
		// get the town and country
		String town=line.next();
		String country=line.next();
		
		// get the nationality
		String nationality=line.next();
		
		// get the interests
		String[] interests=createInterests(line);
		
		// create a profile object
		Profile p=new Profile(name, dayOfBirth, monthOfBirth, yearOfBirth,
				town, country, nationality, interests);
		
		return p;
	}
	
	
	/**
	 * A method that reads a line with the interests of a person
	 * and returns them in an array.
	 * @param line the line with the interests
	 * @return interests the array with the interests
	 */
	private static String[] createInterests(Scanner line)
	{
		// make an arrayList to save the interests as we don't know
		// how many there will be
		ArrayList<String> saveInterests=new ArrayList<String>();
		
		while(line.hasNext())
		{
			String interest=line.next();
			saveInterests.add(interest);
		}
		
		// convert the arrayList to an array
		String[] interests= saveInterests.toArray(new String[saveInterests.size()]);
		
		return interests;
	}
}
