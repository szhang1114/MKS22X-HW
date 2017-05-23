import java.util.*;

public class FrontierStack implements Frontier{

    private Stack<Location> stack;

    public FrontierStack(){
	stack = new Stack<Location>();
    }
    public void add(Location l){
	stack.push(l);
    }

    public Location next(){
	return stack.pop();
    }

    public int size(){
	return stack.size();
    }
}
