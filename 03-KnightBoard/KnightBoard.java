public class KnightBoard{
    private int[][] board;
    private int r;
    private int c;

    public KnightBoard(int startingRows, int startingCols){
	r = startingRows;
	c = startingCols;
	board = new int[startingRows][startingCols];
    }

    public void solve(){
	 solveH(0, 0, 1);
    }

    private boolean solveH(int row, int col, int level){
	if(level > r * c){
	    return true;
	}
	for(int rows = 0; rows < r; rows ++){
	    
	    

	}
	
	return false;
    }
    private boolean checkMove(int row, int col){
	if(board[row][col] != 0){
	    return false;
	}
	return true;	    
    }
    public String toString(){
	String out = "";
	    for(int row = 0; row < r; row ++){
		for(int col = 0; col < c; col ++){
		    if(board[row][col] < 10){
			out += " " + board[row][col] + " ";
		    }
		    else out += board[row][col] + " ";
		}
		out += "\n";
	    }
	return out;
    }


    public static void main(String[]args){
	KnightBoard k = new KnightBoard(5, 5);
	System.out.println(k);
    }
}
