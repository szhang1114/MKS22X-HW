import java.io.*;
import java.util.*;
import java.io.FileNotFoundException;
public class test{
    public static void main(String args[]) throws FileNotFoundException{
	File infile = new File("maze1.txt");
	Scanner inf = new Scanner(System.in);
	int lineNumber = 1;
	while(inf.hasNextLine()){
	    String line = inf.nextLine();
	    System.out.println(line);
	    return;

	}   
    }
}
