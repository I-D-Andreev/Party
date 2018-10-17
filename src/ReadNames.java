/**
 * ReadNames.java
 * @author Ivan Andreev
 *
 */

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * A class to read the names of friends
 * from a file.
 * Format is:
 * <friend1>,<friend2> 
 */
public class ReadNames
{
	/**
	 * The path to the files' location from the project's folder.
	 */
	private static final String PATH="src/data/";
	
	/**
	 * Reads information from a file and puts it into an ArrayList of type FriendsPair.
	 * @param filename the name of the file, from which we will read
	 * @return the ArrayList with names
	 */
	public static ArrayList<FriendsPair> readNames(String filename)
	{
		// Opening file.
		File inputFile=new File(PATH + filename);
		
		// create a Scanner to read from file
		Scanner in=ReadNames.createScanner(inputFile);
		
		// call readDataFile, which will construct the ArrayList for us
		return ReadNames.readDataFile(in);
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
	 * Reads the data file used by the program and returns
	 * an ArrayList with the names in pairs
	 * @param in the scanner of the file
	 * @return friends the ArrayList with the names of friends in pairs
	 */
	private static ArrayList<FriendsPair> readDataFile(Scanner in)
	{
		ArrayList<FriendsPair> friends=new ArrayList<>();
		
		// read the file line by line
		while(in.hasNextLine())
		{
			// Scanner to read 1 line; closed before end of while loop
			String currentLine=in.nextLine();
			Scanner line=new Scanner(currentLine);
			
			// makes the scanner separate the information in the line by ","
			line.useDelimiter(",");
			
			// create a FriendsPair from the line and insert it into the ArrayList
			FriendsPair fp=createFriendsPair(line);
			friends.add(fp);
			
			line.close();
		}
		
		return friends;
	}
	
	/**
	 * Creates a FriendsPair object from a single line, containing the names of the two friends.
	 * @param line the line containing the names
	 * @return a FriendsPair object
	 */
	private static FriendsPair createFriendsPair(Scanner line)
	{
		// get the name of friend1
		String name1=line.next();
		
		// get the name of friend2
		String name2=line.next();
		
		return new FriendsPair(name1,name2);
	}
}
