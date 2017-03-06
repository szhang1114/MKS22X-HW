import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;

public class Maze{
    private char[][]maze;
    private boolean animate;

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.

    */

    public Maze(String filename){
        //COMPLETE CONSTRUCTOR
	try{
	    File infile = new File(filename);
	    Scanner s = new Scanner(infile);
	    int lineNumber = 0;
	    int r = 1;
	    int c = s.nextLine().length();
	    while(s.hasNextLine()){
		s.nextLine();
		r ++;
	    }
	    maze = new char[r][c];
	    File file = new File(filename);
	    Scanner s2 = new Scanner(file);
	    while(lineNumber < r){
		String line = s2.nextLine();
		for(int counter = 0; counter < line.length(); counter ++){
		    maze[lineNumber][counter] = line.charAt(counter);
		}
		lineNumber ++;
	    }
	}catch (FileNotFoundException e){
	    System.out.println("File not found");
	}
    }
    


    public void setAnimate(boolean b){

        animate = b;

    }


    public void clearTerminal(){

        //erase terminal, go to top left of screen.

        System.out.println("\033[2J\033[1;1H");

    }



    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
        
	int[] start = findStart();
	int startr = start[0];
	int startc = start[1];
	//Initialize starting row and startint col with the location of the S.
	maze[startr][startc] = ' ';//erase the S, and start solving!
	return solve(startr,startc);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.


      Postcondition:

      The S is replaced with '@' but the 'E' is not.

      All visited spots that were not part of the solution are changed to '.'
      All visited spots that are part of the solution are changed to '@'
    */
    private boolean solve(int row, int col){
        if(animate){
            System.out.println("\033[2J\033[1;1H"+this);

	    wait(50);
	    
        }

	if(maze[row][col] == 'E'){
	    System.out.println("maze complete!");
	    return true;
	}

	if(maze[row][col] == '#'){
	    return false;
	}
	if(maze[row][col]== ' ' || maze[row][col] == 'S'){
	    maze[row][col] = '@';
	    if(solve(row, col + 1) || solve(row + 1, col) || solve(row, col - 1) || solve(row - 1, col)){
		return true;
	    }
	    maze[row][col] = '.';
	}
	
        //COMPLETE SOLVE

        return false; //so it compiles
    }
    private int[] findStart(){
	int[] start = new int[2];
	start[0] = -1;
	for( int row = 0; row < maze.length; row ++){
	    for ( int col = 0; col < maze[0].length; col ++){
		if(maze[row][col] == 'S'){
		    start[0] = row;
		    start[1] = col;
		}
	    }
	}
	if(start[0] == -1){
	    start[0] = -1;
	    start[1] = -1;
	}
	return start;
    }
	
    public String toString(){
	String out = "";

	for(int r = 0; r < maze.length; r ++){
	    for(int c = 0; c < maze[r].length; c ++){
		out += maze[r][c];
	    }
	    out += "\n";
	}
	return out;
    }
    private void wait (int millis){
	try {
	    Thread.sleep(millis);
	}catch (InterruptedException e){
	}
    }
    public static void main(String [] args){
	Maze m = new Maze("maze1.dat");
	System.out.println(m);
    }

}
