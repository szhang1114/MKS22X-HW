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
	}
	return 0;
    }

    public int get(char c){
	if(c == 'r'){
	    return row;
	}
	if(c == 'c'){
	    return col;
	}
	if(c == 'S'){
	    return distToStart;
	}
	if(c == 'G'){
	    return distToGoal;
	}
	return 0;
    }
    
    public Location prev(){
	return previous;
    }

    public static void main(String[]args){
	Location l = new Location(1, 2, new Location(), 3, 4, false); 
	System.out.println(l.get('S'));
    }
}
