public class MazeSolver{

    private Maze board;
    private boolean animate;


    public MazeSolver(String filename){
	this(filename, false);
    }

    public MazeSolver(String filename, boolean animate){
	board = new Maze(filename);
	this.animate = animate;
    }
    public void solve(){

    }

    public void solve(int style){
	Frontier f = null;
	boolean astar = false;
	//DFS
	if(style == 0){
	    f = new FrontierStack();
	}
	//BFS
	if(style == 1){

	}
	//BestFirst
	if(style == 2){

	}
	//A*
	if(style == 3){
	    astar = true;
	}
	
	f.add(board.getStart());
	while(f.size() > 0){
	    Location current = f.next();	    
	    if(current.getDistToGoal() == 0){
		board.set(current.getRow(), current.getCol(), 'E');
		current = current.prev();
		while(current.getDistToStart() != 0){
		    board.set(current.getRow(), current.getCol(), '@');
		    current = current.prev();
		}
		board.set(current.getRow(), current.getCol(), 'S');
		if(animate){
		    System.out.println(board.toString(5));
		}
		return;
	    }
	    
	    board.set(current.getRow(), current.getCol(), '.');

	    if(board.get(current.getRow() + 1, current.getCol()) == ' '){
		Location next = new Location(current.getRow() + 1, current.getCol(), current, astar);
		next.setDistToGoal(next.getDist(board.getEnd()));
		next.setDistToStart(next.getDist(board.getStart()));
		f.add(next);
		board.set(next.getRow(), next.getCol(), '?');
	    }
	    if(board.get(current.getRow(), current.getCol()+ 1) == ' '){
		Location next = new Location(current.getRow(), current.getCol() + 1, current, astar);
		next.setDistToGoal(next.getDist(board.getEnd()));
		next.setDistToStart(next.getDist(board.getStart()));
		f.add(next);
		board.set(next.getRow(), next.getCol(), '?');
	    }
	    if(board.get(current.getRow() - 1, current.getCol()) == ' '){
		Location next = new Location(current.getRow() - 1, current.getCol(), current, astar);
		next.setDistToGoal(next.getDist(board.getEnd()));
		next.setDistToStart(next.getDist(board.getStart()));
		f.add(next);
		board.set(next.getRow(), next.getCol(), '?');
	    }
	    if(board.get(current.getRow(), current.getCol() - 1) == ' '){
		Location next = new Location(current.getRow(), current.getCol() - 1, current, astar);
		next.setDistToGoal(next.getDist(board.getEnd()));
		next.setDistToStart(next.getDist(board.getStart()));
		f.add(next);
		board.set(next.getRow(), next.getCol(), '?');
	    }
	    if(animate){
		System.out.println(board.toString(100));
	    }
	}
    }
    public String toString(){
	return board.toString();
    }

    

    public static void main(String[]a){
	MazeSolver m = new MazeSolver("data1.dat", true);
	m.solve(0);

    }
}
