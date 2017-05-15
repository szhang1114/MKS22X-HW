public class MyDeque{
    private String[] deque;
    private int front, back, size;
    
    public MyDeque(){
	size = 1;
	deque = new String[size];
	front = 0;
	back = 0;	
    }
    public void addFirst(String s){
	
    }

    public void addLast(String s){
	
    }

    public String removeFirst(){
	return "";
    }
    public String removeLast(){
	return "";
    }

    public String getFirst(){
	return "";
    }

    public String getLast(){
	return "";
    }

    public void resize(){
	size *= 2;
	String[] temp = new String[size];
	for(int i = front; i < deque.length;  i ++){
	    //if(i 
	    temp[i] = deque[i];
	}
    }
}
