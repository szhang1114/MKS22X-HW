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
	if( solveH(0, 0, 1)){
	    System.out.println("done");
	}
	else System.out.println("unable to solve");
    }

    private boolean solveH(int row, int col, int level){
	if(level > r * c){
	    return true;
	}
	//prevent out of bounds exceptions
	if(row >= r || row < 0 || col >= c || col < 0){
	    return false;
	}
	if(board[row][col] == 0){
	    board[row][col] = level;
	    if( solveH(row + 1, col + 2, level + 1) ||  solveH(row + 1, col - 2, level + 1)||
		solveH(row - 1, col + 2, level + 1) ||  solveH(row - 1, col - 2, level + 1)||
		solveH(row + 2, col + 1, level + 1) ||  solveH(row + 2, col - 1, level + 1)||
		solveH(row - 2, col + 1, level + 1) ||  solveH(row - 2, col - 1, level + 1)){
		return true;
	    }
	    board[row][col] = 0;
	}
        
		
	return false;
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
	KnightBoard k = new KnightBoard(4, 4);
	k.solve();
	System.out.println(k);
	KnightBoard l = new KnightBoard(7, 7);
	l.solve();
	System.out.println(l);
    }
}
