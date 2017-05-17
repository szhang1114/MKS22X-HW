public class Location implements Comparable<Location>{

    private int row, col;
    private int distToGoal, distToStart;
    private Location previous;
    private boolean aStar;

    public Location(){
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
	    return (distToGoal + distToEnd) - (other.distToGoal + other.distToEnd);
	}
	return distToEnd - other.distToEnd;
    }

    public int getDist(Location other){
	return Math.abs(row - other.row) + Math.abs(col - other.col);
    }
	
    
    public Location prev(){
	return previous;
    }

    public static void main(String[]args){
	Location l = new Location(1, 2, new Location(), 3, 4, false); 
	System.out.println(l.get('S'));
    }
}
