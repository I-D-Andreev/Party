/**
 * GraphMain.java
 * @author Ivan Andreev
 *
 */
import java.util.ArrayList;
import java.io.*;
/**
 * A class to test Graph.java
 */
public class GraphMain 
{
	public static void main(String[] args)
	{
		// -------- TEST WITH WORKING INPUT ----------
		System.out.println("---------TEST 1-----------");
		
		/* NOTE: The file "input and expected output.txt" explains 
		 * the input and output used in this test case.
		 */
		
		BST tree=FileReader.readProfiles("profiles.txt");
		Graph g=null; // shut compiler
		try
		{
			g=new Graph("names.txt", tree);
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
			System.exit(0);
		}

		ArrayList<Profile> invitations = new ArrayList<Profile>();
		
		// invite A1, B1 and C1
		invitations.add(tree.find("A1"));
		invitations.add(tree.find("B1"));
		invitations.add(tree.find("C1"));
		
		BST partyTree=g.bigParty(invitations);
		
		partyTree.printAlphabetical();
		
		System.out.println();
		// ---------- END OF TEST 1 --------
			
		// ----------- TEST 2 -------------
		//the 1st name of one of the pairs doesn't exist; (A4,A1) pair, where A4 doesn't exist
		System.out.println("----------TEST 2---------");
		
		try
		{
			new Graph("namesFirstWrong.txt", tree);
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		
		System.out.println();
		// ----------- END OF TEST 2--------------
		
		// ----------- TEST 3-------------
		//the 2nd name of one of the pairs doesn't exist; (A1,A6) pair, where A6 doesn't exist
		System.out.println("----------TEST 3---------");
		
		try
		{
			new Graph("namesSecondWrong.txt", tree);
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}

		System.out.println();
		// ----------- END OF TEST 3--------------
		
		// ----------- TEST 4-------------
		//both 1st and 2nd name of one of the pairs doesn't exist (A4,A5) pair
		System.out.println("--------TEST 4 ------------");
		
		try
		{
			new Graph("namesBothWrong.txt", tree);
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		
		// ----- END OF TEST 4 --------
		
		
		// ----------- TEST 5-------------
		//the file doesn't exist
		System.out.println("--------TEST 5 ------------");
		
		try
		{
			new Graph("doesntexist.txt", tree);
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		
		// ----- END OF TEST 5 --------
		
	}
}
