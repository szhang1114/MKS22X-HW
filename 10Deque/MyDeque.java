public class MyDeque{
    private String[] deque;
    private int front, back, size;
    
    public MyDeque(){
	deque = new String[1];
	size = 0;
	front = 0;
	back = 0;	
    }
    public void addFirst(String s){
	if(s == null){
	    throw new NullPointerException;
	}
	if(size == deque.length){
	    resize();   
	}
	if(size == 0){
	    size ++;
	    deque[0] = s;
	}	

			      
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
	if(size == 0){
	    throw new NoSuchElementException();
	}
	return deque[front];
    }

    public String getLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	return deque[back];
    }

    public void resize(){
	if(size == 0){
	    size = 2;
	}
	else{
	    size *= 2;
	}
	String[] temp = new String[size];
	for(int i = front; i < deque.length;  i ++){
	    temp[i] = deque[i];
	}
	deque = temp;
    }
}
