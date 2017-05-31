import java.util.*;
public class Quiz2Redux{  
    /*Returns an ArrayList<String> that contains all subsets of the
     *characters of String s. Assume s has no duplicate characters.
     *the characters should appear in the same order that they occur 
     *in the original string.
     */
    public static ArrayList<String> combinations(String s){
	ArrayList<String>words = new ArrayList<String>();
	help( words, s, 0, "");
	Collections.sort(words);
	words.remove(0);
	return words;
    }
  
    private static void help( ArrayList<String> words, String s, int current, String in){
	if(current == 0){
	    words.add(" ");
	}
	if(current < s.length()){
	    words.add(in + s.charAt(current));
	    help(words, s, current + 1, in + s.charAt(current));
	    help(words, s, current + 1, in);
	}
    }
    
     public static void main(String [] args){
	Quiz2Redux x = new Quiz2Redux();
	System.out.println(combinations("ab"));
	System.out.println(combinations("abc"));
	System.out.println(combinations("abcd"));
    }
}
