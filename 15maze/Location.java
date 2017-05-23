public class Location implements Comparable<Location>{

    private int row, col;
    private int distToGoal, distToStart;
    private Location previous;
    private boolean aStar;

    public Location(int r, int c, Location previous, boolean aStar){
	row = r;
	col = c;
	this.previous = previous;
	this.aStar = aStar;
    }
    public Location(int r, int c, Location previous, int distToStart, int distToGoal, boolean aStar){
	row = r;
	col = c;
	this.previous = previous;
	this.distToStart = distToStart;
	this.distToGoal = distToGoal;
	this.aStar = aStar;
    }

    public int compareTo(Location other){
	if(aStar){
	    return (distToGoal + distToStart) - (other.distToGoal + other.distToStart);
	}
	return distToGoal - other.distToGoal;
    }

    public int getDist(Location other){
	return Math.abs(row - other.row) + Math.abs(col - other.col);
    }
	
    public int getDistToGoal(){
	return distToGoal;
    }

    public int getDistToStart(){
	return distToStart;
    }
    
    public void setDistToGoal(int dist){
	distToGoal = dist;
    }

    public void setDistToStart(int dist){
	distToStart = dist;
    }

    public int getRow(){
	return row;
    }

    public int getCol(){
	return col;
    }
    public Location prev(){
	return previous;
    }
}
