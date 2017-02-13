public class QueenBoard{
    private int[][]board;
    private int solutionCount;
    
    public QueenBoard(int size){
	board = new int[size][size];
    }

    /**
     *precondition: board is filled with 0's only.
     *@return false when the board is not solveable. true otherwise.
     *postcondition: 
     *if false: board is still filled with 0's
     *if true: board is filled with the 
     *final configuration of the board after adding 
     *all n queens. Uses solveH
     */

    public void solve(){
	//for(int r = 0; r < board.length; r ++){
	//if(solveH){
		
	    
    }

    private boolean solveH(int col){
	
	return false;
    }
    private void updateBoard(){
	for(int r = 0; r < board.length; r ++){
	    for(int c = 0; c < board.length; c ++){
		if(board[r][c] == 1){
		    int fillC = c + 1;
		    while(fillC < board[r].length()
    
    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */
    public int getCount(){
    	return -1;
    }
    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    private void addQueen(int r, int c){
	board[r][c] = 1;
    }

    private void removeQueen(int r, int c){
	board[r][c] = 0;
    }

    public void countSolutions(){
	
    }


    
    public String toString(){
	String out = "";
	for(int r = 0; r < board.length; r ++){
	    for(int c = 0; c < board.length; c ++){
		out += board[r][c] + " ";
	    }
	    out += "\n";
	}
	return out;
    }

    public static void main(String[]args){
	QueenBoard queenboard = new QueenBoard(6);
	queenboard.addQueen(3, 5);
	System.out.println(queenboard);
    }
}
