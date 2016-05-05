package tasktimer;

import java.io.InputStream;

/**
 * 
 * open words file as InputStream
 * @author Piromsurang
 *
 */
public class Dictionary {
	
	/**
	 * 
	 * @return InputStream of text file
	 */
	public static InputStream getWordsAsStream() {
		InputStream instream = TaskTimer.class.getClassLoader().getResourceAsStream( "wordlist.txt" );
		
		return instream;
	}
}
