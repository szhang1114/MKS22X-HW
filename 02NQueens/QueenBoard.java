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
	getSolutionCount();
	if(board.length == 1){
	    board[0][0] = 1;
	    solutionCount = 1;
	}
	if(board.length > 3){
	    solveH(0);
	}
    }

    private boolean solveH(int c){
	if(c >= board.length){
	    //solutionCount ++;
	    return true;
	}

	for(int r = 0 ; r < board.length; r ++){
	    if( canPlace(r,c)){
		addQueen(r,c);
	        if(solveH(c + 1)){
		    return true;
		}
		else removeQueen(r, c);	
	    }
	    
	}
	return false;
    }
		
    
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

	int position = 1;
	while(c + position  < board.length){
	    board[r][c + position] --;
	    if (r + position < board.length){
		board[r + position][c]  --;
	    }
	    if(r - position >= 0){
		board[r - position][c + position]  --;
	    }
	    if(r + position < board.length){
		board[r + position][c + position]  --;
	    }
	    position ++;
	}

    }

    private void removeQueen(int r, int c){
	board[r][c] = 0;

	int position = 1;
	while(c + position  < board.length){
	    board[r][c + position]  ++;
	    if (r + position < board.length){
		board[r + position][c]  ++;
	    }
	    if(r - position >= 0){
		board[r - position][c + position]  ++;
	    }
	    if(r + position < board.length){
		board[r + position][c + position]  ++;
	    }
	    position ++;
	}

    }
    private boolean canPlace(int r, int c){
	return board[r][c] == 0;
    }
			  
    public int getSolutionCount(){
	
	if(board.length == 1){
	    return 1;
	}
	if(board.length > 3){
	    solutionCountH(0);
	    return solutionCount;
	}
			    

	return solutionCount;
	
    }
    
    public void countSolutions(){
	if(board.length == 1){
	    solutionCount = 1;
	}
	if(board.length > 3){
	    solutionCountH(0);
	}
    }
    public void clearBoard(){
	for(int r = 0; r < board.length; r ++){
	    for (int c = 0; c > board.length; c ++){
		board[r][c] = 0;
	    }
	}
    }

    private boolean solutionCountH(int c){
	if(c >= board.length){
	    solutionCount ++;
	    return true;
	}

	for(int r = 0 ; r < board.length; r ++){
	    if( canPlace(r,c)){
		addQueen(r,c);
	        solutionCountH(c + 1);
		removeQueen(r, c);	
	    }
	    
	}
	return false;
    }


    
    public String toString(){
	String out = "";
	for(int r = 0; r < board.length; r ++){
	    for(int c = 0; c < board.length; c ++){
		if(board[r][c] == 1){
		out += "Q " ;
		}
		else out += "_ ";
		    //out += board[r][c] + "  ";
		    }
	    out += "\n";
	}
	return out;
    }

    public static void main(String[]args){
	QueenBoard queenboard = new QueenBoard(10);

	//queenboard.addQueen(0,0);
	queenboard.solve();

	System.out.println(queenboard);
	queenboard.countSolutions();
	System.out.println(queenboard.solutionCount);
	//System.out.println(queenboard.getSolutionCount());
		
	//QueenBoard b = new QueenBoard(7);
	//b.solve();
	//System.out.println(b);
    }
}
