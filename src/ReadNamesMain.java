/**
 * ReadNamesMain.java
 * @author Ivan Andreev
 *
 */
import java.util.ArrayList;
/**
 * A class to test ReadNames.java
 */
public class ReadNamesMain 
{
	public static void main(String[] args)
	{
		String filename="names.txt";
		ArrayList<FriendsPair> friends=ReadNames.readNames(filename);
		
		for(FriendsPair fp : friends)
		{
			System.out.println(fp.getName1() + " - " + fp.getName2());
		}
		
		// test error handling when the file doesn't exist
		ReadNames.readNames("doesntexist.txt");
	}
}
