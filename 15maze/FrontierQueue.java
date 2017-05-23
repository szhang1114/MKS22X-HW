import java.util.*;

public class FrontierQueue implements Frontier{

    private ArrayList<Location> que;

    public FrontierQueue(){
	que = new ArrayList<Location>();
    }
    public void add(Location l){

    }

    public Location next(){
	return new Location();
    }

    public int size(){
	return 0;
    }

}
