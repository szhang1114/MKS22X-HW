public class MazeSolver{

    private Maze board;
    


    public MazeSolver(String filename){
	this(filename, false);
    }

    public MazeSolver(String filename, boolean animate){

    }
    public void solve(){

    }

    public void solve(int style){
	//DFS
	if(style == 0){
	    
	}
	//BFS
	if(style == 1){
	    Frontier explore = new FrontierQueue();
	}
	//BestFirst
	if(style == 2){

	}
	//A*
	if(style == 3){

	}
    }

    public String toString(){
	return board.toString();
    }
}
